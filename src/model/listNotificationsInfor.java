package model;

import java.util.ArrayList;

public class listNotificationsInfor {
	private ArrayList<patientNeedHelp> listPatient;

    // Constructor
    public listNotificationsInfor() {
        this.listPatient = new ArrayList<patientNeedHelp>();
    }

    // Getters and Setters
    public ArrayList<patientNeedHelp> getListPatient() {
        return listPatient;
    }

    public void setListPatient(ArrayList<patientNeedHelp> listPatient) {
        this.listPatient = listPatient;
    }
}
