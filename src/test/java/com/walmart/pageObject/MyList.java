package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyList {

	WebDriver ldriver;

	@FindBy(xpath = "//a[normalize-space()='My lists']")
	@CacheLookup
	private WebElement myListLink;

	@FindBy(xpath = "//*[@id=\"jalapeno-template\"]/div[3]/div/form/input")
	@CacheLookup
	private WebElement searchBox;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	@CacheLookup
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='search-results empty']")
	@CacheLookup
	private WebElement searchList;

	public MyList(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void myListLink() {
		myListLink.click();
	}

	public void searchBox(String searchText) {
		searchBox.sendKeys(searchText);
	}

	public void searchButton() {
		searchButton.click();
	}
	
	public String searchList() {
		return searchList.getText();
	}

}
