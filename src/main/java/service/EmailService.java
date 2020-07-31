package service;

import dto.MailRequest;
import dto.MailResponse;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

public class EmailService {

    Session session;

    public EmailService(String username, String password) {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

         session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    public MailResponse triggerEmail(MailRequest mailRequest, String fromEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail + "@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(String.join(",", mailRequest.getRecipients()))
            );
            message.setSubject(mailRequest.getSubject());
            message.setText(mailRequest.getContent());
            Transport.send(message);
            return new MailResponse(mailRequest.getRecipients(), fromEmail, mailRequest.getContent());
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        }
    }
}