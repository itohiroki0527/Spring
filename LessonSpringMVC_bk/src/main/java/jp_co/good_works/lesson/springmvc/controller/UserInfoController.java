package jp_co.good_works.lesson.springmvc.controller;

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

import jp_co.good_works.lesson.springmvc.form.UserInfoForm;

// 
@Controller

//
@Scope("session")
public class UserInfoController {
	List<UserInfoForm> userInfoFormList = new ArrayList<UserInfoForm>();

	// 最初の入力フォームのため、GET
	@RequestMapping(value="/userinfo", method = RequestMethod.GET)
	public String userInfo(Model model) {

		// 各インスタンスの生成。
		UserInfoForm form = new UserInfoForm();
		
		// それぞれのインスタンスをリストで追加できる
		List<String> genders = new ArrayList<String>();
		List<String> birthplace = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();
		// "userInfoFormList"にuserInfoFormListをmodel.addAttributeで渡される
		// userInfoFormList.nameやuserInfoFormList.ageをjspに表示させるために必要
		model.addAttribute("userInfoFormList",userInfoFormList);
		
		// 性別を追加
		genders.add("男");
		genders.add("女");
		// genders.addされた値が"genders"にmodel.addAttributeで渡される
		model.addAttribute("genders",genders);

		// 言語を追加
		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		// favoriteLangs.addされた値が"favoriteLangs"にmodel.addAttributeで渡される
		model.addAttribute("favoriteLang",favoriteLangs);

		// 所在地を追加
		// 最初の表示は未選択にしたいため、""にしている
		birthplace.add("");
		birthplace.add("北海道");
		birthplace.add("東北");
		birthplace.add("関東");
		birthplace.add("中部");
		birthplace.add("近畿");
		birthplace.add("中国");
		birthplace.add("四国");
		birthplace.add("九州");
		// birthplace.addされた値が"birthplace"にmodel.addAttributeで渡される
		model.addAttribute("birthplace",birthplace);

		// "massage"に"入力してください"をmodel.addAttributeして渡している
		model.addAttribute("massage","入力してください");
		// formに"userInfoForm"をmodel.addAttributeして渡している。
		model.addAttribute("userInfoForm",form);
		return "userinfo";
	}

	// GETされた後、POSTで再び入力フォームを出す。
	@RequestMapping(value ="/userinfo" , method = RequestMethod.POST)
	public String userInfo(Model model ,@Validated @ModelAttribute UserInfoForm form , BindingResult result) {

		// 
		List<String> genders = new ArrayList<String>();
		List<String> birthplace = new ArrayList<String>();
		List<String> favoriteLangs = new ArrayList<String>();

		// 
		genders.add("男");
		genders.add("女");
		model.addAttribute("genders",genders);

		// 
		favoriteLangs.add("Java");
		favoriteLangs.add("C#");
		favoriteLangs.add("C/C++");
		favoriteLangs.add("PHP");
		favoriteLangs.add("Perl");
		favoriteLangs.add("Ruby");
		favoriteLangs.add("Python");
		model.addAttribute("favoriteLang",favoriteLangs);

		// 
		birthplace.add("");
		birthplace.add("北海道");
		birthplace.add("東北");
		birthplace.add("関東");
		birthplace.add("中部");
		birthplace.add("近畿");
		birthplace.add("中国");
		birthplace.add("四国");
		birthplace.add("九州");
		model.addAttribute("birthplace",birthplace);
	
		// 
		if(result.hasErrors()) {
			System.out.println("----------------");
			System.out.println(result.getObjectName());
			System.out.println("----------------");
			
		}else {
			model.addAttribute("massage","入力されました");
			userInfoFormList.add(form);
		}

		// 
		model.addAttribute("userInfoFormList",userInfoFormList);
		model.addAttribute("userInfoForm",form);
		return "userinfo";

	}
}
