package jp_co.spi.lesson.springmvc.form;

import org.hibernate.validator.constraints.NotEmpty;

public class aikotobaForm {

	@NotEmpty
	private String dbName;
	
	@NotEmpty
	private String dbAdress;
	
	@NotEmpty
	private String dbTel;
	
	@NotEmpty
	private String dbSendName;
	
	@NotEmpty
	private String dbAikotoba;
	
	@NotEmpty
	private String dbMessage;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbAdress() {
		return dbAdress;
	}

	public void setDbAdress(String dbAdress) {
		this.dbAdress = dbAdress;
	}

	public String getDbTel() {
		return dbTel;
	}

	public void setDbTel(String dbTel) {
		this.dbTel = dbTel;
	}

	public String getDbSendName() {
		return dbSendName;
	}

	public void setDbSendName(String dbSendName) {
		this.dbSendName = dbSendName;
	}

	public String getDbAikotoba() {
		return dbAikotoba;
	}

	public void setDbAikotoba(String dbAikotoba) {
		this.dbAikotoba = dbAikotoba;
	}

	public String getDbMessage() {
		return dbMessage;
	}

	public void setDbMessage(String dbMessage) {
		this.dbMessage = dbMessage;
	}
	
	
}
