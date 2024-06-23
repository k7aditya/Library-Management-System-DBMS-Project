import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentForm extends JFrame {
    private JTextField paymentField;
    private JComboBox<String> paymentMethodDropdown;

    public PaymentForm() {
        setTitle("Payment Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel paymentLabel = new JLabel("Enter Payment Amount:");
        paymentField = new JTextField(15);

        JLabel paymentMethodLabel = new JLabel("Select Payment Method:");
        String[] paymentMethods = {"UPI", "Debit Card", "Credit Card"};
        paymentMethodDropdown = new JComboBox<>(paymentMethods);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String paymentAmount = paymentField.getText();
        if (!paymentAmount.isEmpty()) {
            String upiLink = "tftyfyftyfjyj" + paymentAmount;
            
            try {
                // Open the UPI link in the default web browser
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(upiLink));
            } catch (java.io.IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error opening UPI link. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid payment amount.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
});

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addGap(50)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(paymentLabel)
                                .addComponent(paymentMethodLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(paymentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(paymentMethodDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payButton)
                        .addGap(50)));

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup().addGap(50)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(paymentLabel).addComponent(paymentField, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(paymentMethodLabel)
                                .addComponent(paymentMethodDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(payButton))
                        .addGap(50)));

        add(panel);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaymentForm().setVisible(true);
            }
        });
    }
}
