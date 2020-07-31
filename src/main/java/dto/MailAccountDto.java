package dto;

/**
 * @author sugamagarwal
 */

public class MailAccountDto {

    private String protocol;
    private long userId;
    private String mailHostUrl;
    private String mailUserName;
    private String senderEmailAddress;
    private String mailPassword;


    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMailHostUrl() {
        return mailHostUrl;
    }

    public void setMailHostUrl(String mailHostUrl) {
        this.mailHostUrl = mailHostUrl;
    }

    public String getMailUserName() {
        return mailUserName;
    }

    public void setMailUserName(String mailUserName) {
        this.mailUserName = mailUserName;
    }

    public String getSenderEmailAddress() {
        return senderEmailAddress;
    }

    public void setSenderEmailAddress(String senderEmailAddress) {
        this.senderEmailAddress = senderEmailAddress;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }
}
