package ControllerAdmins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DataAccessObject.DoctorDAO;
import DataAccessObject.patientsDAO;
import ViewAdmin.Admin;

public class ControllerJPanelInsert implements ActionListener{
	private Admin viewAdmin;

    public ControllerJPanelInsert(Admin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Insert doctor")) {
            if (!DoctorDAO.getInstance().checkExist(this.viewAdmin.getInsertDoctor().getText_ID().getText())) {
            	if(viewAdmin.getInsertDoctor().checkBirth(viewAdmin.getInsertDoctor().getText_Birh().getText()))
            		if(viewAdmin.getInsertDoctor().checkEmail(viewAdmin.getInsertDoctor().getText_Email().getText()))
            			if(viewAdmin.getInsertDoctor().checkPhone(viewAdmin.getInsertDoctor().getText_Phone().getText())) {
            				this.viewAdmin.getInsertDoctor().Update();
                            DoctorDAO.getInstance().insert(this.viewAdmin.getInsertDoctor().getDoc());
                            JOptionPane.showMessageDialog(this.viewAdmin, "Insert Successfully", "Insert Doctor", JOptionPane.ERROR_MESSAGE);
            			}
            			else
            				JOptionPane.showMessageDialog(this.viewAdmin, "Please check your phone number again", "Phone", JOptionPane.INFORMATION_MESSAGE);
            		else
            			JOptionPane.showMessageDialog(this.viewAdmin, "Please check your email again", "Email", JOptionPane.INFORMATION_MESSAGE);
            	else 
            		JOptionPane.showMessageDialog(this.viewAdmin, "Birth form is \"yyyy:MM:dd\". Please check your birth again", "Birth", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.viewAdmin, "ID already exists", "Insert Doctor", JOptionPane.ERROR_MESSAGE);
            }
        } else if (s.equals("Insert patient")) {
            if (!patientsDAO.getInstance().checkExistPatient(this.viewAdmin.getInsertPatient().getText_ID().getText())) {
            	if(viewAdmin.getInsertPatient().checkBirth(viewAdmin.getInsertPatient().getText_Birh().getText()))
            		if(viewAdmin.getInsertPatient().checkEmail(viewAdmin.getInsertPatient().getText_Email().getText()))
            			if(viewAdmin.getInsertPatient().checkPhone(viewAdmin.getInsertPatient().getText_Phone().getText())) {
            				this.viewAdmin.getInsertPatient().Update();
                            patientsDAO.getInstance().insert(this.viewAdmin.getInsertPatient().getPa());
                            JOptionPane.showMessageDialog(this.viewAdmin, "Insert Successfully", "Insert Patient", JOptionPane.ERROR_MESSAGE);
            			}
            			else
            				JOptionPane.showMessageDialog(this.viewAdmin, "Please check your phone number again", "Phone", JOptionPane.INFORMATION_MESSAGE);
            		else
            			JOptionPane.showMessageDialog(this.viewAdmin, "Please check your email again", "Email", JOptionPane.INFORMATION_MESSAGE);
            	else 
            		JOptionPane.showMessageDialog(this.viewAdmin, "Birth form is \"yyyy:MM:dd\". Please check your birth again", "Birth", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this.viewAdmin, "ID already exists", "Insert Patient", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
