package ViewDoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import DataAccessObject.patientsDAO;
import model.listNotificationsInfor;

public class Notification extends JPanel{
	private listNotificationsInfor modelNotification;
    private ArrayList<JCheckBox> listPatientNeedHelp;
    private ArrayList<String> listContent;
    private JPanel jPanel_Details;
    private JButton jButton_Done;
    private JScrollPane jScrollPane_Content;

    // Construtor
    public Notification() {
        this.modelNotification = new listNotificationsInfor();
        this.listPatientNeedHelp = new ArrayList<JCheckBox>();
        this.listContent = new ArrayList<String>();
        this.run();
    }

    public void run() {
        // Font
        Font font_header = new Font("Segoe UI", Font.BOLD, 20);
        Font font_jTextField = new Font("Segoe UI", Font.PLAIN, 12);
        
        
        // Header
        JPanel headerJPanel = new JPanel();
        headerJPanel.setLayout(new FlowLayout());
        JLabel headerInformation = new JLabel("Patient need help !!!");
        headerInformation.setFont(font_header);
        headerJPanel.add(headerInformation);


        // Details
        jPanel_Details = new JPanel(new GridLayout(this.modelNotification.getListPatient().size(),1));
        for (int i=0; i<this.modelNotification.getListPatient().size(); i++) {
            JCheckBox jCheckBox = new JCheckBox("Notification " + (i+1));
            jCheckBox.setPreferredSize(new Dimension(20, 30));
            this.listPatientNeedHelp.add(jCheckBox);
            String content = "Patient " + (i+1) + "\n\n" + this.modelNotification.getListPatient().get(i).toString()
            + "\n=================================================================";
            this.listContent.add(content);
            JTextArea jTextArea_Content = new JTextArea(content);
            jTextArea_Content.setFont(font_jTextField);
            jTextArea_Content.setEditable(false);
            jTextArea_Content.setBackground(Color.WHITE);
            JPanel check = new JPanel();
            check.setLayout(new FlowLayout());
            check.add(jTextArea_Content);
            check.add(jCheckBox);
            jPanel_Details.add(check);
        }


        jScrollPane_Content = new JScrollPane(jPanel_Details);
        jScrollPane_Content.setBackground(Color.GRAY);
        jButton_Done = new JButton("Done");
        jButton_Done.setFont(font_jTextField);
        
        JPanel done = new JPanel(new FlowLayout());
        done.add(jButton_Done);

        // Layout
        this.setLayout(new BorderLayout());
        this.add(headerJPanel, BorderLayout.NORTH);
        this.add(jScrollPane_Content, BorderLayout.CENTER);
        this.add(done,BorderLayout.SOUTH);
    }

    // Getters and Setters
    public listNotificationsInfor getModelNotification() {
        return modelNotification;
    }

    public void setModelNotification(listNotificationsInfor modelNotification) {
        this.modelNotification = modelNotification;
    }

    public ArrayList<JCheckBox> getListPatientNeedHelp() {
        return listPatientNeedHelp;
    }

    public void setListPatientNeedHelp(ArrayList<JCheckBox> listPatientNeedHelp) {
        this.listPatientNeedHelp = listPatientNeedHelp;
    }

    public JPanel getjPanel_Details() {
        return jPanel_Details;
    }

    public void setjPanel_Details(JPanel jPanel_Details) {
        this.jPanel_Details = jPanel_Details;
    }

    public ArrayList<String> getListContent() {
        return listContent;
    }

    public void setListContent(ArrayList<String> listContent) {
        this.listContent = listContent;
    }

    public void getList() {
        this.listContent.clear();
        this.listPatientNeedHelp.clear();
        this.jPanel_Details.removeAll();
        this.jScrollPane_Content.removeAll();
        this.remove(jScrollPane_Content);
        this.modelNotification.setListPatient(patientsDAO.getInstance().getListPatientNeedHelp());
        Font font_jTextField = new Font("Segoe UI", Font.PLAIN, 12);
        jPanel_Details = new JPanel(new GridLayout(this.modelNotification.getListPatient().size(),1));
        for (int i=0; i<this.modelNotification.getListPatient().size(); i++) {
            JCheckBox jCheckBox = new JCheckBox("Notification " + (i+1));
            jCheckBox.setPreferredSize(new Dimension(20, 30));
            this.listPatientNeedHelp.add(jCheckBox);
            String content = "Patient " + (i+1) + "\n\n" + this.modelNotification.getListPatient().get(i).toString()
            + "\n=================================================================";
            this.listContent.add(content);
            JTextArea jTextArea_Content = new JTextArea(content);
            jTextArea_Content.setFont(font_jTextField);
            jTextArea_Content.setEditable(false);
            jTextArea_Content.setBackground(Color.WHITE);
            JPanel check = new JPanel();
            check.setLayout(new FlowLayout());
            check.add(jTextArea_Content);
            check.add(jCheckBox);
            jPanel_Details.add(check);
        }

        jScrollPane_Content = new JScrollPane(jPanel_Details);
        jScrollPane_Content.setBackground(Color.GRAY);

        this.add(jScrollPane_Content, BorderLayout.CENTER);
    }

	public JButton getjButton_Done() {
		return jButton_Done;
	}
	
	public JScrollPane getjScrollPane_Content() {
		return jScrollPane_Content;
	}
}
