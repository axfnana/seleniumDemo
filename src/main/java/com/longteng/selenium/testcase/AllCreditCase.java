package com.longteng.selenium.testcase;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.longteng.qa.util.Logger;
import com.longteng.selenium.page.AllCreditPage;

public class AllCreditCase extends TestBase{
	
	AllCreditPage allCrePage = null;
	/**
	 * 新增贷款的case
	 * @throws AWTException 
	 */
	@Test(dataProvider="csv",enabled=true)
	public void addCreditCase(String money) throws AWTException {
		allCrePage = PageFactory.initElements(driver, AllCreditPage.class);
		Logger.log("点击菜单");
		allCrePage.menuClick(driver,allCrePage.firstMenu,allCrePage.secondMenu,allCrePage.thirdMenu);
		driver.switchTo().frame("main-frame");
		Logger.log("点击新增贷款按钮");
		allCrePage.addButton.click();
		Logger.log("填写新增贷款详细信息！");
		allCrePage.addCredit(driver,money);
		allCrePage.backlist.click();
		driver.switchTo().defaultContent();
	}
	
	
	

}
