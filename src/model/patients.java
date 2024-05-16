package model;

import java.sql.Date;

public class patients {
	// Information
    private String id, sid, name, sex, phone, email, address, room, building, disease;
    private Date birth;
        
    // Constructor
    public patients() {
        this.id = "";
        this.sid = "";
        this.name = "";
        this.birth = new Date(1999, 1, 1);
        this.sex = "";
        this.phone = "";
        this.email = "";
        this.address = "";
        this.room = "";
        this.building = "";
        this.disease = "";
    }

    public patients(String id, String sid, String name, Date birth, String sex, String phone, String email,
            String address, String room, String building, String disease) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.room = room;
        this.building = building;
        this.disease = disease;
    }

    // Getters and Setters
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
