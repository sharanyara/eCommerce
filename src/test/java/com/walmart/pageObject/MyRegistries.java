package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyRegistries {
	WebDriver ldriver;

	@FindBy(linkText = "My registries")
	@CacheLookup
	private WebElement registriesLink;

	@FindBy(xpath = "//*[@id=\"poblano-template\"]/div[2]/div[2]/div[3]/div[1]/p")
	@CacheLookup
	private WebElement registriesContent;

	public MyRegistries(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void registriesLink() {

		registriesLink.click();
	}

	public String registriesContent() {

		return registriesContent.getText();
	}

}
