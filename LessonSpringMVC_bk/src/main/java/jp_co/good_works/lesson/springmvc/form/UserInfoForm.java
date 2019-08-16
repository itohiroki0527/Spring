package jp_co.good_works.lesson.springmvc.form;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserInfoForm {
	// 文字列制限
	@NotEmpty
	private String name;
	
	// 最小値制約
	@Min(value = 20)
	
	// 数値制約
	@NotNull
	private Integer age;
	private String gender;
	private String birthplace;
	private List<String> favoriteLangs;

	// メール形式制約
	@Email
	private String mail;
	private String etc;

	// ↓のアクセサメソッドの作成の仕方：右クリ→source→
	// Generate Getter and Setter → 選択して作成
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEtc() {
		return etc;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getFavoriteLangs() {
		return favoriteLangs;
	}
	public void setFavoriteLangs(List<String> favoriteLangs) {
		this.favoriteLangs = favoriteLangs;
	}

}
