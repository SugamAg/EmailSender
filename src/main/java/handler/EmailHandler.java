package handler;

import dto.MailRequest;
import org.hibernate.Session;
import service.EmailService;

/**
 * @author sugamagarwal
 */
public class EmailHandler {

    private static EmailService emailService;

    static {
         emailService = new EmailService();
    }

    public static Object triggerEmail(MailRequest mailRequest) {
       return emailService.triggerEmail(mailRequest);
    }

}
