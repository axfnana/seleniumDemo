package com.longteng.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class P2pLoginPage {
	
//	@FindBy(id = "login_msg")
//	public WebElement login_msg;
//	
	@FindBy(name = "adm_name")
	public WebElement userName;
	
	@FindBy(name = "adm_password")
	public WebElement passWord;
	
	@FindBy(name = "adm_verify")
	public WebElement verify;
	
	@FindBy(id = "login_btn")
	public WebElement ogin_btn;
	
	@FindBy(linkText = "注销")
	public WebElement ogin_out;
	
	@FindBy(id = "tips")
	public WebElement tips;
	
   /**
    * 登录功能
    */
	public void loginBus(){
		userName.sendKeys("admin");
		passWord.sendKeys("admin");
		verify.sendKeys("1111");
		ogin_btn.click();
	}
	
	
}
