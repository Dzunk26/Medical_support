package ControllerDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ControllerLog.LogIn_SignUp;
import DataAccessObject.DoctorDAO;
import ViewDoc.Doctor;

public class ControllerDoctor implements ActionListener{
	private Doctor viewDoctor;

    public ControllerDoctor(Doctor viewDoctor) {
        this.viewDoctor = viewDoctor;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Exit")) {
            System.exit(0);
        } else if(s.equals("Home")) {
            this.viewDoctor.showHome();
        } else if(s.equals("Notification")) {
            this.viewDoctor.getNotification().getList();
            this.viewDoctor.showNotification();
        } else if(s.equals("Information")) {
            this.viewDoctor.getInformation().getInfor(DoctorDAO.getInstance().getInfor(this.viewDoctor.getSecurity().getAccs().getId()));
            this.viewDoctor.showInformation();
        } else if(s.equals("Search")) {
        	this.viewDoctor.getSearch().reset();
            this.viewDoctor.showSearch();
        } else if(s.equals("Profile")) {
            this.viewDoctor.getProfile().getInfor(DoctorDAO.getInstance().getInfor(this.viewDoctor.getSecurity().getAccs().getId()));
            this.viewDoctor.showProfile();
        } else if(s.equals("Security")) {
            this.viewDoctor.showSecurity();
        } else if(s.equals("Log out")) {
            this.viewDoctor.dispose();
            new LogIn_SignUp();
        }
    }
}
