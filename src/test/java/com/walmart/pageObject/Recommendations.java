package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recommendations {

	WebDriver ldriver;

	@FindBy(xpath = "//a[normalize-space()='My recommendations']")
	@CacheLookup
	private WebElement recommendationsLink;

	@FindBy(xpath = "//h1[@data-analytics-type='pageTitle']")
	@CacheLookup
	private WebElement recommendationContent;

	public Recommendations(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public boolean isrecommendationsLink() {
		boolean link = recommendationsLink.isDisplayed();
		return link;
	}

	public void recommendationsLink() {
		recommendationsLink.click();
	}

	public boolean recommendationContent() {
		boolean content = recommendationContent.getText().contains("Recommendations for");
		return content;
	}

}
