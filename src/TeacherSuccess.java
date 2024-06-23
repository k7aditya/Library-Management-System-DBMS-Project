import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class TeacherSuccess extends JFrame {
    static TeacherSuccess frame;
    private final JPanel contentPane;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frame = new TeacherSuccess();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public TeacherSuccess() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 433);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel lblTeacherSection = new JLabel("Teacher Section");
        lblTeacherSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
        
        JButton btnViewBooks = new JButton("View Books");
        btnViewBooks.addActionListener((ActionEvent arg0) -> {
            ViewBooks.main(new String[]{});
        });
        btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btnIssueBook = new JButton("Issue Book");
        btnIssueBook.addActionListener((ActionEvent e) -> {
            IssueBookFormTeacher.main(new String[]{});
            frame.dispose();
        });
        btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnReturnBook = new JButton("Return Book");
        btnReturnBook.addActionListener((ActionEvent e) -> {
            ReturnBookTeacher.main(new String[]{});
            frame.dispose();
        });
        btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnHistory = new JButton("History");
        btnHistory.addActionListener((ActionEvent e) -> {
            THistoryForm.main(new String[]{});
            frame.dispose();
        });
        btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener((ActionEvent e) -> {
            Library.main(new String[]{});
            frame.dispose();
        });
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(lblTeacherSection)
                    .addGap(54))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(132)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHistory, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(101, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTeacherSection)
                    .addGap(18)
                    .addComponent(btnViewBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnHistory, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
