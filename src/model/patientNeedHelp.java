package model;

public class patientNeedHelp {
	// Infor
    private String id, name, room, building;

    // Constructor
    public patientNeedHelp() {
        this.id = "";
        this.name = "";
        this.room = "";
        this.building = "";
    }

    public patientNeedHelp(String id, String name, String room, String building) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.building = building;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    // Print
    public String toString() {
        return "ID: " + id +  "\t\t\t\tRoom: " + room + "\nName: " + name + "\t\t\tBuilding: " + building;
    }
}
