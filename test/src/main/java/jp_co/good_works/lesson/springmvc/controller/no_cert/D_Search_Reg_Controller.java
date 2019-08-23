package jp_co.good_works.lesson.springmvc.controller.no_cert;

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

import jp_co.good_works.lesson.springmvc.form.LoginForm;
import jp_co.good_works.lesson.springmvc.logic.LoginLogic;
import jp_co.good_works.lessoon.springmvc.dao.UserDao;

@Controller
@Scope("session")

public class D_Search_Reg_Controller  {

	private LoginLogic loginLogic = new LoginLogic();

	public boolean isLive() {
		return loginLogic.isLive();
	}

	@RequestMapping(value = "/D_Search_Reg",method = RequestMethod.GET)
	public String initializeLogin(Model model)  {
		// ���f���̒��Ƀ��b�Z�[�W���i�[����
		// LoginForm���C���X�^���X��
		LoginForm form = new LoginForm();
		model.addAttribute("message","���͂��Ă�������");
		model.addAttribute("loginForm",form);
		return "D_Search_Reg";

	}



	@RequestMapping(value = "/D_Search_Reg",method = RequestMethod.POST)
	public String executeLogin(Model model,@Validated @ModelAttribute LoginForm form, BindingResult result,	RedirectAttributes redirectAttr)  {

		// �o���f�[�V������if��
		if(!result.hasErrors()) {
			try {
				// loginLogic�N���X��login���\�b�h���Ăяo��
				// LoginForm.java��GET~��
				loginLogic.login(form.getUserId (), form.getPassword());
				return "redirect:/hello";			
			} catch(LoginException ex) {
				model.addAttribute("message",ex.getLocalizedMessage());
			}		
		} else {
			model.addAttribute("mesage","���[�U�[ID�A�p�X���[�h����͂��Ă��������B");
		}
		return"hello";
	}
}

