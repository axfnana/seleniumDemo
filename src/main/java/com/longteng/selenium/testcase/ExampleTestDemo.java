package com.longteng.selenium.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.longteng.qa.database.DBUtil;
import com.longteng.qa.util.Logger;
import com.longteng.selenium.page.ExampleBaiduHomePage;
import com.longteng.selenium.page.ExampleJdHomePage;

public class ExampleTestDemo extends TestBase{
//	DBUtil dbUtil = new DBUtil("M");
//	MongoUtil mongoUtil = new MongoUtil("MONGO");
	ExampleJdHomePage jdHomePage=null;
	ExampleBaiduHomePage baiduHomePage=null;
	
	@BeforeClass
	public void initPage(){
		//链接数据库
//		dbUtil.connection();
		jdHomePage = PageFactory.initElements(driver, ExampleJdHomePage.class);
		baiduHomePage = PageFactory.initElements(driver, ExampleBaiduHomePage.class);
	}

	@AfterClass(alwaysRun=true)
	public void afterClass(){
		//断开数据库链接
//		dbUtil.close();
	}
	
    @Test
    public  void goJdHomePage(String a) throws Exception {
//    	Object name = dbUtil.selectForFirstColumn("select name from user");
//    	dbUtil.execute("update ");
    	System.out.println(a);
    	driver.get("http://www.jd.com");
    	Thread.sleep(2000);
    	Assert.assertEquals(a, "2700-2799");
    	input(jdHomePage.serachGood, "iphone6");
    	jdHomePage.serachGood.clear();
    	jdHomePage.serachGood.sendKeys("iphone6");
    	Thread.sleep(2000);
    	jdHomePage.serachButton.click();
    	Thread.sleep(2000);
    }
    
    @Test
    public  void goJdHome() throws Exception {
    	Logger.log("进入京东首页");
    	driver.get("http://www.jd.com");
    	Thread.sleep(2000);
    	Logger.log("进行断言");
    	Logger.Defaultlog("sssssa");
    	Assert.assertFalse(true);
//    	input(jdHomePage.serachGood, "iphone6");
//    	doubleClick(jdHomePage.serachGood);
//    	
//    	
//    	jsExecutor(jdHomePage.serachGood, "2015-11-21");
//    	
//    	moveToElement(jdHomePage.serachGood);
//    	
//    	toBeInvisible(jdHomePage.serachGood);
//    	
//    	click(getElementByTagAndName("a", "微信"));
//    	Thread.sleep(2000);
//    	jdHomePage.serachButton.click();
//    	Thread.sleep(2000);
    }
    
    /**
     * 弹出对话框的处理之自定义弹框
     * @throws Exception
     */
    @Test(dataProvider="csv",enabled=false)
    public void test_login(String user,String password,String message) throws Exception {
      Logger.log("进入百度首页");
  	  String  baseUrl = "https://www.baidu.com/";
  	  driver.get(baseUrl);
  	//  delay(2);
  	  Logger.log("点击登录超链接");
  	  driver.findElement(By.xpath("(//a[contains(text(),'登录')])[2]")).click();
  	  //delay(2);
  	  Logger.log("输入用户名"+user);
  	  input(baiduHomePage.userName_input,user);
  	  valueToBe(baiduHomePage.userName_input, user+"ss");
  	  //delay(2);
  	  Logger.log("输入密码"+password);
  	  input(baiduHomePage.password_input,password);
  	  //delay(2);
  	  Logger.log("验证记住密码复选框初始状态为选中");
  	  toBeSelected(baiduHomePage.memberPass_cbox);
  	  Logger.log("点击记住密码复选框");
  	  click(baiduHomePage.memberPass_cbox);
  	  Logger.log("验证记住密码复选框未被选中");
  	  toBeNotSelected(baiduHomePage.memberPass_cbox);
  	  //delay(2);
  	  Logger.log("点击登录按钮");
  	  baiduHomePage.login_btn.click();
  	  Logger.log("验证是否登录成功");
  	  if(user.isEmpty()||password.isEmpty()){//用户名密码有空值
  		  textToBe(baiduHomePage.error_label, message);
  		  delay(2);
  		  Logger.log("点击关闭按钮");
  		  baiduHomePage.close_btn.click();
  		  Logger.log("点击登录框关闭");
  		  toBeInvisible(baiduHomePage.userName_input);
  	  }else{//用户名密码都不为空
  		  if(user.equals("谷歌亦人身")&&password.equals("nihuaiqing2237")){//用户名密码正确
			  toBeNotPresent(By.id(baiduHomePage.userName_input.getAttribute("id")));
  			  toBePresent(By.xpath("//a[@id='s_usersetting_top']/span"));
  		  }else{//用户或名密码错误
  			  textToBe(baiduHomePage.error_label, message);
  			  delay(2);
  			  Logger.log("点击关闭按钮");
  			  baiduHomePage.close_btn.click();
  			  Logger.log("点击登录框关闭");
  			  toBeInvisible(baiduHomePage.userName_input);
  		  }
  	  }
  	  

  	  
    }

    
}
