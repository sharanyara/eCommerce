package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Communication {

	WebDriver ldriver;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/div/section/div/div[1]/ul/li[8]/div/a")
	@CacheLookup
	private WebElement communicationTab;

	@FindBy(xpath = "//*[@id=\"TEXT\"]")
	@CacheLookup
	private WebElement textLink;

	@FindBy(xpath = "//*[@id=\"EMAIL\"]")
	@CacheLookup
	private WebElement emailLink;

	@FindBy(xpath = "//*[@id=\"TEXT-panel\"]/div/div/div[1]/div[2]/a")
	@CacheLookup
	private WebElement updateText;

	@FindBy(xpath = "//*[@id=\"EMAIL-panel\"]/div/div[1]/div[2]/a")
	@CacheLookup
	private WebElement emailText;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div[2]/div/button")
	@CacheLookup
	private WebElement closeUpdateText;

	public Communication(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void communicationTab() {
		communicationTab.click();
	}

	public void textLink() {
		textLink.click();
	}

	public void emailLink() {
		emailLink.click();
	}

	public void updateText() {
		updateText.click();
	}

	public void emailText() {
		emailText.click();

	}

	public void closeUpdateText() {
		closeUpdateText.click();
	}

}
