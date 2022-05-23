package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestUser {

	WebDriver ldriver;

	@FindBy(xpath = "//*[@id=\"search-form-input\"]")
	@CacheLookup
	private WebElement search;

	@FindBy(xpath = "//*[@id=\"browse-search-page\"]/div/div/div/div/div[8]/div[2]/div[2]/div[2]/section/a[1]")
	@CacheLookup
	private WebElement firstPage;

	@FindBy(xpath = "//*[@id=\"browse-search-page\"]/div/div/div/div/div[8]/div[2]/div[2]/div[2]/section/a[7]")
	@CacheLookup
	private WebElement lastPage;

	@FindBy(xpath = "//*[@id=\"browse-search-page\"]/div/div/div/div/div[8]/div[2]/div[2]/div[2]/div[1]/a")
	@CacheLookup
	private WebElement previousPage;

	@FindBy(xpath = "//*[@id=\"browse-search-page\"]/div/div/div/div/div[8]/div[2]/div[2]/div[2]/div[2]/a")
	@CacheLookup
	private WebElement nextPage;
	
	
	@FindBy(xpath = "//*[@id=\"browse-search-page\"]/div/div/div/div/div[8]/div[2]/div[2]/div[2]/section/a[7]/span")
	@CacheLookup
	private WebElement totalPage;
	
	@FindBy(xpath = "//*[@id=\"browse-search-page\"]/div/div/div/div/div[8]/div[1]/div/div[2]/div[2]/button")
	@CacheLookup
	private WebElement sortProducts;
	
	
	
	
	

	public GuestUser(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void search(String searchProducts) {
		search.clear();
		search.sendKeys(searchProducts);
		search.submit();
	}
		
	public void firstPage(){
		firstPage.click();	
		}
	
	public void lastPage(){
		lastPage.click();	
		}
	
	public void previousPage(){
		previousPage.click();	
		}
	
	public void nextPage(){
		nextPage.click();	
		}
	
	public String totalPage() {
		return totalPage.getText();
	}
	
	public void sortProducts() {
		sortProducts.click();
	}

}
