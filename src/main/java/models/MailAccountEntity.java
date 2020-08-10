package models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
* database table mail account configuration entity class.
*
* @author ii00083746
*
*/
@Entity
@Table(name = "mail_account_configuration")
public class MailAccountEntity {

@Id
@GeneratedValue
@Column(name = "id")
private long id;

@Column(name = "protocol")
@NotNull
private String protocol;

@Column(name = "user_id")
@NotNull
private long userId;

@Column(name = "connection_name")
@NotNull
private String connectionName;

@Column(name = "mail_host_url")
@NotNull
private String mailHostUrl;

@Column(name = "mail_user_name")
@NotNull
private String mailUserName;

@Column(name = "sender_email_address")
private String senderEmailAddress;

@Column(name = "mail_password")
@NotNull
private String mailPassword;

@Column(name = "store_type")
private String storeType;

@Column(name = "read_folder")
private String readFolder;

@Column(name = "scheduler")
private int scheduler;

@Column(name = "is_active")
private boolean active;

@Column(name = "entry_date")
private Date entryDate;

@Column(name = "update_date")
@NotNull
private Date updateDate;

@JoinColumn(name = "mail_configuration_id", updatable = true, insertable = true)
@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<MailPropertyEntity> mailProperties;

public MailAccountEntity() {
this.updateDate = new Date();
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
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

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getReadFolder() {
        return readFolder;
    }

    public void setReadFolder(String readFolder) {
        this.readFolder = readFolder;
    }

    public int getScheduler() {
        return scheduler;
    }

    public void setScheduler(int scheduler) {
        this.scheduler = scheduler;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<MailPropertyEntity> getMailProperties() {
        return mailProperties;
    }

    public void setMailProperties(List<MailPropertyEntity> mailProperties) {
        this.mailProperties = mailProperties;
    }
}