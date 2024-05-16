package ControllerDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DataAccessObject.patientsDAO;
import ViewDoc.Doctor;

public class ControllerSearch implements ActionListener{
	private Doctor viewDoctor;

    public ControllerSearch(Doctor viewDoctor) {
        this.viewDoctor = viewDoctor;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Search")) {
            if (patientsDAO.getInstance().checkExistPatient(this.viewDoctor.getSearch().getIDSearch())) {
                this.viewDoctor.getSearch().getInfor(patientsDAO.getInstance().getInfor(this.viewDoctor.getSearch().getIDSearch()));
            } else {
                int choice = JOptionPane.showConfirmDialog(this.viewDoctor, "NOT EXIST !!!\nDo you want to find another patient ?", "Search", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                this.viewDoctor.getSearch().reset();
                if (choice != 0) {
                    this.viewDoctor.showHome();
                }
            }
        }
    }
}
