package ControllerLog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ControllerPatient.ControllerPatientFrame;
import DataAccessObject.AccountDAO;
import ViewAdmin.Admin;
import ViewDoc.Doctor;
import ViewLog.ViewLog;
import model.account;

public class LogIn_SignUp {
	private ControllerPatientFrame manage2;
	private ViewLog manage;
	private Doctor viewDoctor;
	private Admin viewAdmin;
	
	
	
	public LogIn_SignUp() {
		this.viewAdmin = new Admin();
		this.viewDoctor = new Doctor();
		this.manage = new ViewLog();
		this.manage2 = new ControllerPatientFrame(manage);
		addLoginAction();
		addSignUpAcction();
	}



	public void addLoginAction() {
//		tao actiionlistener cho nut login trong giao dien login
		manage.getLogIn().getjButton_LogIn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				check xem tai khoan da nhap co ton tai hay khong
				if(AccountDAO.getInstance().checkAccExist(manage.getLogIn().getText_UserName())) {
//					check xem mat khau co dung hay khong
					if(AccountDAO.getInstance().checkPassword(manage.getLogIn().getText_UserName(),manage.getLogIn().getText_Password())) {
						if(AccountDAO.getInstance().getTypeAcc(manage.getLogIn().getText_UserName(),manage.getLogIn().getText_Password()).equals("Patient")) {
							manage2.getManage2().setVisible(true);
							viewAdmin.dispose();
							viewDoctor.dispose();
							manage.dispose();
						}
						else if(AccountDAO.getInstance().getTypeAcc(manage.getLogIn().getText_UserName(),manage.getLogIn().getText_Password()).equals("Doctor")) {
							account res = new account(AccountDAO.getInstance().getID(manage.getLogIn().getText_UserName()), manage.getLogIn().getText_UserName(), manage.getLogIn().getText_Password());
							viewDoctor.getSecurity().setAccs(res);
							viewDoctor.setVisible(true);
							manage2.getManage2().dispose();
							viewAdmin.dispose();
							manage.dispose();
						}
						else{
							viewAdmin.setVisible(true);
							manage.dispose();
							viewDoctor.dispose();
							manage2.getManage2().dispose();
						}
					}
					else {
						manage.getLogIn().setText_Notice("Wrong password");
						manage.getLogIn().reset();
					}
				}
				else {
					manage.getLogIn().setText_Notice("Your account doesn't exist");
					manage.getLogIn().reset();
				}
			}
		});
		
//		tao actionlistener cho nut sign up trong giao dien login
		manage.getLogIn().getjButton_SignUp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manage.showSignUp();
				manage.getSignUp().reset();
			}
		});
	}
		
	public void addSignUpAcction() {
//		tao actionlistener cho nut back trong giao dien signup
		manage.getSignUp().getjButton_Back().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manage.getLogIn().reset();
				manage.showLogIn();
			}
		});
//		tao actionlistener cho nut sign up trong giao dien signup
		manage.getSignUp().getjButton_SignUp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (AccountDAO.getInstance().checkIDDoctor(manage.getSignUp().getText_ID().getText()) || AccountDAO.getInstance().checkIDPatient(manage.getSignUp().getText_ID().getText())) {
					if (!AccountDAO.getInstance().checkAccExist(manage.getSignUp().getText_UserName().getText())) {
						if (manage.getSignUp().getText_Password().equals(manage.getSignUp().getText_rePassword())) {
							if (manage.getSignUp().getjComboBox().getSelectedItem().toString().equals("Doctor")) {
								account res = new account(manage.getSignUp().getText_ID().getText(), manage.getSignUp().getText_UserName().getText(), manage.getSignUp().getText_Password());
								AccountDAO.getInstance().insertAccount(res,"Doctor");
								JOptionPane.showMessageDialog(manage, "You have successfully registered", "Inform", JOptionPane.INFORMATION_MESSAGE);
								manage.showLogIn();
							} else if (manage.getSignUp().getjComboBox().getSelectedItem().toString().equals("Patient")) {
								account res = new account(manage.getSignUp().getText_ID().getText(), manage.getSignUp().getText_UserName().getText(), manage.getSignUp().getText_Password());
								AccountDAO.getInstance().insertAccount(res,"Patient");
								JOptionPane.showMessageDialog(manage, "You have successfully registered", "Inform", JOptionPane.INFORMATION_MESSAGE);
								manage.showLogIn();
							} else {
								manage.getSignUp().getNotice().setText("You haven't done \"You are\" part yet");
							}
						} else {
							manage.getSignUp().getNotice().setText("Re-Password incorrect, please try again");
						}
					} else {
						manage.getSignUp().getNotice().setText("This ID already has account");
					}
				} else {
					manage.getSignUp().getNotice().setText("Your ID doesn't exists");
				}
			}
		});
	}
}
