package jp_co.spi.lesson.springmvc.controller;



import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jp_co.spi.lesson.springmvc.form.SearchRegForm;
import jp_co.spi.lesson.springmvc.form.confirmForm;


@Controller
@Scope("session")

public class thankyouController  {
		@RequestMapping(value = "/thankyou",method = RequestMethod.GET)
		public String initializeLogin(Model model)  {
			Date date = new Date();
	        System.out.println(date.toString());
		return "thankyou";

	}
	
	@RequestMapping(value ="/thankyou" ,params ="logout" , method = RequestMethod.POST)
	public String back(Model model ,@Validated @ModelAttribute confirmForm form , BindingResult result) {
		
		System.out.println("ログアウトボタンが押されました。");
		return "redirect:/login";

	}
}