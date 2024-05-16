package ViewDoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.doctor;

public class Profile extends JPanel{
	private doctor doctorInfor;
    private JTextField text_Name;
    private JTextField text_Birh;
    private JComboBox<String> text_Sex;
    private JTextField text_Phone;
    private JTextField text_Email;
    private JTextField text_Specialist;
    private JTextField text_Position;
    private JTextField text_Degree;
    private JTextField text_Experience;
    private JTextField text_ID;
    private JButton jButton_Cancel;
    private JButton jButton_Save;

    // Constructor
    public Profile() {
        this.doctorInfor = new doctor();
        this.run();
    }

    public void run() {
        // Font
        Font font_header = new Font("Segoe UI", Font.BOLD, 20);
        Font font_jLabel = new Font("Segoe UI", Font.BOLD, 12);
        Font font_jTextField = new Font("Segoe UI", Font.PLAIN, 12);
        
        
        // Header
        JPanel headerJPanel = new JPanel();
        headerJPanel.setLayout(new FlowLayout());
        JLabel headerInformation = new JLabel("Setting Profile");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);

        // Details
        JLabel jLabel_ID = new JLabel("ID: ");
        jLabel_ID.setFont(font_jLabel);
        text_ID = new JTextField(this.doctorInfor.getId());
        text_ID.setFont(font_jTextField);
        text_ID.setEditable(false);
        text_ID.setBackground(Color.WHITE);

        JLabel jLabel_Name = new JLabel("Name: ");
        jLabel_Name.setFont(font_jLabel);
        text_Name = new JTextField(this.doctorInfor.getName());
        text_Name.setFont(font_jTextField);
        text_Name.setEditable(true);
        text_Name.setBackground(Color.WHITE);

        JLabel jLabel_Birth = new JLabel("Birth: ");
        jLabel_Birth.setFont(font_jLabel);
        text_Birh = new JTextField(this.doctorInfor.getBirth().toString());
        text_Birh.setFont(font_jTextField);
        text_Birh.setEditable(true);
        text_Birh.setBackground(Color.WHITE);

        JLabel jLabel_Sex = new JLabel("Sex: ");
        jLabel_Sex.setFont(font_jLabel);
        String sex[] = {"Nam", "Nữ"};
        text_Sex = new JComboBox<String>(sex);
        text_Sex.setSelectedItem(doctorInfor.getSex());
        text_Sex.setFont(font_jTextField);
        text_Sex.setBackground(Color.WHITE);

        JLabel jLabel_Phone = new JLabel("Phone: ");
        jLabel_Phone.setFont(font_jLabel);
        text_Phone = new JTextField(this.doctorInfor.getPhone());
        text_Phone.setFont(font_jTextField);
        text_Phone.setEditable(true);
        text_Phone.setBackground(Color.WHITE);

        JLabel jLabel_Email = new JLabel("Email: ");
        jLabel_Email.setFont(font_jLabel);
        text_Email = new JTextField(this.doctorInfor.getEmail());
        text_Email.setFont(font_jTextField);
        text_Email.setEditable(true);
        text_Email.setBackground(Color.WHITE);

        JLabel jLabel_Specialist = new JLabel("Specialist: ");
        jLabel_Specialist.setFont(font_jLabel);
        text_Specialist = new JTextField(this.doctorInfor.getSpecialist());
        text_Specialist.setFont(font_jTextField);
        text_Specialist.setEditable(false);
        text_Specialist.setBackground(Color.WHITE);

        JLabel jLabel_Position = new JLabel("Position: ");
        jLabel_Position.setFont(font_jLabel);
        text_Position = new JTextField(this.doctorInfor.getPosition());
        text_Position.setFont(font_jTextField);
        text_Position.setEditable(false);
        text_Position.setBackground(Color.WHITE);

        JLabel jLabel_Degree = new JLabel("Degree: ");
        jLabel_Degree.setFont(font_jLabel);
        text_Degree = new JTextField(this.doctorInfor.getDegree());
        text_Degree.setFont(font_jTextField);
        text_Degree.setEditable(false);
        text_Degree.setBackground(Color.WHITE);

        JLabel jLabel_Experience = new JLabel("Experience: ");
        jLabel_Experience.setFont(font_jLabel);
        text_Experience = new JTextField(this.doctorInfor.getExperience());
        text_Experience.setFont(font_jTextField);
        text_Experience.setEditable(false);
        text_Experience.setBackground(Color.WHITE);


        // Location
        JPanel jPanel_Details = new JPanel();
        jPanel_Details.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(jLabel_ID, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_Specialist, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Position, c);
        c.gridy = 3;
        jPanel_Details.add(jLabel_Degree, c);
        c.gridy = 4;
        jPanel_Details.add(jLabel_Experience, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.4;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_ID, c);
        c.gridy = 1;
        jPanel_Details.add(text_Specialist, c);
        c.gridy = 2;
        jPanel_Details.add(text_Position, c);
        c.gridy = 3;
        jPanel_Details.add(text_Degree, c);
        c.gridy = 4;
        jPanel_Details.add(text_Experience, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(jLabel_Name, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_Birth, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Sex, c);
        c.gridy = 3;
        jPanel_Details.add(jLabel_Email, c);
        c.gridy = 4;
        jPanel_Details.add(jLabel_Phone, c);
        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 0.4;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_Name, c);
        c.gridy = 1;
        jPanel_Details.add(text_Birh, c);
        c.gridy = 2;
        jPanel_Details.add(text_Sex, c);
        c.gridy = 3;
        jPanel_Details.add(text_Email, c);
        c.gridy = 4;
        jPanel_Details.add(text_Phone, c);


        // Button
        jButton_Cancel = new JButton("Cancel");
        jButton_Cancel.setFont(font_jTextField);

        jButton_Save = new JButton("Save");
        jButton_Save.setFont(font_jTextField);

        JPanel jPanel_Button = new JPanel(new FlowLayout());
        jPanel_Button.add(jButton_Cancel);
        jPanel_Button.add(jButton_Save);



        // Layout
        this.setLayout(new BorderLayout());

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(jPanel_Button, BorderLayout.SOUTH);
    }

    // Getters and Setters
    public JButton getjButton_Cancel() {
        return jButton_Cancel;
    }

    public void setjButton_Cancel(JButton jButton_Cancel) {
        this.jButton_Cancel = jButton_Cancel;
    }

    public JButton getjButton_Save() {
        return jButton_Save;
    }

    public void setjButton_Save(JButton jButton_Save) {
        this.jButton_Save = jButton_Save;
    }

    public doctor getDoctorInfor() {
        return doctorInfor;
    }

    public void setDoctorInfor(doctor doctorInfor) {
        this.doctorInfor = doctorInfor;
    }

    public JTextField getText_Name() {
        return text_Name;
    }

    public void setText_Name(JTextField text_Name) {
        this.text_Name = text_Name;
    }

    public JTextField getText_Birh() {
        return text_Birh;
    }

    public void setText_Birh(JTextField text_Birh) {
        this.text_Birh = text_Birh;
    }

    public JComboBox<String> getText_Sex() {
        return text_Sex;
    }

    public void setText_Sex(JComboBox<String> text_Sex) {
        this.text_Sex = text_Sex;
    }

    public JTextField getText_Phone() {
        return text_Phone;
    }

    public void setText_Phone(JTextField text_Phone) {
        this.text_Phone = text_Phone;
    }

    public JTextField getText_Email() {
        return text_Email;
    }

    public void setText_Email(JTextField text_Email) {
        this.text_Email = text_Email;
    }

    public JTextField getText_Specialist() {
        return text_Specialist;
    }

    public void setText_Specialist(JTextField text_Specialist) {
        this.text_Specialist = text_Specialist;
    }

    public JTextField getText_Position() {
        return text_Position;
    }

    public void setText_Position(JTextField text_Position) {
        this.text_Position = text_Position;
    }

    public JTextField getText_Degree() {
        return text_Degree;
    }

    public void setText_Degree(JTextField text_Degree) {
        this.text_Degree = text_Degree;
    }

    public JTextField getText_Experience() {
        return text_Experience;
    }

    public void setText_Experience(JTextField text_Experience) {
        this.text_Experience = text_Experience;
    }

    public JTextField getText_ID() {
        return text_ID;
    }

    public void setText_ID(JTextField text_ID) {
        this.text_ID = text_ID;
    }

    public void getInfor(doctor res) {
        this.doctorInfor = res;
        this.getText_ID().setText(this.doctorInfor.getId());
        this.getText_Name().setText(this.doctorInfor.getName());
        this.getText_Birh().setText(this.doctorInfor.getBirth().toString());
        this.getText_Sex().setSelectedItem(doctorInfor.getSex());
        this.getText_Phone().setText(this.doctorInfor.getPhone());
        this.getText_Email().setText(this.doctorInfor.getEmail());
        this.getText_Specialist().setText(this.doctorInfor.getSpecialist());
        this.getText_Position().setText(this.doctorInfor.getPosition());
        this.getText_Degree().setText(this.doctorInfor.getDegree());
        this.getText_Experience().setText(this.doctorInfor.getExperience());
    }

    // Save changes
    public void Save() {
    	LocalDate lc = LocalDate.parse(this.getText_Birh().getText());
    	Date date = Date.valueOf(lc);
        this.getDoctorInfor().setId(this.getText_ID().getText());
        this.getDoctorInfor().setName(this.getText_Name().getText());
        this.getDoctorInfor().setBirth(date);
        this.getDoctorInfor().setSex(this.getText_Sex().getSelectedItem().toString());
        this.getDoctorInfor().setPhone(this.getText_Phone().getText());
        this.getDoctorInfor().setEmail(this.getText_Email().getText());
        this.getDoctorInfor().setSpecialist(this.getText_Specialist().getText());
        this.getDoctorInfor().setPosition(this.getText_Position().getText());
        this.getDoctorInfor().setDegree(this.getText_Degree().getText());
        this.getDoctorInfor().setExperience(this.getText_Experience().getText());
    }
    
    public boolean checkBirth(String birth) {
    	SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
    	dateform.setLenient(false);
    	try {
			dateform.parse(birth);
			return true;
		} catch (ParseException e) {
			return false;
		}
    }

    public boolean checkEmail(String res) {
        String word[] = res.split("@");
        if (word.length == 2 && word[1].equals("gmail.com"))
            return true;
        return false;
    }

    public boolean checkPhone(String res) {
        if (res.length() == 10 && res.charAt(0) == '0') {
            for (int i = 0; i < res.length(); i++) {
                if (!Character.isDigit(res.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
}
