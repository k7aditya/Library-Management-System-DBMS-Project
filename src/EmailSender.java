import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void sendEmail(String recipient, String subject, String body) throws MessagingException {
        // Gmail SMTP server configuration
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "lmsiiita9@gmail.com";
        String password = "zmdorvbaxuzhtvkx";
        
        // Email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        
        // Create session with authentication
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
            
            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + recipient);
        } catch (MessagingException e) {
            throw new MessagingException("Failed to send email. Reason: " + e.getMessage(), e);
        }
    }

//    public static void main(String[] args) {
//        try {
//            String recipient = "recipient_email@example.com";
//            String subject = "Test Email";
//            String body = "This is a test email sent from Java.";
//            sendEmail(recipient, subject, body);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}