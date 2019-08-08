package jp_co.good_works.lesson.springmvc.controller;
public class ProductForm {
	private String name;
	private Integer price;
	
	public void setName (String name){
		this.name = name;
	}
	public String getName () {
		return name;
	}
	public void setPrice (Integer price) {
		this.price = price;
	}
	public Integer getPrice () {
		return price;
	}
}
