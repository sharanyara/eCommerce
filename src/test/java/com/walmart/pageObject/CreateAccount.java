package com.walmart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver ldriver;

	@FindBy(id = "firstName")
	@CacheLookup
	public WebElement firstName;

	@FindBy(id = "lastName")
	@CacheLookup
	private WebElement lastName;

	@FindBy(id = "phoneNumber")
	@CacheLookup
	private WebElement phoneNumber;

	@FindBy(how = How.ID, using = "email")
	@CacheLookup
	private WebElement email;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement PassWord;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div[1]/div/form/div/div[6]/div[1]/button")
	@CacheLookup
	private WebElement showPassWord;

	@FindBy(xpath = "/html/body/div/div/div[1]/div/form/div/div[8]/div[1]/div/label")
	@CacheLookup
	private WebElement termsOfUse;

	@FindBy(xpath = "//button[@class=\"css-vfxkzw edzik9p0\"]")
	@CacheLookup
	private WebElement createAccountButton;

	public CreateAccount(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void firstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void lastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void phoneNumber(String phoneNumber) {
		this.phoneNumber.sendKeys(phoneNumber);

	}

	public void email(String email) {
		this.email.sendKeys(email);
	}

	public void passWord(String cpassWord) {
		PassWord.sendKeys(cpassWord);
	}

	public void showPassWord() {
		showPassWord.click();
	}

	public void termsOfUse() {
		termsOfUse.click();
	}

	public void createAccountButton() {
		JavascriptExecutor executor = (JavascriptExecutor) ldriver;
		executor.executeScript("arguments[0].click();",
				ldriver.findElement(By.xpath("//button[@class=\"css-vfxkzw edzik9p0\"]")));
	}
}
