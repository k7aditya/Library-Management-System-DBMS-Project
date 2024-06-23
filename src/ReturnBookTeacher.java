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

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBookTeacher extends JFrame {
	static ReturnBookTeacher frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
        private JDateChooser jDateChooser2;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        frame = new ReturnBookTeacher();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
	}

	/**
	 * Create the frame.
	 */
	public ReturnBookTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReturnBookTeacher = new JLabel("Return Book");
		lblReturnBookTeacher.setForeground(Color.GRAY);
		lblReturnBookTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBookCallno = new JLabel("Book Callno:");
		
		JLabel lblTeacherId = new JLabel("Teacher Id:");
                
                JLabel lblReturn = new JLabel("Return Date:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
                
                jDateChooser2 = new JDateChooser();
		
		JButton btnReturnBookTeacher = new JButton("Return Book");
		btnReturnBookTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookcallno=textField.getText();
				int teacherid=Integer.parseInt(textField_1.getText());
                                
                                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String Rdate = dFormat.format(jDateChooser2.getDate());
                        
				int i=ReturnBookDaoTeacher.delete(bookcallno, teacherid,Rdate);
				if(i>0){
					JOptionPane.showMessageDialog(ReturnBookTeacher.this,"Book returned successfully!");
					ReturnBookTeacher.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(ReturnBookTeacher.this,"Sorry, unable to return book!");
				}
			}
		});
                
                
                JButton btnCharge = new JButton("Check Fine");
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Finedao.main(new String[]{});
				frame.dispose();
			}
		});
		btnCharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
                
		
		JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherSuccess.main(new String[]{});
				frame.dispose();
			}
		});
                
                
                JButton btnPayfine = new JButton("Pay Fine");
		btnPayfine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentForm.main(new String[]{});
				frame.dispose();
			}
		});
                
                
                
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblTeacherId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBookCallno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                .addComponent(lblReturn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        )
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btnReturnBookTeacher, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(lblReturnBookTeacher)
					.addGap(187))
                                .addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(btnCharge)
					.addGap(187))
                                .addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnPayfine)
					.addGap(46))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addContainerGap(294, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReturnBookTeacher)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookCallno)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTeacherId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReturn)
						.addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnReturnBookTeacher, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
                                        .addComponent(btnCharge, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
                                        .addComponent(btnPayfine)
                                        .addGap(20)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(72))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
