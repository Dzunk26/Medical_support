package ControllerAdmins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DataAccessObject.DoctorDAO;
import ViewAdmin.Admin;

public class ControllerJPanelDoctor implements ActionListener{
	private Admin viewAdmin;

    public ControllerJPanelDoctor(Admin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Search")) {
            if (DoctorDAO.getInstance().checkExist(this.viewAdmin.getDoctor().getText_Search().getText())) {
                this.viewAdmin.getDoctor().getInfor(DoctorDAO.getInstance().getInfor(this.viewAdmin.getDoctor().getText_Search().getText()));
            } else {
                int choice = JOptionPane.showConfirmDialog(this.viewAdmin, "NOT EXIST !!!\nDo you want to find another doctor ?", "Search", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                this.viewAdmin.getDoctor().reset();
                if (choice != 0) {
                    this.viewAdmin.showHome();
                }
            }
        } else if(s.equals("Cancel")) {
//            this.viewAdmin.getDoctor().getInfor(this.viewAdmin.getDoctor().getDoctorInfor());
             this.viewAdmin.showHome();
        } else if(s.equals("Save")) {
        	if(viewAdmin.getDoctor().checkBirth(viewAdmin.getDoctor().getText_Birh().getText()))
        		if(viewAdmin.getDoctor().checkEmail(viewAdmin.getDoctor().getText_Email().getText()))
        			if(viewAdmin.getDoctor().checkPhone(viewAdmin.getDoctor().getText_Phone().getText())) {
        				this.viewAdmin.getDoctor().Save();
        	            DoctorDAO.getInstance().update(this.viewAdmin.getDoctor().getDoctorInfor());
        	            JOptionPane.showMessageDialog(this.viewAdmin, "Successfull", "Save Changes", JOptionPane.INFORMATION_MESSAGE);
        			}
        			else
        				JOptionPane.showMessageDialog(this.viewAdmin, "Please check your phone number again", "Phone", JOptionPane.INFORMATION_MESSAGE);
        		else
        			JOptionPane.showMessageDialog(this.viewAdmin, "Please check your email again", "Email", JOptionPane.INFORMATION_MESSAGE);
        	else 
        		JOptionPane.showMessageDialog(this.viewAdmin, "\"Birth form is \\\"yyyy:MM:dd\\\". Please check your birth again\"", "Birth", JOptionPane.INFORMATION_MESSAGE);
        } else if (s.equals("Delete")) {
            this.viewAdmin.getDoctor().reset();
            DoctorDAO.getInstance().delete(this.viewAdmin.getDoctor().getDoctorInfor());
            JOptionPane.showMessageDialog(this.viewAdmin, "Successfull", "Delete", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
