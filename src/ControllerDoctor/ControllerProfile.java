package ControllerDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataAccessObject.DoctorDAO;
import ViewDoc.Doctor;

public class ControllerProfile implements ActionListener{
	private Doctor viewDoctor;

    public ControllerProfile(Doctor viewDoctor) {
        this.viewDoctor = viewDoctor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Cancel")) {
//             this.viewDoctor.getProfile().getInfor(this.viewDoctor.getInformation().getDoctorInfo());
             this.viewDoctor.showHome();
        } else if(s.equals("Save")) {
        	if(viewDoctor.getProfile().checkBirth(viewDoctor.getProfile().getText_Birh().getText()))
        		if(viewDoctor.getProfile().checkEmail(viewDoctor.getProfile().getText_Email().getText()))
        			if(viewDoctor.getProfile().checkPhone(viewDoctor.getProfile().getText_Phone().getText())) {
			            this.viewDoctor.getProfile().Save();
			            this.viewDoctor.getInformation().getInfor(this.viewDoctor.getProfile().getDoctorInfor());
			            DoctorDAO.getInstance().update(this.viewDoctor.getProfile().getDoctorInfor());
			            this.viewDoctor.showHome();
        			}
        			else
        				JOptionPane.showMessageDialog(this.viewDoctor, "Please check your phone number again", "Phone", JOptionPane.INFORMATION_MESSAGE);
        		else
        			JOptionPane.showMessageDialog(this.viewDoctor, "Please check your email again", "Email", JOptionPane.INFORMATION_MESSAGE);
        	else 
        		JOptionPane.showMessageDialog(this.viewDoctor, "Birth form is \"yyyy:MM:dd\". Please check your birth again", "Birth", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
