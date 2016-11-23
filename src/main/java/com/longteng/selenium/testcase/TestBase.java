package com.longteng.selenium.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.longteng.qa.util.Logger;
import com.longteng.qa.webdriver.DriverBase;
import com.longteng.selenium.page.P2pLoginPage;

public class TestBase extends DriverBase {

	P2pLoginPage loginpage = null;

	@BeforeTest
	public void beforeTestBase() {

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {

	}

	@BeforeClass
	public void beforeBaseClass() {
		launch();
		Logger.log("进入测试网址" + System.getProperty("WebDriver.WebSite"));
		driver.get(System.getProperty("WebDriver.WebSite"));
		loginpage = PageFactory.initElements(driver, P2pLoginPage.class);
		if (driver.getTitle().equals("p2p信贷 - 管理员登录")) {
			loginpage.loginBus();
		}
	}

	@Test
	public void testdemo() {

	}

	@AfterClass(alwaysRun = true)
	public void afterBaseClass() {
		quit();
	}

	/**
	 * quit browser
	 */
	private void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
