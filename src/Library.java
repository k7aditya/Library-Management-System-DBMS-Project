import java.awt.*;
import java.awt.event.*;import javax.swing.*;


public class Library extends JFrame {
    private static final long serialVersionUID = 1L;

    public Library() {
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450, 300));

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblLibraryManagement = new JLabel("Library Management");
        lblLibraryManagement.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblLibraryManagement.setForeground(Color.BLACK);
        GridBagConstraints gbc_lblLibraryManagement = new GridBagConstraints();
        gbc_lblLibraryManagement.gridx = 0;
        gbc_lblLibraryManagement.gridy = 0;
        gbc_lblLibraryManagement.gridwidth = 2;
        gbc_lblLibraryManagement.insets = new Insets(0, 0, 20, 0);
        contentPane.add(lblLibraryManagement, gbc_lblLibraryManagement);

        JButton btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAdminLogin.addActionListener((ActionEvent e) -> {
            // Handle admin login button action
            AdminLogin.main(new String[] {});
            dispose();
        });
        GridBagConstraints gbc_btnAdminLogin = new GridBagConstraints();
        gbc_btnAdminLogin.gridx = 0;
        gbc_btnAdminLogin.gridy = 1;
        gbc_btnAdminLogin.gridwidth = 2;
        gbc_btnAdminLogin.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAdminLogin.insets = new Insets(0, 0, 10, 10);
        contentPane.add(btnAdminLogin, gbc_btnAdminLogin);

        JButton btnLibrarianLogin = new JButton("Librarian Login");
        btnLibrarianLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLibrarianLogin.addActionListener((ActionEvent e) -> {
            // Handle librarian login button action
            LibrarianLogin.main(new String[] {});
            dispose();
        });
        GridBagConstraints gbc_btnLibrarianLogin = new GridBagConstraints();
        gbc_btnLibrarianLogin.gridx = 0;
        gbc_btnLibrarianLogin.gridy = 2;
        gbc_btnLibrarianLogin.gridwidth = 2;
        gbc_btnLibrarianLogin.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnLibrarianLogin.insets = new Insets(0, 0, 10, 10);
        contentPane.add(btnLibrarianLogin, gbc_btnLibrarianLogin);

        JButton btnStudentLogin = new JButton("Student Login");
        btnStudentLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnStudentLogin.addActionListener(new ActionListenerImpl());
        GridBagConstraints gbc_btnStudentLogin = new GridBagConstraints();
        gbc_btnStudentLogin.gridx = 0;
        gbc_btnStudentLogin.gridy = 3;
        gbc_btnStudentLogin.gridwidth = 2;
        gbc_btnStudentLogin.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnStudentLogin.insets = new Insets(0, 0, 10, 10);
        contentPane.add(btnStudentLogin, gbc_btnStudentLogin);

        JButton btnTeacherLogin = new JButton("Teacher Login");
        btnTeacherLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnTeacherLogin.addActionListener(new ActionListenerImp2());
        GridBagConstraints gbc_btnTeacherLogin = new GridBagConstraints();
        gbc_btnTeacherLogin.gridx = 0;
        gbc_btnTeacherLogin.gridy = 4;
        gbc_btnTeacherLogin.gridwidth = 2;
        gbc_btnTeacherLogin.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnTeacherLogin.insets = new Insets(0, 0, 10, 10);
        contentPane.add(btnTeacherLogin, gbc_btnTeacherLogin);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Library library = new Library();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private class ActionListenerImpl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle student login button action
            Student_login_signup.main(new String[] {});
            dispose();
        }
    }
    private class ActionListenerImp2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle student login button action
            Teacher_login_signup.main(new String[] {});
            dispose();
        }
    }
}
