package com.longteng.selenium.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.longteng.qa.webdriver.DriverBase;
import com.longteng.selenium.page.P2pLoginPage;
import com.longteng.qa.database.DBUtil;
import com.longteng.qa.util.Logger;
public class P2pLoginCase extends DriverBase {
	P2pLoginPage P2pLogin = null;
	DBUtil db = new DBUtil("M");
	@BeforeClass
	public void initPage() {
		launch();
		// 链接数据库
		db.connection();
		P2pLogin = PageFactory.initElements(driver, P2pLoginPage.class);
	}

	@Test(dataProvider = "csv")
	public void loginCase(String username, String password) {
		Object name = db.selectForFirstColumn("select adm_name from fanwe_admin");
		System.out.println(name.toString()+"数据库操作~");
		driver.get(System.getProperty("WebDriver.WebSite"));
		Logger.log("输入用户名："+username);
		P2pLogin.userName.sendKeys(username);
		Logger.log("输入密码："+password);
		P2pLogin.passWord.sendKeys(password);
		Logger.log("输入验证码：1111");
		P2pLogin.verify.sendKeys("1111");
		Logger.log("点击登录按钮");
		P2pLogin.ogin_btn.click();
		try {
			Thread.sleep(2000);
//			Thread.currentThread();
			
			driver.switchTo().frame(0);
			String text = P2pLogin.tips.getText();
//			if (text.contains("登录账户:"+username)){
//				Assert.assertTrue(true);
//			}else if(P2pLogin.login_msg.getText().contains("管理员密码错误")){
//				Assert.assertTrue(true);
//			}else if(P2pLogin.login_msg.getText().contains("管理员账号错误")){
//				Assert.assertTrue(true);
//			}else if(P2pLogin.login_msg.getText().contains("验证码错误")){
//				Assert.assertTrue(true);
//			}else{
//				System.out.println("登录功能有异常");
//			}
			
			P2pLogin.ogin_out.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		Logger.log("登录成功！");
	}
	
	@AfterClass
	public void closedBrow() {
		driver.close();
	}

        
}
