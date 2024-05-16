package ViewAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class JPanelDoctor extends JPanel{
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
    private JButton jButton_Search;
    private JButton jButton_Save;
    private JButton jButton_Cancel;
    private JTextField text_Search;
    private JButton jButton_Delete;


    // Constructor
    public JPanelDoctor() {
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
        JLabel headerInformation = new JLabel("Doctor");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);

        // Details
        JLabel jLabel_Name = new JLabel("Name: ");
        jLabel_Name.setFont(font_jLabel);
        text_Name = new JTextField(this.doctorInfor.getName(),15);
        text_Name.setFont(font_jTextField);
        text_Name.setEditable(true);
        text_Name.setBackground(Color.WHITE);

        JLabel jLabel_Birth = new JLabel("Birth: ");
        jLabel_Birth.setFont(font_jLabel);
        text_Birh = new JTextField(this.doctorInfor.getBirth().toString(),15);
        text_Birh.setFont(font_jTextField);
        text_Birh.setEditable(true);
        text_Birh.setBackground(Color.WHITE);

        JLabel jLabel_Sex = new JLabel("Sex: ");
        jLabel_Sex.setFont(font_jLabel);
        String sex[] = {"Nam", "Nữ"};
        text_Sex = new JComboBox<String>(sex);
        text_Sex.setSelectedItem(doctorInfor.getSex());
        text_Sex.setPreferredSize(new Dimension(156,23));
        text_Sex.setFont(font_jTextField);
        text_Sex.setEditable(true);
        text_Sex.setBackground(Color.WHITE);

        JLabel jLabel_Phone = new JLabel("Phone: ");
        jLabel_Phone.setFont(font_jLabel);
        text_Phone = new JTextField(this.doctorInfor.getPhone(),15);
        text_Phone.setFont(font_jTextField);
        text_Phone.setEditable(true);
        text_Phone.setBackground(Color.WHITE);

        JLabel jLabel_Email = new JLabel("Email: ");
        jLabel_Email.setFont(font_jLabel);
        text_Email = new JTextField(this.doctorInfor.getEmail(),15);
        text_Email.setFont(font_jTextField);
        text_Email.setEditable(true);
        text_Email.setBackground(Color.WHITE);

        JLabel jLabel_Specialist = new JLabel("Specialist: ");
        jLabel_Specialist.setFont(font_jLabel);
        text_Specialist = new JTextField(this.doctorInfor.getSpecialist(),15);
        text_Specialist.setFont(font_jTextField);
        text_Specialist.setEditable(true);
        text_Specialist.setBackground(Color.WHITE);

        JLabel jLabel_Position = new JLabel("Position: ");
        jLabel_Position.setFont(font_jLabel);
        text_Position = new JTextField(this.doctorInfor.getPosition(),15);
        text_Position.setFont(font_jTextField);
        text_Position.setEditable(true);
        text_Position.setBackground(Color.WHITE);

        JLabel jLabel_Degree = new JLabel("Degree: ");
        jLabel_Degree.setFont(font_jLabel);
        text_Degree = new JTextField(this.doctorInfor.getDegree(),15);
        text_Degree.setFont(font_jTextField);
        text_Degree.setEditable(true);
        text_Degree.setBackground(Color.WHITE);

        JLabel jLabel_Experience = new JLabel("Experience: ");
        jLabel_Experience.setFont(font_jLabel);
        text_Experience = new JTextField(this.doctorInfor.getExperience(),15);
        text_Experience.setFont(font_jTextField);
        text_Experience.setEditable(true);
        text_Experience.setBackground(Color.WHITE);

        JLabel jLabel_Search = new JLabel("Doctor's ID: ");
        jLabel_Search.setFont(font_jLabel);
        text_Search = new JTextField(15);
        text_Search.setFont(font_jTextField);
        text_Search.setEditable(true);
        text_Search.setBackground(Color.WHITE);

        jButton_Search = new JButton("Search");
        jButton_Search.setFont(font_jTextField);

        // Location
        JPanel jPanel_Details = new JPanel();
        jPanel_Details.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(jLabel_Search, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_Specialist, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Position, c);
        c.gridy = 3;
        jPanel_Details.add(jLabel_Degree, c);
        c.gridy = 4;
        jPanel_Details.add(jLabel_Experience, c);
        c.gridy = 5;
        jPanel_Details.add(jLabel_Name, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 0.4;
        c.fill = GridBagConstraints.BOTH;
        jPanel_Details.add(text_Search, c);
        c.gridy = 1;
        jPanel_Details.add(text_Specialist, c);
        c.gridy = 2;
        jPanel_Details.add(text_Position, c);
        c.gridy = 3;
        jPanel_Details.add(text_Degree, c);
        c.gridy = 4;
        jPanel_Details.add(text_Experience, c);
        c.gridy = 5;
        jPanel_Details.add(text_Name, c);
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.1;
        jPanel_Details.add(jButton_Search, c);
        c.gridy = 1;
        jPanel_Details.add(jLabel_Birth, c);
        c.gridy = 2;
        jPanel_Details.add(jLabel_Sex, c);
        c.gridy = 3;
        jPanel_Details.add(jLabel_Email, c);
        c.gridy = 4;
        jPanel_Details.add(jLabel_Phone, c);
        c.gridx = 3;
        c.weightx = 0.4;
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 1;
        jPanel_Details.add(text_Birh, c);
        c.gridy = 2;
        jPanel_Details.add(text_Sex, c);
        c.gridy = 3;
        jPanel_Details.add(text_Email, c);
        c.gridy = 4;
        jPanel_Details.add(text_Phone, c);

        // Save
        jButton_Save = new JButton("Save");
        jButton_Save.setFont(font_jTextField);

        jButton_Delete = new JButton("Delete");
        jButton_Delete.setFont(font_jTextField);

        jButton_Cancel = new JButton("Cancel");
        jButton_Cancel.setFont(font_jTextField);

        JPanel jPanel_Button = new JPanel(new FlowLayout());
        jPanel_Button.add(jButton_Cancel);
        jPanel_Button.add(jButton_Delete);
        jPanel_Button.add(jButton_Save);
        
        // Layout
        this.setLayout(new BorderLayout());

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(jPanel_Button, BorderLayout.SOUTH);
    }

    public doctor getDoctorInfor() {
        return doctorInfor;
    }


    public void setModelInformation(doctor doctorInfor) {
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


    public JButton getjButton_Search() {
        return jButton_Search;
    }


    public void setjButton_Search(JButton jButton_Search) {
        this.jButton_Search = jButton_Search;
    }


    public JButton getjButton_Save() {
        return jButton_Save;
    }


    public void setjButton_Save(JButton jButton_Save) {
        this.jButton_Save = jButton_Save;
    }


    public JButton getjButton_Cancel() {
        return jButton_Cancel;
    }


    public void setjButton_Cancel(JButton jButton_Cancel) {
        this.jButton_Cancel = jButton_Cancel;
    }
    
    public JTextField getText_Search() {
        return text_Search;
    }


    public void setText_Search(JTextField text_Search) {
        this.text_Search = text_Search;
    }

    public JButton getjButton_Delete() {
        return jButton_Delete;
    }

    public void setjButton_Delete(JButton jButton_Delete) {
        this.jButton_Delete = jButton_Delete;
    }

    public void getInfor(doctor res) {
        this.doctorInfor = res;
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
        this.getDoctorInfor().setId(this.getText_Search().getText());
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

    public void reset() {
        this.getText_Search().setText("");
        this.getText_Name().setText("");
        this.getText_Birh().setText("");
        this.getText_Phone().setText("");
        this.getText_Email().setText("");
        this.getText_Specialist().setText("");
        this.getText_Position().setText("");
        this.getText_Degree().setText("");
        this.getText_Experience().setText("");
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
