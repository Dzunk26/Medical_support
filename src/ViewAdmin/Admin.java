package ViewAdmin;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ControllerAdmins.ControllerAdmin;
import ControllerAdmins.ControllerJPanelAccount;
import ControllerAdmins.ControllerJPanelDoctor;
import ControllerAdmins.ControllerJPanelInsert;
import ControllerAdmins.ControllerJPanelPatient;

public class Admin extends JFrame{
	private Menu menuAdmin;
    private JPanel jPanel;
    private CardLayout cardLayout;
    private ViewAdmin.Home home;
    private JPanelDoctor doctor;
    private JPanelPatient patient;
    private JPanelAccount account;
    private JPanelInsertDoctor insertDoctor;
    private JPanelInsertPatient insertPatient;

    public Admin() throws HeadlessException {
        super();
        this.menuAdmin = new Menu();
        this.jPanel = new JPanel();
        this.cardLayout = new CardLayout();
        this.home = new Home();
        this.doctor = new JPanelDoctor();
        this.patient = new JPanelPatient();
        this.account = new JPanelAccount();
        this.insertDoctor = new JPanelInsertDoctor();
        this.insertPatient = new JPanelInsertPatient();
        this.run();
    }

    public void run() {
        this.setTitle("Admin");
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setIconImage(Toolkit.getDefaultToolkit().createImage(ViewDoctor.class.getResource("app.png")));
    
        
        // Controller
        ControllerAdmin controllerAdmin = new ControllerAdmin(this);
        ControllerJPanelDoctor controllerJPanelDoctor = new ControllerJPanelDoctor(this);
        ControllerJPanelPatient controllerJPanelPatient = new ControllerJPanelPatient(this);
        ControllerJPanelAccount controllerJPanelAccount = new ControllerJPanelAccount(this);
        ControllerJPanelInsert controllerJPanelInsert = new ControllerJPanelInsert(this);

        // Menu
        this.setJMenuBar(menuAdmin);
        this.menuAdmin.getHome().addActionListener(controllerAdmin);
        this.menuAdmin.getDoctor().addActionListener(controllerAdmin);
        this.menuAdmin.getPatient().addActionListener(controllerAdmin);
        this.menuAdmin.getAccount().addActionListener(controllerAdmin);
        this.menuAdmin.getExit().addActionListener(controllerAdmin);
        this.menuAdmin.getLogout().addActionListener(controllerAdmin);
        this.menuAdmin.getInsertDoctor().addActionListener(controllerAdmin);
        this.menuAdmin.getInsertPatient().addActionListener(controllerAdmin);

        
        // JPanelDoctor
        this.doctor.getjButton_Search().addActionListener(controllerJPanelDoctor);
        this.doctor.getjButton_Cancel().addActionListener(controllerJPanelDoctor);
        this.doctor.getjButton_Save().addActionListener(controllerJPanelDoctor);
        this.doctor.getjButton_Delete().addActionListener(controllerJPanelDoctor);


        // JPanelPatient
        this.patient.getjButton_Search().addActionListener(controllerJPanelPatient);
        this.patient.getjButton_Cancel().addActionListener(controllerJPanelPatient);
        this.patient.getjButton_Save().addActionListener(controllerJPanelPatient);
        this.patient.getjButton_Delete().addActionListener(controllerJPanelPatient);

        
        // JPanelAccount
        this.account.getjButton_Search().addActionListener(controllerJPanelAccount);
        this.account.getjButton_Cancel().addActionListener(controllerJPanelAccount);
        this.account.getjButton_Save().addActionListener(controllerJPanelAccount);
        this.account.getjButton_Delete().addActionListener(controllerJPanelAccount);

        // JPanelInsert
        this.insertDoctor.getjButton_InsertDoctor().addActionListener(controllerJPanelInsert);
        this.insertPatient.getjButton_InsertPatient().addActionListener(controllerJPanelInsert);
        

        // CardLayout
        this.jPanel.setLayout(cardLayout);
        this.jPanel.add(home, "home");
        this.jPanel.add(doctor, "doctor");
        this.jPanel.add(patient, "patient");
        this.jPanel.add(account, "account");
        this.jPanel.add(insertDoctor, "insert doctor");
        this.jPanel.add(insertPatient, "insert patient");

        // Set Layout
        this.setLayout(new BorderLayout());


        // Add
        this.add(jPanel, BorderLayout.CENTER);
        this.setVisible(false);
    }

    public Menu getMenuAdmin() {
        return menuAdmin;
    }

    public void setMenuAdmin(Menu menuAdmin) {
        this.menuAdmin = menuAdmin;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public JPanelDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(JPanelDoctor doctor) {
        this.doctor = doctor;
    }

    public JPanelPatient getPatient() {
        return patient;
    }

    public void setPatient(JPanelPatient patient) {
        this.patient = patient;
    }

    public JPanelAccount getAccount() {
        return account;
    }

    public void setAccount(JPanelAccount account) {
        this.account = account;
    }

    public JPanelInsertDoctor getInsertDoctor() {
        return insertDoctor;
    }

    public void setInsertDoctor(JPanelInsertDoctor insertDoctor) {
        this.insertDoctor = insertDoctor;
    }

    public JPanelInsertPatient getInsertPatient() {
        return insertPatient;
    }

    public void setInsertPatient(JPanelInsertPatient insertPatient) {
        this.insertPatient = insertPatient;
    }

    // Show Menu
    public void showHome() {
        this.cardLayout.show(this.jPanel, "home");
    }

    public void showDoctor() {
        this.cardLayout.show(this.jPanel, "doctor");
    }

    public void showPatient() {
        this.cardLayout.show(this.jPanel, "patient");
    }

    public void showAccount() {
        this.cardLayout.show(this.jPanel, "account");
    }

    public void showInsertAccount() {
        this.cardLayout.show(this.jPanel, "insert account");
    }

    public void showInsertDoctor() {
        this.cardLayout.show(this.jPanel, "insert doctor");
    }

    public void showInsertPatient() {
        this.cardLayout.show(this.jPanel, "insert patient");
    }
}
