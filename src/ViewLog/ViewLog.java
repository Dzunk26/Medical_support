package ViewLog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewLog extends JFrame{
    private JPanel jPanel;
    private CardLayout cardLayout;
    private LogIn logIn;
    private SignUp signUp;

	
    // Constructor
	public ViewLog() throws HeadlessException {
        super();
        this.jPanel = new JPanel();
        this.cardLayout = new CardLayout();
		this.logIn = new LogIn();
        this.signUp = new SignUp();
        this.run();
	}

    // Display
	public void run() {
		this.setTitle("Access Your Account");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout
        this.jPanel.setLayout(cardLayout);
        this.jPanel.add(logIn, "Log in");
        this.jPanel.add(signUp, "Sign up");

        // Set Layout
        this.setLayout(new BorderLayout());
        this.add(jPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

    // Getters and Setters
    public JPanel getjPanel() {
        return jPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public LogIn getLogIn() {
        return logIn;
    }

    public SignUp getSignUp() {
        return signUp;
    }

    // Show
    public void showLogIn() {
        this.setSize(400, 400);
        this.cardLayout.show(this.jPanel, "Log in");
    }

    public void showSignUp() {
        this.setSize(400, 400);
        this.cardLayout.show(this.jPanel, "Sign up");
    }
}
