package jp_co.good_works.lesson.startOfTheEnd.controller.no_cert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp_co.good_works.lesson.startOfTheEnd.exception.D_Login_Exception;
import jp_co.good_works.lesson.startOfTheEnd.form.D_Login_Form;
import jp_co.good_works.lesson.startOfTheEnd.logic.D_Login_Logic;


@Controller
@Scope("session")
public class D_LoginController  {

	private D_Login_Logic Login_Logic = new D_Login_Logic();

	public boolean isLive() {
		return Login_Logic.isLive();
	}

	@RequestMapping(value = "/D_login",method = RequestMethod.GET)
	public String initializeLogin(Model model)  {
		// ���f���̒��Ƀ��b�Z�[�W���i�[����
		// LoginForm���C���X�^���X��
		D_Login_Form form = new D_Login_Form();
		model.addAttribute("message","���͂��Ă�������");
		model.addAttribute("a_loginForm",form);
		return "D_Login";

	}



	@RequestMapping(value = "/D_login",method = RequestMethod.POST)
	public String executeLogin(Model model,@Validated @ModelAttribute D_Login_Form form, BindingResult result,	RedirectAttributes redirectAttr)  {

		// �o���f�[�V������if��
		if(!result.hasErrors()) {
			try {
				// loginLogic�N���X��login���\�b�h���Ăяo��
				// LoginForm.java��GET~��
				Login_Logic.D_login(form.getUserId (), form.getPassword());
				return "redirect:/";			
			} catch(D_Login_Exception ex) {
				model.addAttribute("message",ex.getLocalizedMessage());
				ex.printStackTrace();
			}		
		} else {
			System.out.println("�o���f�[�V�����G���[�ł���[");
			//model.addAttribute("loginForm",form);
			model.addAttribute("message","���[�U�[ID�A�p�X���[�h����͂��Ă��������B");
		}
		return"D_Login";
	}
}

