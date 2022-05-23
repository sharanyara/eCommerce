package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver ldriver;

	@FindBy(id = "username")
	@CacheLookup
	private WebElement userName;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement passWord;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/form/div/div[3]/div[1]/button")
	@CacheLookup
	private WebElement showPassWord;

	@FindBy(xpath = "//*[@id=\"login-form\"]/div/div[7]/button")
	@CacheLookup
	private WebElement signIn;

	public Login(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void userName(String uname) {
		userName.clear();
		userName.sendKeys(uname);
	}

	public void password(String pass) {
		passWord.sendKeys(pass);
	}

	public void showPassWord() {
		showPassWord.click();
	}

	public void signIn() {
		signIn.click();

	}

}
