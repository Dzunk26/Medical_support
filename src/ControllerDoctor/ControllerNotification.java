package ControllerDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataAccessObject.patientsDAO;
import ViewDoc.Doctor;

public class ControllerNotification implements ActionListener{
	private Doctor viewDoctor;

    public ControllerNotification(Doctor viewDoctor) {
        this.viewDoctor = viewDoctor;
    }
    
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Done")) {
        for (int i=this.viewDoctor.getNotification().getListPatientNeedHelp().size()-1; i>=0; i--) {
            if (this.viewDoctor.getNotification().getListPatientNeedHelp().get(i).isSelected()) {
                patientsDAO.getInstance().deletePatientNeedHelp(this.viewDoctor.getNotification().getModelNotification().getListPatient().get(i).getId());
                this.viewDoctor.getNotification().getListContent().remove(i);
                this.viewDoctor.getNotification().getListPatientNeedHelp().remove(i);
                this.viewDoctor.getNotification().getjPanel_Details().remove(i);
            }
        }
    }
        this.viewDoctor.getNotification().revalidate();
        this.viewDoctor.getNotification().repaint();
    }
}
