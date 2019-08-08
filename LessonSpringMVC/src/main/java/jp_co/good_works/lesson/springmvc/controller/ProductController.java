package jp_co.good_works.lesson.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		ProductForm form = new ProductForm();
		model.addAttribute("message", "商品情報を入力してください");
		model.addAttribute("productForm", form);
		return "product";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product(Model model,@ModelAttribute ProductForm form) {
		model.addAttribute("message", "商品情報が入力されました");
		model.addAttribute("productForm", form);
		return "product_result";
	}
}
