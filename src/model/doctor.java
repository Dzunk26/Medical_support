package model;

import java.sql.Date;

public class doctor {
	// Basic Information
    private String id, name, sex, phone, email;
    private Date birth;
    // Professional Information: chuyên khoa, chức vụ, bằng cấp, kinh nghiệm
    private String specialist, position, degree, experience;
    
    // Constructor
    public doctor() {
        this.id = "";
        this.name = "";
        this.birth = new Date(1999, 1, 1);
        this.sex = "";
        this.phone = "";
        this.email = "";
        this.specialist = "";
        this.position = "";
        this.degree = "";
        this.experience = "";
    }

	public doctor(String id, String name, Date birth, String sex, String phone, String email,
            String specialist, String position, String degree, String experience) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.specialist = specialist;
        this.position = position;
        this.degree = degree;
        this.experience = experience;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String toString() {
		return "ModelInformation [id=" + id + ", name=" + name + ", birth=" + birth + ", sex=" + sex + ", phone="
				+ phone + ", email=" + email + ", specialist=" + specialist + ", position=" + position + ", degree="
				+ degree + ", experience=" + experience + "]";
	}
}
