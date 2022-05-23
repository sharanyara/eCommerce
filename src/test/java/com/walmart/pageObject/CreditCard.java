package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreditCard {
	
	WebDriver ldriver;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/div/section/div/div[1]/ul/li[10]/div/a")
	@CacheLookup
	private WebElement cardLink;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div/section/div[1]/button")
	@CacheLookup
	private WebElement addCard;
	
	@FindBy(xpath = "//*[@id=\"firstName\"]")
	@CacheLookup
	private WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"lastName\"]")
	@CacheLookup
	private WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"cardNumber\"]")
	@CacheLookup
	private WebElement cardNumber;
	
	@FindBy(xpath = "//*[@id=\"securityCode\"]")
	@CacheLookup
	private WebElement securityCode;
	
	@FindBy(xpath = "//*[@id=\"expiryMonth\"]")
	@CacheLookup
	private WebElement expiryMonth;
	
	@FindBy(xpath = "//*[@id=\"expiryYear\"]")
	@CacheLookup
	private WebElement expiryYear;
	
	@FindBy(xpath = "//*[@id=\"addCardForm\"]/section/div[6]/button[1]")
	@CacheLookup
	private WebElement saveCard;
	
	@FindBy(xpath = "//*[@id=\"addCardForm\"]/section/div[6]/button[2]")
	@CacheLookup
	private WebElement cancelCard;
	
	@FindBy(xpath = "//*[@id=\"addCardForm\"]/section/div[1]/div[3]/span[2]/span")
	@CacheLookup
	private WebElement cardMessage;

	public CreditCard(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void cardLink() {
		cardLink.click();
	}
	
	public void addCard() {
		addCard.click();
	}
	
	public void firstName(String fName) {
		firstName.clear();
		firstName.sendKeys(fName);
	}
	
	public void lastName(String lName) {
		lastName.clear();
		lastName.sendKeys(lName);
	}
	
	public void cardNumber(String cNumber) {
		cardNumber.clear();
		cardNumber.sendKeys(cNumber);
	}
	
	public void securityCode(String sCode) {
		securityCode.clear();
		securityCode.sendKeys(sCode);
	}
	
	public void expiryMonth() {
		Select month = new Select(expiryMonth);
		month.selectByVisibleText("05");
	}
	
	public void expiryYear() {
		Select year = new Select(expiryYear);
		year.selectByVisibleText("2022");
	}
	
	public void saveCard() {
		saveCard.click();
	}
	
	public void cancelCard() {
		cancelCard.click();
	}
	
	public String cardMessage() {
		return cardMessage.getText();
	}
	
}
