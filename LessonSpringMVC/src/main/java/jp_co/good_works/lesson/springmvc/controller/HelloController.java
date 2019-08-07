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
//　このファイルはコントローラですという宣言　MVCモデルで今回作成しているので記載は必須
@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	// /helloとアクセスされたら　下記helloメソッドが実行される。
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		//modelという箱にmessageというなの名前でHallo Spring!という文字列を格納している
		model.addAttribute("message", "Hallo Spring!" );
		// hello.jspへ遷移する
		return "hello";
	}
	
}
