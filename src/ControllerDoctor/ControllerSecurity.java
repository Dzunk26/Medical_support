package ControllerDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DataAccessObject.AccountDAO;
import ViewDoc.Doctor;

public class ControllerSecurity implements ActionListener{
	private Doctor viewDoctor;

    public ControllerSecurity(Doctor viewDoctor) {
        this.viewDoctor = viewDoctor;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Cancel")) {
            this.viewDoctor.getSecurity().getText_Password().setText("");
            this.viewDoctor.getSecurity().getText_NewPassword().setText("");
            this.viewDoctor.getSecurity().getText_RePassword().setText("");
            this.viewDoctor.showHome();
        } else if(s.equals("Save")) {
            if (this.viewDoctor.getSecurity().CheckPassword()) {
                if (this.viewDoctor.getSecurity().CheckRePassword()) {
                    this.viewDoctor.getSecurity().SaveChanges();
                    AccountDAO.getInstance().changePassword(this.viewDoctor.getSecurity().getAccs().getUsername(), this.viewDoctor.getSecurity().getTextRePassword());
                    JOptionPane.showMessageDialog(this.viewDoctor, "Successfull", "Change Password", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this.viewDoctor, "Re-Password incorrect, please try again", "Change Password", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this.viewDoctor, "Wrong password", "Change Password", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
