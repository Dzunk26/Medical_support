package ControllerAdmins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DataAccessObject.patientsDAO;
import ViewAdmin.Admin;

public class ControllerJPanelPatient implements ActionListener{
	private Admin viewAdmin;

    public ControllerJPanelPatient(Admin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Search")) {
            if (patientsDAO.getInstance().checkExistPatient(this.viewAdmin.getPatient().getText_Search().getText())) {
                this.viewAdmin.getPatient().getInfor(patientsDAO.getInstance().getInfor(this.viewAdmin.getPatient().getText_Search().getText()));
            } else {
                int choice = JOptionPane.showConfirmDialog(this.viewAdmin, "NOT EXIST !!!\nDo you want to find another patient ?", "Search", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                this.viewAdmin.getPatient().reset();
                if (choice != 0) {
                    this.viewAdmin.showHome();
                }
            }
        } else if(s.equals("Cancel")) {
//            this.viewAdmin.getPatient().getInfor(this.viewAdmin.getPatient().getPas());
             this.viewAdmin.showHome();
        } else if(s.equals("Save")) {
        	if(viewAdmin.getPatient().checkBirth(viewAdmin.getPatient().getText_Birh().getText()))
        		if(viewAdmin.getPatient().checkEmail(viewAdmin.getPatient().getText_Email().getText()))
        			if(viewAdmin.getPatient().checkPhone(viewAdmin.getPatient().getText_Phone().getText())) {
        				this.viewAdmin.getPatient().Save();
        	            patientsDAO.getInstance().update(this.viewAdmin.getPatient().getPas());
        	            JOptionPane.showMessageDialog(this.viewAdmin, "Successfull", "Save Changes", JOptionPane.INFORMATION_MESSAGE);
        			}
        			else
        				JOptionPane.showMessageDialog(this.viewAdmin, "Please check your phone number again", "Phone", JOptionPane.INFORMATION_MESSAGE);
        		else
        			JOptionPane.showMessageDialog(this.viewAdmin, "Please check your email again", "Email", JOptionPane.INFORMATION_MESSAGE);
        	else 
        		JOptionPane.showMessageDialog(this.viewAdmin, "Birth form is \"yyyy:MM:dd\". Please check your birth again", "Birth", JOptionPane.INFORMATION_MESSAGE);
        } else if (s.equals("Delete")) {
            this.viewAdmin.getPatient().reset();
            patientsDAO.getInstance().delete(this.viewAdmin.getPatient().getPas());
            JOptionPane.showMessageDialog(this.viewAdmin, "Successfull", "Delete", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
