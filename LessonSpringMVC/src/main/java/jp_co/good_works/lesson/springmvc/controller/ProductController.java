package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Scope("session")
public class ProductController {
	private List<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model) {
		ProductForm form = new ProductForm();
		model.addAttribute("message", "商品情報を入力してください");
		model.addAttribute("productForm", form);
		return "product";
	}



	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product(Model model,@ModelAttribute ProductForm form){
		if(form.getName() == null || form.getPrice() == null) {
			model.addAttribute("message", "商品情報が空です");
		} else {
			model.addAttribute("message", "商品情報が入力されました");
			productList.add(form);
		}

		model.addAttribute("productForm",form);
		//productListの中にproductListが入っている。今まで入力したもの。
		model.addAttribute("productList",productList);
		return "product";
	}
}
