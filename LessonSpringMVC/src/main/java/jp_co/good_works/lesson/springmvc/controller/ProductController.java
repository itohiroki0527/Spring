package jp_co.good_works.lesson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> b291c6ddc282ebe63011b8d890f0e83bb29546e6
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD
import jp_co.good_works.lesson.springmvc.form.ProductForm;
=======
>>>>>>> b291c6ddc282ebe63011b8d890f0e83bb29546e6

@Controller
@Scope("session")
public class ProductController {
<<<<<<< HEAD
	ProductForm form = new ProductForm();
	private List<ProductForm> productList = new ArrayList<ProductForm>();
	
	@RequestMapping(value ="/product", method = RequestMethod.GET)
=======
	private List<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
>>>>>>> b291c6ddc282ebe63011b8d890f0e83bb29546e6
	public String product(Model model) {

		model.addAttribute("message", "商品情報を入力してください");
		model.addAttribute("productForm", form);
		return "product";
	}
<<<<<<< HEAD
	
	
	
	@RequestMapping(value ="/product", method = RequestMethod.POST)
	public String product(Model model, @Validated @ModelAttribute ProductForm form, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("message", "エラーがあります");				
		}else {
			model.addAttribute("message", "商品情報が入力されました");
			productList.add(form);
		}
		
		
		model.addAttribute("productForm", form);
		model.addAttribute("productList", productList);
=======



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
>>>>>>> b291c6ddc282ebe63011b8d890f0e83bb29546e6
		return "product";
	}
}
