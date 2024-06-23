import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import java.util.Random;

public class TeacherSignup extends JFrame {    
    static TeacherSignup frame;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField IDField;
    private JTextField phoneField;
    private JTextField emailField; // New field for email
    private JPasswordField passwordField;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frame = new TeacherSignup();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TeacherSignup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("background.jpg").getImage(); // Ensure the image file is correctly placed
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblTeacherSignupForm = new JLabel("Teacher Signup Form");
        lblTeacherSignupForm.setForeground(Color.BLACK);
        lblTeacherSignupForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.BLACK);
        
        JLabel lblID = new JLabel("ID:");
        lblID.setForeground(Color.BLACK);
        
        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setForeground(Color.BLACK);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.BLACK);
        
        JLabel lblEmail = new JLabel("Email:"); // New label for email
        lblEmail.setForeground(Color.BLACK);
        
        nameField = new JTextField();
        nameField.setColumns(10);
        
        IDField = new JTextField();
        IDField.setColumns(10);
        
        phoneField = new JTextField();
        phoneField.setColumns(10);
        
        emailField = new JTextField(); // New field for email
        emailField.setColumns(10);
        
        passwordField = new JPasswordField();
        
        JButton btnSignup = new JButton("Signup");
        
        btnSignup.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            String idStr = IDField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText(); // Get the email input
            String password = String.valueOf(passwordField.getPassword());

            if (idStr.isEmpty() || name.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(TeacherSignup.this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@iiita\\.ac\\.in$")) { // Check email format
                JOptionPane.showMessageDialog(TeacherSignup.this, "Please enter your college email id.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int id;
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TeacherSignup.this, "ID must be a number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (TeacherDao.checkTeacherIDExistence(id)) {
                    JOptionPane.showMessageDialog(TeacherSignup.this, "Teacher ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                } 
                else if(TeacherDao.checkTeacherEmailExistence(email)){
                    JOptionPane.showMessageDialog(TeacherSignup.this, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                     String verificationCode = generateVerificationCode();
                     sendVerificationEmail(name, email, verificationCode);
                     
                    boolean verificationSuccess = false;
                    JTextField verificationField = new JTextField();
                    do {
                        Object[] message = {
                            "Enter the verification code:", verificationField
                        };
                        int option = JOptionPane.showConfirmDialog(TeacherSignup.this, message, "Verification", JOptionPane.OK_CANCEL_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            String enteredCode = verificationField.getText();
                            if (verifyCode(enteredCode, verificationCode)) {
                                // Verification successful, proceed with signup
                                verificationSuccess = true;
                                TeacherDao.save(name, password, id, phone, email);
                                TeacherSuccess.main(new String[]{});
                                frame.dispose();
                                JOptionPane.showMessageDialog(TeacherSignup.this, "Signup successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                // Verification code incorrect
                                JOptionPane.showMessageDialog(TeacherSignup.this, "Incorrect verification code. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            // User cancelled the verification process
                            JOptionPane.showMessageDialog(TeacherSignup.this, "Verification cancelled. Signup aborted.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            break; // Break the loop if user cancels
                        }
                    } while (!verificationSuccess);
                }
            }
        });
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(140)
                            .addComponent(lblTeacherSignupForm))
                        .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(19)
                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblID)
                                .addComponent(lblName)
                                .addComponent(lblPhone)
                                .addComponent(lblPassword)
                                .addComponent(lblEmail)) // Add the email label
                            .addGap(47)
                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordField)
                                .addComponent(phoneField)
                                .addComponent(IDField)
                                .addComponent(nameField)
                                .addComponent(emailField)))) // Add the email field
                    .addContainerGap(87, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(169, Short.MAX_VALUE)
                    .addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                    .addGap(151))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(lblTeacherSignupForm)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblName)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID)
                        .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhone)
                        .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE))
                    
        );
        contentPane.setLayout(gl_contentPane);
    }
    
    private static String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000); // Generates a random 6-digit number
        return String.valueOf(code);
    }
    
    private static void sendVerificationEmail(String name, String email, String verificationCode) {
        String subject = "Email Verification";
        String message = "Hello, "+name+" Welcome to Institute Library Management System" + "\n" + "To continue signing up, " + " Your verification code is: " + verificationCode;
        try {
            EmailSender.sendEmail(email, subject, message);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(frame, "Failed to send verification email. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(TeacherSignup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static boolean verifyCode(String inputCode, String expectedCode) {
        return inputCode.equals(expectedCode);
    }
}
