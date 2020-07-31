package models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * mail property database entity class. 
 * 
 * @author ii00083746
 *
 */


@Entity
@Table(name = "mail_property")
public class MailPropertyEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "mail_property_key")
	@NotNull
	private String mailPropertyKey;
	
	@Column(name = "mail_property_value")
	@NotNull
	private String mailPropertyValue;
	
	@Column(name = "entry_date")
	private Date entryDate;
	
	@Column(name = "update_date")
	@NotNull
	private Date updateDate;
	
	public MailPropertyEntity() {
		super();
		this.updateDate = new Date();
	}
	
	public MailPropertyEntity(String key, String value) {
		super();
		this.mailPropertyKey = key;
		this.mailPropertyValue = value;
		this.updateDate = new Date();
	}
	
	
}
    