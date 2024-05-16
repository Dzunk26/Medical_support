package ControllerAdmins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ControllerLog.LogIn_SignUp;
import ViewAdmin.Admin;

public class ControllerAdmin implements ActionListener{
	private Admin viewAdmin;

    public ControllerAdmin(Admin viewAdmin) {
        this.viewAdmin = viewAdmin;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Exit")) {
            System.exit(0);
        } else if(s.equals("Home")) {
            this.viewAdmin.showHome();
        } else if(s.equals("Doctor")) {
        	this.viewAdmin.getDoctor().reset();
            this.viewAdmin.showDoctor();
        } else if(s.equals("Patient")) {
        	this.viewAdmin.getPatient().reset();
            this.viewAdmin.showPatient();
        } else if(s.equals("Account")) {
        	this.viewAdmin.getAccount().reset();
            this.viewAdmin.showAccount();
        } else if(s.equals("Insert Account")) {
            this.viewAdmin.showInsertAccount();
        } else if(s.equals("Insert Doctor")) {
            this.viewAdmin.showInsertDoctor();
        } else if(s.equals("Insert Patient")) {
            this.viewAdmin.showInsertPatient();
        } else if(s.equals("Log out")) {
            this.viewAdmin.dispose();
            new LogIn_SignUp();
        }
    }
}
