package jp_co.good_works.lesson.startOfTheEnd.controller.no_cert;

import javax.security.auth.login.LoginException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.lesson.startOfTheEnd.dao.D_User_Dao;
import jp_co.good_works.lesson.startOfTheEnd.exception.D_Login_Exception;
import jp_co.good_works.lesson.startOfTheEnd.form.D_Login_Form;
import jp_co.good_works.lesson.startOfTheEnd.logic.D_Login_Logic;

@Controller
@Scope("session")
public class D_Search_Reg_Controller  {

	private D_Login_Logic loginLogic = new D_Login_Logic();

	public boolean isLive() {
		return loginLogic.isLive();
	}

	@RequestMapping(value = "/D_Search_Reg",method = RequestMethod.GET)
	public String initializeLogin(Model model)  {
		// モデルの中にメッセージを格納して
		// LoginFormをインスタンス化
		D_Login_Form form = new D_Login_Form();
		model.addAttribute("message","入力してください");
		model.addAttribute("loginForm",form);
		return "D_Search_Reg";

	}



	@RequestMapping(value = "/D_Search_Reg",method = RequestMethod.POST)
	public String executeLogin(Model model,@Validated @ModelAttribute D_Login_Form form, BindingResult result,	RedirectAttributes redirectAttr)  {

		// バリデーションのif文
		if(!result.hasErrors()) {
			try {
				// loginLogicクラスのloginメソッドを呼び出す
				// LoginForm.javaのGET~の
				loginLogic.D_login(form.getUserId (), form.getPassword());
				return "redirect:/hello";			
			} catch(D_Login_Exception ex) {
				model.addAttribute("message",ex.getLocalizedMessage());
			}		
		} else {
			model.addAttribute("mesage","ユーザーID、パスワードを入力してください。");
		}
		return"hello";
	}
}

