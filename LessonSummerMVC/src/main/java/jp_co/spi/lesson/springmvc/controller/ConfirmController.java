package jp_co.spi.lesson.springmvc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp_co.spi.lesson.springmvc.form.LoginForm;
import jp_co.spi.lesson.springmvc.form.SearchRegForm;
import jp_co.spi.lesson.springmvc.form.SearchRegFormcopy;
import jp_co.spi.lesson.springmvc.form.confirmForm;
import jp_co.spi.lessoon.springmvc.dao.DaoDb;

@Controller

@Scope("session")
public class ConfirmController {
	
	@RequestMapping(value = "/confirm",method = RequestMethod.GET)
	public String initializeLogin(Model model)  {
		SearchRegForm Form = new SearchRegForm();
		
		String name = SearchRegFormcopy.getInputName();
		String address = SearchRegFormcopy.getInputAdress();
		String tel = SearchRegFormcopy.getInputTel();
		String sendname = SearchRegFormcopy.getInputSendName();
		String aikotoba = SearchRegFormcopy.getInputAikotoba();
		String message = SearchRegFormcopy.getInputMessage();
		
		model.addAttribute("sendConfirmFormName",name);
		model.addAttribute("sendConfirmFormAddress",address);
		model.addAttribute("sendConfirmFormTel",tel);
		model.addAttribute("sendConfirmFormSendname",sendname);
		model.addAttribute("sendConfirmFormAikotoba",aikotoba);
		model.addAttribute("sendConfirmFormMessage",message);
		return "confirm";

	}
	

	@RequestMapping(value ="/confirm" ,params ="a" , method = RequestMethod.POST)
	public String back(Model model ,@Validated @ModelAttribute confirmForm form , BindingResult result) {
		
		System.out.println("confirmの修正ボタンが押されました。");
		model.addAttribute("sendConfirmForm",form);
		return "redirect:/searchReg";

	}
	
	@RequestMapping(value ="/confirm" ,params ="b" , method = RequestMethod.POST)
	public String thankyou(Model model ,@Validated @ModelAttribute confirmForm form , BindingResult result) {
		
		String name = SearchRegFormcopy.getInputName();
		String address = SearchRegFormcopy.getInputAdress();
		String tel = SearchRegFormcopy.getInputTel();
		String sendname = SearchRegFormcopy.getInputSendName();
		String aikotoba = SearchRegFormcopy.getInputAikotoba();
		String message = SearchRegFormcopy.getInputMessage();
		
		
		System.out.println("confirmの送信ボタンがされました。");
		DaoDb dao = new DaoDb();
		dao.findAll(name , address , tel , sendname , aikotoba , message);
		model.addAttribute("sendConfirmForm",form);
		return "redirect:/thankyou";

	}
}
