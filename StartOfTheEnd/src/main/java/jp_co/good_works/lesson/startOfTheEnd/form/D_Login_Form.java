package jp_co.good_works.lesson.startOfTheEnd.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;

public class D_Login_Form {

	@NotNull
	private String userId;
	
	@NotNull
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
