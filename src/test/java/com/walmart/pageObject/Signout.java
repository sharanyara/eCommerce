package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signout {

	WebDriver ldriver;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/div/section/div/div[1]/ul/li[11]/div/a")
	@CacheLookup
	private WebElement signoutLink;


	public Signout(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void signoutLink() {
		signoutLink.click();
	}

}
