import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

public class StudentLogin extends JFrame {
    private JTextField textField;
    private JPasswordField passwordField;

    public StudentLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Login Form");
        setSize(450, 300);
        
        JPanel contentPane = new JPanel() {
            // Paint the background image
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("D:\\New folder (6)\\Screenshot 2023-11-19 194911.png").getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblStudentLoginForm = new JLabel("Student Login Form");
        lblStudentLoginForm.setForeground(Color.GRAY);
        lblStudentLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblEnterName = new JLabel("Enter Name:");
        lblEnterName.setForeground(Color.BLACK);

        JLabel lblEnterPassword = new JLabel("Enter Password:");
        lblEnterPassword.setForeground(Color.BLACK);

        textField = new JTextField();
        textField.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                if (StudentDao.validate(name, password)) {
                    StudentSuccess.main(new String[]{});
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(StudentLogin.this, "Sorry, Username or Password Error",
                            "Login Error!", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                    passwordField.setText("");
                }
            }
        });

        passwordField = new JPasswordField();

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);
        
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(50)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblEnterName)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addComponent(lblEnterPassword)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblStudentLoginForm))
                    .addGap(50))
        );
        
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(50)
                    .addComponent(lblStudentLoginForm)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEnterName)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEnterPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnLogin)
                    .addGap(50))
        );
        
        setLocationRelativeTo(null); // Center the window on the screen
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StudentLogin frame = new StudentLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
