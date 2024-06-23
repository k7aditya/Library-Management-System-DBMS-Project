import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class TeacherLogin extends JFrame {
    static TeacherLogin frame;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new TeacherLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TeacherLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("D:\\New folder (6)\\Screenshot 2023-11-19 194911.png").getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTeacherLoginForm = new JLabel("Teacher Login Form");
        lblTeacherLoginForm.setForeground(Color.GRAY);
        lblTeacherLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

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
            if (name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(TeacherLogin.this, "Please enter both name and password", "Input Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (TeacherDao.validate(name, password)) {
                TeacherSuccess.main(new String[]{});
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(TeacherLogin.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
                textField.setText("");
                passwordField.setText("");
            }
        }
        });

        passwordField = new JPasswordField();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(124)
                                                .addComponent(lblTeacherLoginForm))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(19)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblEnterName)
                                                        .addComponent(lblEnterPassword))
                                                .addGap(47)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passwordField)
                                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                                .addContainerGap(107, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(187, Short.MAX_VALUE)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(151))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblTeacherLoginForm)
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEnterName)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(28)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEnterPassword)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
