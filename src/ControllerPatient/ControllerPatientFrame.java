package ControllerPatient;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import ControllerLog.LogIn_SignUp;
import DataAccessObject.AccountDAO;
import DataAccessObject.patientsDAO;
import ViewLog.ViewLog;
import ViewPatient.*;

public class ControllerPatientFrame{
	private ViewLog manage;
	private Patient manage2;
	private List<weeklyAlarm> alarms;
	
	boolean check=true;//dung check xem dang xu ly su kien cho jlabel Add hay cac jlabel Clock
	int indexListClock=0;
	
	public ControllerPatientFrame(ViewLog manage) {
		this.manage = manage;
		this.manage2 = new Patient();
		alarms = new ArrayList<weeklyAlarm>();
		addMenuActionListener();
		addNotyfiAcction();
		addSettingAction();
		addSetProfileAcction();
		addChangePassAction();
	}
	
//	tao actionlistener cho cac menuitems 
	public void addMenuActionListener() {
//		chuyen sang panel notify neu bam vao menuitem Notify
		manage2.getAlmenu().getMnotify().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().getCard().show(manage2.getAlpanel(), "notify");
			}
		});
		
//		chuyen sang panel info neu bam vao menuitem Infomation
		manage2.getAlmenu().getMinfo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().setPasInfor(patientsDAO.getInstance().getInfor(AccountDAO.getInstance().getID(manage.getLogIn().getText_UserName())));
				manage2.getAlpanel().getPatientInfor();
				manage2.getAlpanel().getCard().show(manage2.getAlpanel(), "info");
			}
		});
		
//		chuyen sang panel setting neu bam vao menuitem Setting
		manage2.getAlmenu().getMsetting().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().getCard().show(manage2.getAlpanel(), "setting");
			}
		});
	}
	
//	tao actionlistener cho cac nut trong class notify
	public void addNotyfiAcction() {
//		tao mouselistener cho jlabel add trong panel normal
		manage2.getAlpanel().getAddLabel().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				check=true;
				manage2.getAlpanel().callAddSetClock();
				manage2.getAlpanel().getNotifyLayout().show(manage2.getAlpanel().getPnotify(),"setclock"+(manage2.getAlpanel().getListSetClockPanel().size()-1));
				weeklyAlarm alarm = null;
				alarms.add(alarm);
				addSaveAndCancelAcction();
			}
		});
		
		manage2.getAlpanel().getUrgenccyButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!patientsDAO.getInstance().checkExistPatientNeedHelp(AccountDAO.getInstance().getID(manage.getLogIn().getText_UserName())))
					patientsDAO.getInstance().insertPatientNeedHelp(patientsDAO.getInstance().getInfor(AccountDAO.getInstance().getID(manage.getLogIn().getText_UserName())));
			}
		});
	}
	
	public void addSaveAndCancelAcction() {
//		tao acctionlistener cho nut save trong panel setclock
		manage2.getAlpanel().getSaveButton().get(manage2.getAlpanel().getSaveButton().size()-1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().getNotifyLayout().show(manage2.getAlpanel().getPnotify(),"normal");
//				check xem nut save dang xu ly cho viec add clock moi hay la dang chinh lai thong tin cua clock da co
				if(check) {//neu dang xu ly cho viec add clock
					manage2.getAlpanel().callAddClock(manage2.getAlpanel().getListSetClockPanel().size()-1);
					addSetClockAction();//tao actionlistener cho jlabel moi duoc tao
					addOn_offsAction();// tao actionlistener cho jcheckbox moi duoc tao
				}
				else {//neu dang xu ly cho viec chinh lai thong tin cua clock da co
//					set lai thong tin cho jlabel duoc bam
					manage2.getAlpanel().getListClockLabel().get(indexListClock).setText(manage2.getAlpanel().getClockInfomation(indexListClock));
					if(alarms.get(indexListClock)!=null)
						alarms.get(indexListClock).getTimer().cancel();
					if(manage2.getAlpanel().getListOn_offs().get(indexListClock).isSelected()) {
						updateClock(indexListClock);
						addAlarmAction(indexListClock);
					}
				}
			}
		});
		
//		tao actionlistener cho nut cancel trong panel sectclock
		manage2.getAlpanel().getCancelButton().get(manage2.getAlpanel().getCancelButton().size()-1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().getNotifyLayout().show(manage2.getAlpanel().getPnotify(),"normal");
			}
		});
	}
	
	public void addAlarmAction(int index) {
		alarms.get(index).getAlarm().getStop().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alarms.get(index).getSound().getMusic().close();
			}
		});
	}
	
//	tao mouselistener click cho cac jlabel clock trong panel normal cua class notify
	public void addSetClockAction() {
		manage2.getAlpanel().getClock(manage2.getAlpanel().getListClockLabel().size()-1).addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				tra ve vi tri jlabel dang duoc bam cho bien toan cuc
				for(int i=0 ; i<manage2.getAlpanel().getListClockLabel().size() ; i++)
					if(e.getSource()==manage2.getAlpanel().getListClockLabel().get(i))
						indexListClock=i;
				manage2.getAlpanel().getNotifyLayout().show(manage2.getAlpanel().getPnotify(),"setclock"+indexListClock);
				check=false;
			}
		});
	}
	
//	tao itemlistener cho cac nut jcheckbox trong panel normal cua class notify
	public void addOn_offsAction() {
		manage2.getAlpanel().getOn_off(manage2.getAlpanel().getListOn_offs().size()-1).addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JRadioButton tmp = (JRadioButton) e.getSource();
				if(tmp.isSelected()) {//neu nut dang duoc chon
					updateClock(manage2.getAlpanel().getListOn_offs().size()-1);
					addAlarmAction(manage2.getAlpanel().getListOn_offs().size()-1);
				}
				else { //neu nut khong duoc chon 
					alarms.get(manage2.getAlpanel().getListOn_offs().size()-1).getTimer().cancel();
				}
			}
		});
	}
	
//	tao actionlistener cho cac nut trong panel setting
	public void addSettingAction() {
//		chuyen sang panel setProPanel neu bam vao button Set Profile
		manage2.getAlpanel().getSetProButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().setPasSetting(patientsDAO.getInstance().getInfor(AccountDAO.getInstance().getID(manage.getLogIn().getText_UserName())));
				manage2.getAlpanel().getPatientSetting();
				manage2.getAlpanel().getSetLayout().show(manage2.getAlpanel().getPsetting(),"setProPanel");
			}
		});
		
//		chuyen sang panel changePassPanel neu bam vao button Change Password
		manage2.getAlpanel().getChangePassButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().resetChangePass();
				manage2.getAlpanel().getSetLayout().show(manage2.getAlpanel().getPsetting(),"changePassPanel");
			}
		});
		
//		tat giao dien hien tai, khoi tao lai giao dien moi neu bam vao button Log out
		manage2.getAlpanel().getLogOutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.dispose();
				new LogIn_SignUp();
			}
		});
	}
	
//	tao actionlisten cho set profile
	public void addSetProfileAcction() {
//		tao actionlistener cho nut save
		manage2.getAlpanel().getSaveSetPro().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0 ; i<manage2.getAlpanel().getContentSetting().length ; i++) {
					manage2.getAlpanel().getContentInfo()[i].setText(manage2.getAlpanel().getContentSetting()[i].getText());
				}
				if(manage2.getAlpanel().checkBirthForm(manage2.getAlpanel().getContentSetting()[3].getText()))
	        		if(manage2.getAlpanel().checkEmailForm(manage2.getAlpanel().getContentSetting()[5].getText()))
	        			if(manage2.getAlpanel().checkPhoneForm(manage2.getAlpanel().getContentSetting()[4].getText())) {
	        				manage2.getAlpanel().getNewInforSetting();
	        				patientsDAO.getInstance().update(manage2.getAlpanel().getPasSetting());
	        				manage2.getAlpanel().getSetLayout().show(manage2.getAlpanel().getPsetting(),"defaultPanel");
	        			}
	        			else
	        				JOptionPane.showMessageDialog(manage2, "Please check your phone number again", "Phone", JOptionPane.INFORMATION_MESSAGE);
	        		else
	        			JOptionPane.showMessageDialog(manage2, "Please check your email again", "Email", JOptionPane.INFORMATION_MESSAGE);
	        	else 
	        		JOptionPane.showMessageDialog(manage2, "Birth form is \"yyyy:MM:dd\". Please check your birth again", "Birth", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
//		tao actionlistener cho nut cancel
		manage2.getAlpanel().getCancelSetPro().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().getSetLayout().show(manage2.getAlpanel().getPsetting(),"defaultPanel");
			}
		});
	}
	
//	tao actionlistener cho phan change password
	public void addChangePassAction() {
		manage2.getAlpanel().getSaveChangePass().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				neu dung mat khau cu
				if(AccountDAO.getInstance().checkPassword(manage.getLogIn().getText_UserName(), manage2.getAlpanel().getOldPassword()))
//					neu mat khau moi va mat nhap lai khau moi trung nhau
					if(manage2.getAlpanel().getNewPassword().equals(manage2.getAlpanel().getRe_NewPassword())) {
						AccountDAO.getInstance().changePassword(manage.getLogIn().getText_UserName(),manage2.getAlpanel().getNewPassword());
						manage2.getAlpanel().getSetLayout().show(manage2.getAlpanel().getPsetting(),"defaultPanel");
						JOptionPane.showMessageDialog(manage2, "Successfull", "Change Password", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(manage2, "Re-Password incorrect, please try again", "Change Password", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(manage2, "Wrong password", "Change Password", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
//		tao actionlistener cho nut cancel
		manage2.getAlpanel().getCancelChangePass().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage2.getAlpanel().getSetLayout().show(manage2.getAlpanel().getPsetting(),"defaultPanel");
			}
		});
	}
	
	public void updateClock(int index) {
		weeklyAlarm alarm = new weeklyAlarm(manage2.getAlpanel().getTimetable(index));
		alarms.set(index,alarm);
		if(!manage2.getAlpanel().checkCountDaysRepeat(index))
			alarms.get(index).startRepeat((int)manage2.getAlpanel().getClockHour(index).getValue(),(int)manage2.getAlpanel().getClocksMinute(index).getValue(),(String)manage2.getAlpanel().getListMusic(index).getSelectedItem());
		else alarms.get(index).startNotRepeat((int)manage2.getAlpanel().getClockHour(index).getValue(),(int)manage2.getAlpanel().getClocksMinute(index).getValue(),(String)manage2.getAlpanel().getListMusic(index).getSelectedItem());
	}

	public Patient getManage2() {
		return manage2;
	}

	public void setManage2(Patient manage2) {
		this.manage2 = manage2;
	}
}
