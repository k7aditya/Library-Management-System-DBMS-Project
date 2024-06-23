import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

public class IssueBookForm extends JFrame {
	static IssueBookForm frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
       // private JTextField textField_5;
       // private JTextField textField_6;
        private JDateChooser jDateChooser1;
        private JDateChooser jDateChooser2;
        

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssueBookForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IssueBookForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Issue Book ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLACK);
		
		JLabel lblBookName = new JLabel("Book Callno:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
                
                jDateChooser1 = new JDateChooser();
                jDateChooser2 = new JDateChooser();

                
               // textField_5 = new JTextField();
		//textField_5.setColumns(10);
                
                //textField_6 = new JTextField();
		//textField_6.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		
		JLabel lblStudentName = new JLabel("Student Name:");
		
		JLabel lblStudentContact = new JLabel("Contact:");
                
                JLabel lblIssue = new JLabel("Issue Date:");
                
                
                JLabel lblReturn = new JLabel("Return Date:");
                
                
                
                
                
                
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String bookcallno=textField_1.getText();
			int studentid=Integer.parseInt(textField_2.getText());
			String studentname=textField_3.getText();
			String studentcontact=textField_4.getText();
                        
                        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String Idate = dFormat.format(jDateChooser1.getDate());
                        String Rdate = dFormat.format(jDateChooser2.getDate());
                        


                        
                     
                        
			
			if(IssueBookDao.checkBook(bookcallno)){
			
			int i=IssueBookDao.save(bookcallno, studentid, studentname, studentcontact,Idate,Rdate);
			if(i>0){
                            try {
                                sendReminderEmail(studentname, studentid, bookcallno, Rdate);
                            } catch (MessagingException ex) {
                                Logger.getLogger(IssueBookForm.class.getName()).log(Level.SEVERE, null, ex);
                            }
				JOptionPane.showMessageDialog(IssueBookForm.this,"Book issued successfully!");
				StudentSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, unable to issue!");
			}//end of save if-else
			
			}else{
				JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, Callno doesn't exist!");
			}//end of checkbook if-else
			
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before issuing book!");
//                JLabel lblNewLabel_2 = new JLabel("Make Sure to return the book within 15 days, else fine of 5Rs per day after due");

		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
//                lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblNewLabel_2.setForeground(Color.RED);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookName)
								.addComponent(lblStudentId)
								.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStudentContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblIssue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblReturn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                        
                                                        )
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        
                                                        )
							.addGap(48))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(btnBack)))
							.addGap(100))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(lblNewLabel)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentContact)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(26)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIssue)
						.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(26)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReturn)
						.addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
        private void sendReminderEmail(String studentName, int studentId, String bookCallNo, String returnDate) throws MessagingException {
        String subject = "Reminder: Return Book";
        String message = "Dear " + studentName + ",\n\nThis is a friendly reminder to return the book with call number "
                + bookCallNo + ". The return date is " + returnDate
                + ". Please ensure to return the book on time to avoid any fines.\n\nThank you.";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection (replace DB.getConnection() with your actual connection method)
            connection = DB.getConnection();
            String query = "SELECT studentemail FROM studenttable WHERE studentid = ?";
            
            // Create PreparedStatement
            statement = connection.prepareStatement(query);
            statement.setInt(1, studentId); // Set studentId parameter

            // Execute the query
            resultSet = statement.executeQuery();

            // Check if any result is returned
            if (resultSet.next()) {
                // Get the student email from the result set
                String studentEmail = resultSet.getString("studentemail");
                
                // Send email to student
                EmailSender.sendEmail(studentEmail, subject, message);
            } else {
                JOptionPane.showMessageDialog(frame, "Student email not found for student ID: " + studentId,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | MessagingException ex) {
            JOptionPane.showMessageDialog(frame, "Failed to send reminder email. Please try again later.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // Close all resources in finally block to ensure they're closed properly
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
         
}