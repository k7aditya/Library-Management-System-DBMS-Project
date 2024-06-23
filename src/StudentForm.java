//import java.awt.EventQueue;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import java.awt.Font;
//import java.awt.Color;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.JButton;
//import java.awt.event.ActionEvent;
//
//public class StudentForm extends JFrame {
//	static StudentForm frame;
//	private final JPanel contentPane;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JPasswordField passwordField;
//
//	/**
//	 * Launch the application.
//     * @param args
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(() -> {
//                    try {
//                        frame = new StudentForm();
//                        frame.setVisible(true);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public StudentForm(){
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 450);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JLabel lblAddStudent = new JLabel("Add Student");
//		lblAddStudent.setForeground(Color.DARK_GRAY);
//		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD, 22));
//		
//		JLabel lblName = new JLabel("Name:");
//                
//                textField = new JTextField();
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10); 
//                
//		textField_2 = new JTextField();
//		textField_2.setColumns(10);
//		
//		passwordField = new JPasswordField();
//		
//                
//                JLabel lblID = new JLabel("Student ID:");
//                
//                JLabel lblContactNo = new JLabel("Student Contact No:");
//               
//                JLabel lblPassword = new JLabel("Password:");
//		
//		
//		
//		JButton btnNewButton = new JButton("Add Student");
//		btnNewButton.addActionListener((ActionEvent e) -> {
//                    String name1 = textField.getText();
//                    String password=String.valueOf(passwordField.getPassword());
//                    String IDs=textField_1.getText();
//                    int ID=Integer.parseInt(IDs);
//                    String contact=textField_2.getText();
//                    int i = StudentDao.save(name1, password, ID, contact, );
//                    if(i>0){
//                        JOptionPane.showMessageDialog(StudentForm.this,"Student added successfully!");
//                        LibrarianSuccess.main(new String[]{});
//                        frame.dispose();
//                        
//                    }else{
//                        JOptionPane.showMessageDialog(StudentForm.this,"Sorry, unable to save!");
//                    }
//                });
//		btnNewButton.setForeground(Color.DARK_GRAY);
//		
//		JButton btnBack = new JButton("Back");
//		btnBack.addActionListener((ActionEvent e) -> {
//                    LibrarianSuccess.main(new String[]{});
//                    frame.dispose();
//                });
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.TRAILING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addGap(20)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
//						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
//						.addComponent(lblName)
//						.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//						
//						.addComponent(lblContactNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//					.addGap(58)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
//						
//						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
//						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
//						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
//						.addComponent(passwordField))
//					.addContainerGap(107, Short.MAX_VALUE))
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap(151, Short.MAX_VALUE)
//					.addComponent(lblAddStudent)
//					.addGap(144))
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap(160, Short.MAX_VALUE)
//					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
//					.addGap(133))
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap(200, Short.MAX_VALUE)
//					.addComponent(btnBack)
//					.addGap(169))
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addComponent(lblAddStudent)
//					.addGap(18)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(lblName)
//							.addGap(18)
//							.addComponent(lblPassword))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//							.addPreferredGap(ComponentPlacement.UNRELATED)
//							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
//					.addGap(18)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//					.addComponent(lblID)
//					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(18)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(lblContactNo)
//						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(18)
//                                        
//					
//					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
//					.addComponent(btnBack)
//					.addGap(19))
//		);
//		contentPane.setLayout(gl_contentPane);
//	}
//
//}
