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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportForm extends JFrame {
	static ReportForm frame;
	private JPanel contentPane;
	private JTextField textField_1;
	
       // private JTextField textField_5;
       // private JTextField textField_6;
        private JDateChooser jDateChooser1;
        
        

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReportForm();
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
	public ReportForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Book Report ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.GRAY);
		
		JLabel lblBookName = new JLabel("Book Callno:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
                
                jDateChooser1 = new JDateChooser();
                

                
               // textField_5 = new JTextField();
		//textField_5.setColumns(10);
                
                //textField_6 = new JTextField();
		//textField_6.setColumns(10);
		
		
                
                JLabel lblIssue = new JLabel("Report Date:");
                
                
                
                
                
                
                
                
                
		
		/*JButton btnIssueBook = new JButton("View Report");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String bookcallno=textField_1.getText();
			
                        
                        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String Idate = dFormat.format(jDateChooser1.getDate());
                        
                        


                        
                     
                        
			
			try {
                           String studentId = bookcallno;
                           Reportdao reportdao = new Reportdao(studentId);
                           reportdao.setVisible(true);
                           dispose();
                        } catch (NumberFormatException ex) {
                             JOptionPane.showMessageDialog(ReportForm.this, "Invalid book callno. Please enter a valid value.");
                        }
			
			}
		});*/
                JButton btnIssueBook = new JButton("View Report");
                btnIssueBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        String bookcallno = textField_1.getText();
                        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String reportDate = dFormat.format(jDateChooser1.getDate());

                try {
                    // Pass book call number and report date to Reportdao constructor
                    Reportdao reportdao = new Reportdao(bookcallno,reportDate);
                    reportdao.setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ReportForm.this, "Invalid book callno. Please enter a valid value.");
                }
            }
        });
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Book Callno Carefully before issuing book!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookName)
								
                                                                .addComponent(lblIssue, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                
                                                        
                                                        )
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								
                                                                .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                                
                                                        
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
						.addComponent(lblIssue)
						.addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
