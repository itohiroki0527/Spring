package jp_co.spi.lessoon.springmvc.dao;
import java.io.Serializable;

//“¤
public class DtoDbBean implements Serializable{
	
    private String name="";
    private String address="";
	private int tel;
	 private String fromname="";
	 private String lastmessage="";
	 private String pass="";


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public String getLastmessage() {
		return lastmessage;
	}
	public void setLastmessage(String lastmessage) {
		this.lastmessage = lastmessage;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/*
	private int setcartid;
	private String cartname;
	private int cartprice;
	private int cartnum;

	public int getCartId() {
		return id;
	}
	public void setCartId(int cartid) {
		this.setcartid = cartid;
	}

	public String getCartName() {
		return cartname;
	}
	public void setCartName(String cartname) {
		this.cartname = cartname;
	}

	public int getCartPrice() {
		return cartprice;
	}
	public void setCartPrice(int cartprice) {
		this.cartprice = cartprice;
	}

	public int getCartNum() {
		return cartnum;
	}
	public void setCartNum(int cartnum) {
		this.cartnum = cartnum;
	}
	
	*/
}
