package ViewDoc;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ControllerDoctor.ControllerDoctor;
import ControllerDoctor.ControllerNotification;
import ControllerDoctor.ControllerProfile;
import ControllerDoctor.ControllerSearch;
import ControllerDoctor.ControllerSecurity;
import ViewPatient.setIcon;

public class Doctor extends JFrame{
	private Menu menuDoctor;
    private JPanel jPanel;
    private CardLayout cardLayout;
    private Home home;
    private Notification notification;
    private Information information;
    private Search search;
    private Profile profile;
    private Security security;

    
    // Constructor
    public Doctor() throws HeadlessException {
        super();
        this.menuDoctor = new Menu();
        this.jPanel = new JPanel();
        this.cardLayout = new CardLayout();
        this.home = new Home();
        this.notification = new Notification();
        this.information = new Information();
        this.search = new Search();
        this.profile = new Profile();
        this.security = new Security();
        this.run();
    }


    // Display
    public void run() {
        this.setTitle("Doctor");
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new setIcon().loadImage("resources/app.png").getImage());



        // Controller
        ControllerDoctor controllerDoctor = new ControllerDoctor(this);
        ControllerNotification controllerNotification = new ControllerNotification(this);
        ControllerSearch controllerSearch = new ControllerSearch(this);
        ControllerProfile controllerProfile = new ControllerProfile(this);
        ControllerSecurity controllerSecurity = new ControllerSecurity(this);
        

        // Menu
        this.setJMenuBar(menuDoctor);
        this.menuDoctor.getHome().addActionListener(controllerDoctor);
        this.menuDoctor.getNotification().addActionListener(controllerDoctor);
        this.menuDoctor.getInformation().addActionListener(controllerDoctor);
        this.menuDoctor.getSearch().addActionListener(controllerDoctor);
        this.menuDoctor.getProfile().addActionListener(controllerDoctor);
        this.menuDoctor.getSecurity().addActionListener(controllerDoctor);
        this.menuDoctor.getExit().addActionListener(controllerDoctor);
        this.menuDoctor.getLogout().addActionListener(controllerDoctor);


        // Notifcication
        for (int i=0; i<this.notification.getListPatientNeedHelp().size(); i++)
            this.notification.getListPatientNeedHelp().get(i).addActionListener(controllerNotification);
        this.notification.getjButton_Done().addActionListener(controllerNotification);
        // Information


        // Search
        this.search.getjButton_Search().addActionListener(controllerSearch);
        

        // Profile
        this.profile.getjButton_Cancel().addActionListener(controllerProfile);
        this.profile.getjButton_Save().addActionListener(controllerProfile);


        // Security
        this.security.getjButton_Cancel().addActionListener(controllerSecurity);
        this.security.getjButton_Save().addActionListener(controllerSecurity);


        // Search



        // CardLayout
        this.jPanel.setLayout(cardLayout);
        this.jPanel.add(home, "home");
        this.jPanel.add(notification, "notification");
        this.jPanel.add(information, "information");
        this.jPanel.add(search, "search");
        this.jPanel.add(profile, "profile");
        this.jPanel.add(security, "security");


        // Set Layout
        this.setLayout(new BorderLayout());


        // Add
        this.add(jPanel, BorderLayout.CENTER);
        this.setVisible(false);
    }

    // Getters and Setters
    public Menu getMenuDoctor() {
        return menuDoctor;
    }


    public void setMenuDoctor(Menu menuDoctor) {
        this.menuDoctor = menuDoctor;
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


    public Notification getNotification() {
        return notification;
    }


    public void setNotification(Notification notification) {
        this.notification = notification;
    }


    public Information getInformation() {
        return information;
    }


    public void setInformation(Information information) {
        this.information = information;
    }


    public Search getSearch() {
        return search;
    }


    public void setSearch(Search search) {
        this.search = search;
    }


    public Profile getProfile() {
        return profile;
    }


    public void setProfile(Profile profile) {
        this.profile = profile;
    }


    public Security getSecurity() {
        return security;
    }


    public void setSecurity(Security security) {
        this.security = security;
    }

    // Show Menu
    public void showHome() {
        this.cardLayout.show(this.jPanel, "home");
    }

    public void showNotification() {
        this.cardLayout.show(this.jPanel, "notification");
    }

    public void showInformation() {
        this.cardLayout.show(this.jPanel, "information");
    }

    public void showSearch() {
        this.cardLayout.show(this.jPanel, "search");
    }

    public void showProfile() {
        this.cardLayout.show(this.jPanel, "profile");
    }

    public void showSecurity() {
        this.cardLayout.show(this.jPanel, "security");
    }
}
