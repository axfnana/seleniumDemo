package com.longteng.selenium.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.longteng.qa.util.Base;
import com.longteng.qa.util.Logger;

public class AllCreditPage {

	// 菜单操作的定位信息

	@FindBy(linkText = "借贷管理")
	public WebElement firstMenu;

	@FindBy(xpath = "//dl[2]/dt")
	public WebElement secondMenu;

	@FindBy(linkText = "全部贷款")
	public WebElement thirdMenu;

	// ---------------------------------

	// 新增贷款信息定位器

	@FindBy(xpath = "//input[@value='新增']")
	public WebElement addButton;
	// 贷款名称
	@FindBy(name = "name")
	public WebElement name;
	// 简称
	@FindBy(name = "sub_name")
	public WebElement sub_name;
	//借款编号
	@FindBy(name = "deal_sn")
	public WebElement deal_sn;

	// 会员文本框
	@FindBy(name = "user_name")
	public WebElement user_name;
	// 隐藏会员名称
	@FindBy(name = "user_id")
	public WebElement user_id;

	// 选择分类
	@FindBy(name = "cate_id")
	public WebElement cate_id;

	// 选择借款用途
	@FindBy(name = "type_id")
	public WebElement type_id;

	// 借款合同范本
	@FindBy(name = "contract_id")
	public WebElement contract_id;

	// 转让合同范本
	@FindBy(name = "tcontract_id")
	public WebElement tcontract_id;
	// 借款金额
	@FindBy(name = "borrow_amount")
	public WebElement borrow_amount;
	// 借款保证金[第三方托管]
	@FindBy(name = "guarantees_amt")
	public WebElement guarantees_amt;
	// 最低投标金额
	@FindBy(name = "min_loan_money")
	public WebElement min_loan_money;
	// 年利率
	@FindBy(name = "rate")
	public WebElement rate;
	// 投标期限
	@FindBy(name = "enddate")
	public WebElement enddate;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submitButton;
	
	
	@FindBy(linkText = "返回列表")
	public WebElement backlist;

	// ---------------------------------
	// 删除贷款信息定位器

	// ----------------------------------
	// 查询贷款信息的定位器

	/**
	 * 点击菜单
	 * 
	 * @param driver
	 * @param first
	 * @param second
	 * @param third
	 */
	public void menuClick(WebDriver driver, WebElement first, WebElement second, WebElement third) {
		driver.switchTo().frame(0);
		first.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		second.click();
		third.click();
		driver.switchTo().defaultContent();
	}

	/**
	 * 新增一笔贷款
	 * 
	 * @throws AWTException
	 */
	public void addCredit(WebDriver driver, String money) throws AWTException {
		deal_sn.clear();
		deal_sn.sendKeys("MER20160000063"+Base.getRandomData("int", 3));
		Logger.log("输入贷款用途");
		name.sendKeys("买房结婚急需用钱，所以贷款");
		Logger.log("输入简称");
		sub_name.sendKeys("GFDK");
		// Robot robot = new Robot();
		Logger.log("输入会员名称");
		user_name.sendKeys("fangdai001");
		// robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		// robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].setAttribute('autocomplete','off');",user_name);
		jse.executeScript("arguments[0].removeAttribute('type');", user_id);
		jse.executeScript("arguments[0].setAttribute('value','2');", user_id);

		Logger.log("选择分类信息");
		Select selectcate = new Select(cate_id);
		selectcate.selectByVisibleText("|--实地认证标");
		Logger.log("选择借款用途");
		Select selecttype = new Select(type_id);
		selecttype.selectByVisibleText("购房借款");
		Logger.log("选择借合同类型");
		Select selectcontract = new Select(contract_id);
		selectcontract.selectByVisibleText("等额本息合同范本【普通】");
		Logger.log("选择转让合同类型");
		Select selecttcontract = new Select(tcontract_id);
		selecttcontract.selectByVisibleText("等额本息合同范本【普通】");
		Logger.log("借款金额");
		borrow_amount.clear();
		borrow_amount.sendKeys(money);
		Logger.log("输入第三方保证金");
		guarantees_amt.clear();
		guarantees_amt.sendKeys("1000");
		Logger.log("输入最低投标金额");
		min_loan_money.clear();
		min_loan_money.sendKeys("10000");
		Logger.log("输入年率利");
		rate.sendKeys("15");
		Logger.log("输入投标期限");
		enddate.sendKeys("30");
		Logger.log("点击提交按钮！");
		submitButton.click();
		
	}

}
