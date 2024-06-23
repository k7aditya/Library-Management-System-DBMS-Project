import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// HistoryForm.java
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

public class THistoryForm extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    THistoryForm frame = new THistoryForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public THistoryForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 404);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblHistory = new JLabel("Borrowing History");
        lblHistory.setForeground(Color.GRAY);
        lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 18));

        JLabel lblCallNo = new JLabel("Teacher ID:");

        textField = new JTextField();
        textField.setColumns(10);

        JButton btnShow = new JButton("Show");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentIdText = textField.getText();

                try {
                    int studentId = Integer.parseInt(studentIdText);
                    Historydao historyDao = new Historydao(studentId);
                    historyDao.setVisible(true);
                    //dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(THistoryForm.this, "Invalid teacher ID. Please enter a valid integer.");
                }
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentSuccess.main(new String[]{});
                dispose();
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(150)
                                                .addComponent(lblHistory))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblCallNo))
                                                .addGap(47)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(125, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(161)
                                .addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(162, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(359, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblHistory)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCallNo)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBack)
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
