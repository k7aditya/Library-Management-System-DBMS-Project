import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class Student_login_signup extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    
    public Student_login_signup() {
        initializeComponents();
        addActionListeners();
    }
    
    private void initializeComponents() {
        setTitle("Student Login/Signup");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);
        
        loginButton = new JButton("Login");
        panel.add(loginButton, gbc);
        
        registerButton = new JButton("Register");
        panel.add(registerButton, gbc);
        
        add(panel, BorderLayout.CENTER);
    }
    
    private void addActionListeners() {
        loginButton.addActionListener((ActionEvent e) -> {
            StudentLogin.main(new String[]{});
            dispose(); // Close the current window
        });
        
        registerButton.addActionListener((ActionEvent e) -> {
            StudentSignup.main(new String[]{});
            dispose(); // Close the current window
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        Student_login_signup studentLoginSignup = new Student_login_signup();
        studentLoginSignup.setLocationRelativeTo(null); // Set location to center
        studentLoginSignup.setVisible(true);
    });
    }
}
