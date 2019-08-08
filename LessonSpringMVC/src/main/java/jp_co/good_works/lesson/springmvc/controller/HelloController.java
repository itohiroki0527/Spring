package jp_co.good_works.lesson.springmvc.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// �@���̃t�@�C���̓R���g���[���ł��Ƃ����錾�@MVC���f���ō���쐬���Ă���̂ŋL�ڂ͕K�{
@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	// /hello�ƃA�N�Z�X���ꂽ��@���Lhello���\�b�h�����s�����B
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		//model�Ƃ�������message�Ƃ����Ȃ̖��O��Hallo Spring!�Ƃ�����������i�[���Ă���
		model.addAttribute("message", "<script>alert()</script>" );
		// hello.jsp�֑J�ڂ���
		return "hello";
	}
	
}
