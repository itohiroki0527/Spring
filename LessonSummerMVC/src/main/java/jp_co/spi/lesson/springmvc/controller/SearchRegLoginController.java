package jp_co.spi.lesson.springmvc.controller;



import java.util.ArrayList;
import java.util.List;

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
import jp_co.spi.lesson.springmvc.form.SearchRegFormcopy;
import jp_co.spi.lesson.springmvc.form.aikotobaForm;
import jp_co.spi.lessoon.springmvc.dao.DaoDb;



@Controller
@Scope("session")

public class SearchRegLoginController  {
	
	@RequestMapping(value = "/searchReg",method = RequestMethod.GET)
	public String initializeLogin(Model model)  {
		// モデルの中にメッセージを格納して
		// LoginFormをインスタンス化
		aikotobaForm aikotobaForm = new aikotobaForm();
		model.addAttribute("aikotobaForm",aikotobaForm);
		
		
		SearchRegForm form = new SearchRegForm();
		model.addAttribute("message","入力してください");
		model.addAttribute("searchRegForm",form);
		System.out.println("SearchRegの入力してくださいが表示されました");
		return "searchReg";

	}

	@RequestMapping(value = "/searchReg",method = RequestMethod.POST)
	public String executeLogin(Model model,@Validated @ModelAttribute SearchRegForm form, BindingResult result,	RedirectAttributes redirectAttr)  {

		// バリデーションのif文
		if(!result.hasErrors()) {
			
			SearchRegFormcopy.setInputName(form.getInputName());
			SearchRegFormcopy.setInputAdress(form.getInputAdress());
			SearchRegFormcopy.setInputTel(form.getInputTel());
			SearchRegFormcopy.setInputSendName(form.getInputSendName());
			SearchRegFormcopy.setInputAikotoba(form.getInputAikotoba());
			SearchRegFormcopy.setInputMessage(form.getInputMessage());
			
			//SearchRegFormcopy.setInputInfo(form.getInputInfo());
			
			model.addAttribute("SearchRegForm",form);
			System.out.println("SearchRegの送信が押下されました");
			return"redirect:/confirm";
			
		} else {
			model.addAttribute("search_reg_mesage","未入力です。");
			System.out.println("SearchRegの未入力です。が表示されました。");
			return"searchReg";
		}
		
	}
	
	
	@RequestMapping(value ="/searchReg" ,params ="c" , method = RequestMethod.POST)
	public String thankyou(Model model ,@ModelAttribute SearchRegForm form) {
		
		System.out.println("検索ボタンがおされました。");
		 List<aikotobaForm> aikotobaList = new ArrayList <aikotobaForm>();
		 aikotobaForm aikotobaForm = new aikotobaForm();
		
		aikotobaList = DaoDb.JDBC(form.getInputInfo());
		model.addAttribute("aikotobaList",aikotobaList);
		model.addAttribute("aikotobaForm",aikotobaForm);
		
		
		return"searchReg";

	}
}