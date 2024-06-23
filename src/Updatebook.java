import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;



public class Updatebook extends JFrame {
    static Updatebook frame;
	private JPanel contentPane;
        private JTextField textField;
	private JTextField textField_1;
        
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Updatebook();
					frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	}
        
        
        
        public Updatebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUpdatebook = new JLabel("Update Books");
		lblUpdatebook.setForeground(Color.GRAY);
		lblUpdatebook.setFont(new Font("Tahoma", Font.PLAIN, 18));
                
                JLabel lblCallNo = new JLabel("Callno:");
                
                JLabel lblQuantity = new JLabel("Quantity:");
                
                
                
                
                
                textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
                
                
                JButton btnupdatebutton = new JButton("Update Books");
		btnupdatebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String callno=textField.getText();
                        String squantity=textField_1.getText();
                        int quantity=Integer.parseInt(squantity);
                        int i = Updao.update(callno, quantity);
                        if(i>0){
				JOptionPane.showMessageDialog(Updatebook.this,"Books updated successfully!");
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(Updatebook.this,"Sorry, unable to save!");
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		/*gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
                                                        .addComponent(lblUpdatebook))
						        .addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								
								.addComponent(lblCallNo)
								//.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								//addComponent(lblcategory, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								//.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								//.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								//.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnupdatebutton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
                gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblUpdatebook)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCallNo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					
					
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(lblUpdatebook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBack)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);*/
                
                
               // GroupLayout gl_contentPane = new GroupLayout(contentPane);
gl_contentPane.setHorizontalGroup(
    gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGap(36)
            .addComponent(lblUpdatebook))
        .addGroup(gl_contentPane.createSequentialGroup()
            .addContainerGap()
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addComponent(lblCallNo)
                .addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
            .addGap(47)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGap(161)
            .addComponent(btnupdatebutton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
            .addContainerGap(359, Short.MAX_VALUE)
            .addComponent(btnBack)
            .addContainerGap())
);
gl_contentPane.setVerticalGroup(
    gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addComponent(lblUpdatebook)
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblCallNo)
                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblQuantity)
                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(30)
            .addComponent(btnupdatebutton)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnBack)
            .addContainerGap(53, Short.MAX_VALUE))
);
contentPane.setLayout(gl_contentPane);

                                                        
        }

    
}
