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

public class JPanelInsertDoctor extends JPanel{
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
    private JButton jButton_InsertDoctor;
    private doctor doc;


    // Constructor
    public JPanelInsertDoctor() {
    	doc = new doctor();
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
        JLabel jLabel_ID = new JLabel("ID: ");
        jLabel_ID.setFont(font_jLabel);
        text_ID = new JTextField("",15);
        text_ID.setFont(font_jTextField);
        text_ID.setEditable(true);
        text_ID.setBackground(Color.WHITE);

        JLabel jLabel_Name = new JLabel("Name: ");
        jLabel_Name.setFont(font_jLabel);
        text_Name = new JTextField("",15);
        text_Name.setFont(font_jTextField);
        text_Name.setEditable(true);
        text_Name.setBackground(Color.WHITE);

        JLabel jLabel_Birth = new JLabel("Birth: ");
        jLabel_Birth.setFont(font_jLabel);
        text_Birh = new JTextField("",15);
        text_Birh.setFont(font_jTextField);
        text_Birh.setEditable(true);
        text_Birh.setBackground(Color.WHITE);

        JLabel jLabel_Sex = new JLabel("Sex: ");
        jLabel_Sex.setFont(font_jLabel);String sex[] = {"Nam", "Nữ"};
        text_Sex = new JComboBox<String>(sex);
        text_Sex.setPreferredSize(new Dimension(156,23));
        text_Sex.setFont(font_jTextField);
        text_Sex.setEditable(true);
        text_Sex.setBackground(Color.WHITE);

        JLabel jLabel_Phone = new JLabel("Phone: ");
        jLabel_Phone.setFont(font_jLabel);
        text_Phone = new JTextField("",15);
        text_Phone.setFont(font_jTextField);
        text_Phone.setEditable(true);
        text_Phone.setBackground(Color.WHITE);

        JLabel jLabel_Email = new JLabel("Email: ");
        jLabel_Email.setFont(font_jLabel);
        text_Email = new JTextField("",15);
        text_Email.setFont(font_jTextField);
        text_Email.setEditable(true);
        text_Email.setBackground(Color.WHITE);

        JLabel jLabel_Specialist = new JLabel("Specialist: ");
        jLabel_Specialist.setFont(font_jLabel);
        text_Specialist = new JTextField("",15);
        text_Specialist.setFont(font_jTextField);
        text_Specialist.setEditable(true);
        text_Specialist.setBackground(Color.WHITE);

        JLabel jLabel_Position = new JLabel("Position: ");
        jLabel_Position.setFont(font_jLabel);
        text_Position = new JTextField("",15);
        text_Position.setFont(font_jTextField);
        text_Position.setEditable(true);
        text_Position.setBackground(Color.WHITE);

        JLabel jLabel_Degree = new JLabel("Degree: ");
        jLabel_Degree.setFont(font_jLabel);
        text_Degree = new JTextField("",15);
        text_Degree.setFont(font_jTextField);
        text_Degree.setEditable(true);
        text_Degree.setBackground(Color.WHITE);

        JLabel jLabel_Experience = new JLabel("Experience: ");
        jLabel_Experience.setFont(font_jLabel);
        text_Experience = new JTextField("",15);
        text_Experience.setFont(font_jTextField);
        text_Experience.setEditable(true);
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
        c.weightx = 0.4;
        c.gridy = 0;
        jPanel_Details.add(text_Name, c);
        c.gridy = 1;
        jPanel_Details.add(text_Birh, c);
        c.gridy = 2;
        jPanel_Details.add(text_Sex, c);
        c.gridy = 3;
        jPanel_Details.add(text_Email, c);
        c.gridy = 4;
        jPanel_Details.add(text_Phone, c);

        // Save
        jButton_InsertDoctor = new JButton("Insert doctor");
        jButton_InsertDoctor.setFont(font_jTextField);

        JPanel jPanel_Button = new JPanel(new FlowLayout());
        jPanel_Button.add(jButton_InsertDoctor);
        
        // Layout
        this.setLayout(new BorderLayout());

        // Add
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jPanel_Details, BorderLayout.CENTER);
        this.add(jPanel_Button, BorderLayout.SOUTH);
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


    public JButton getjButton_InsertDoctor() {
        return jButton_InsertDoctor;
    }


    public void setjButton_InsertDoctor(JButton jButton_InsertDoctor) {
        this.jButton_InsertDoctor = jButton_InsertDoctor;
    }


	public doctor getDoc() {
		return doc;
	}


	public void setDoc(doctor doc) {
		this.doc = doc;
	}
    
	public void Update() {
		LocalDate lc = LocalDate.parse( this.text_Birh.getText());
    	Date date = Date.valueOf(lc);
    	this.doc.setId(this.text_ID.getText());
		this.doc.setName(this.text_Name.getText());
		this.doc.setBirth(date);
		this.doc.setSex(this.text_Sex.getSelectedItem().toString());
		this.doc.setPhone(this.text_Phone.getText());
		this.doc.setEmail(this.text_Email.getText());
		this.doc.setSpecialist(this.text_Specialist.getText());
		this.doc.setPosition(this.text_Position.getText());
		this.doc.setDegree(this.text_Degree.getText());
		this.doc.setExperience(this.text_Experience.getText());
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
