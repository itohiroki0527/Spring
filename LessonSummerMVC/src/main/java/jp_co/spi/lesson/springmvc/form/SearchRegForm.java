package jp_co.spi.lesson.springmvc.form;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchRegForm {

	@NotEmpty
	private String inputName;
	
	@NotEmpty
	private String inputAdress;
	
	@NotEmpty
	private String inputTel;
	
	@NotEmpty
	private String inputSendName;
	
	@NotEmpty
	private String inputAikotoba;
	
	@NotEmpty
	private String inputMessage;
	

	
	
	
	
	private  String inputInfo;
		

	
	public String getInputInfo() {
		return inputInfo;
	}

	public void setInputInfo(String inputInfo) {
		this.inputInfo = inputInfo;
	}

	
	
	
	
	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputAdress() {
		return inputAdress;
	}

	public void setInputAdress(String inputAdress) {
		this.inputAdress = inputAdress;
	}

	public String getInputTel() {
		return inputTel;
	}

	public void setInputTel(String inputTel) {
		this.inputTel = inputTel;
	}

	public String getInputSendName() {
		return inputSendName;
	}

	public void setInputSendName(String inputSendName) {
		this.inputSendName = inputSendName;
	}

	public String getInputAikotoba() {
		return inputAikotoba;
	}

	public void setInputAikotoba(String inputAikotoba) {
		this.inputAikotoba = inputAikotoba;
	}

	public String getInputMessage() {
		return inputMessage;
	}

	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	
	
	
	
}
