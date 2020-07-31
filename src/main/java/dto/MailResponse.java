package dto;

import java.util.List;

/**
 * @author sugamagarwal
 */
public class MailResponse {


    private final List<String> recepients;
    private final String from;
    private final String message;


    public MailResponse(List<String> recepients, String from, String message) {
        this.recepients = recepients;
        this.from = from;
        this.message = message;
    }

    public List<String> getRecepients() {
        return recepients;
    }

    public String getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }
}
