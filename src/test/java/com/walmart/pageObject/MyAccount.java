package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	WebDriver ldriver;

	@FindBy(id = "redeemEvoucherInput")
	@CacheLookup
	private WebElement eVouchers;

	@FindBy(xpath = "//button[text() = 'Redeem code']")
	@CacheLookup
	private WebElement eVoucherButton;

	@FindBy(xpath = "//*[@id=\"accounts-home-page\"]/div[3]/div[2]/div[3]/div[5]/div[2]/div[2]/div/div[2]")
	@CacheLookup
	private WebElement isMessage;

	public MyAccount(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void voucherCode(String vCode) {
		eVouchers.clear();
		eVouchers.sendKeys(vCode);
	}

	public void eVoucherButton() {
		eVoucherButton.click();
	}

	public String message() {
		return isMessage.getText();
	}

}
