package handler;

import dto.MailRequest;
import org.hibernate.Session;
import service.EmailService;

/**
 * @author sugamagarwal
 */
public class EmailHandler {

    private static EmailService emailService;
    private Session session;


    private static final String from = "*****";
    private static final String from_pwd = "******";

    static {
         emailService = new EmailService(from, from_pwd);
    }

    public static Object triggerEmail(MailRequest mailRequest) {
       return emailService.triggerEmail(mailRequest, from);
    }

}
