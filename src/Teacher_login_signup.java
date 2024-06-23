import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

public class Teacher_login_signup extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    
    public Teacher_login_signup() {
        initializeComponents();
        addActionListeners();
    }
    
    private void initializeComponents() {
        setTitle("Teacher Login/Signup");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 50, 100, 30);
        
        registerButton = new JButton("Register");
        registerButton.setBounds(160, 50, 100, 30);
        
        setLayout(null); // Use absolute positioning
        add(loginButton);
        add(registerButton);
        
        setVisible(true);
    }
    
    private void addActionListeners() {
        loginButton.addActionListener((ActionEvent e) -> {
            TeacherLogin.main(new String[]{});
            dispose(); // Close the current window
        });
        
        registerButton.addActionListener((ActionEvent e) -> {
            TeacherSignup.main(new String[]{});
            dispose(); // Close the current window
        });
    }
    
    public static void main(String[] args) {
        Teacher_login_signup teacher_login_signup = new Teacher_login_signup();
    }
}
