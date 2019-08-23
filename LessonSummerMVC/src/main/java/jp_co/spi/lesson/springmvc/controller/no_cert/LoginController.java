package jp_co.spi.lesson.springmvc.controller.no_cert;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

import jp_co.spi.lesson.springmvc.form.LoginForm;
import jp_co.spi.lesson.springmvc.logic.LoginLogic;

@Controller
@Scope("session")

public class LoginController  {

	private LoginLogic loginLogic = new LoginLogic();

	public boolean isLive() {
		return loginLogic.isLive();
	}

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String initializeLogin(Model model , Locale locale)  {
		// モデルの中にメッセージを格納して
		// LoginFormをインスタンス化
		LoginForm form = new LoginForm();
		model.addAttribute("message","入力してください");
		model.addAttribute("loginForm",form);
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "login";

	}



	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String executeLogin(Model model,Locale locale,@Validated @ModelAttribute LoginForm form, BindingResult result,	RedirectAttributes redirectAttr)  {

		// バリデーションのif文
		if(!result.hasErrors()) {
			try {
				// loginLogicクラスのloginメソッドを呼び出す
				// LoginForm.javaのGET~の
				loginLogic.login(form.getUserId (), form.getPassword());
				//return "redirect:/";		↓でやったら遷移できた
				return"redirect:/searchReg";
			} catch(LoginException ex) {
				model.addAttribute("message",ex.getLocalizedMessage());
			}		
		} else {
			model.addAttribute("mesage","ユーザーID、パスワードを入力してください。");
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return"login";
	}
}