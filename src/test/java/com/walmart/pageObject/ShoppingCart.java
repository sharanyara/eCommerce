package com.walmart.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	WebDriver ldriver;

	
	@FindBy(xpath = "//*[@id=\"search-form-input\"]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"product-results\"]/div/div/div/button")
	private WebElement addCart;
	
	@FindBy(xpath = "//*[@id=\"atc-root\"]/div[3]/div[2]/div[4]/button")
	private WebElement checkOut;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div[3]/div[4]/div[3]/div/div[1]/div[3]/div[2]")
	private WebElement total;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::div[@data-automation=\"subtitle\"]")
	private WebElement totalItemCount;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::div[@class=\"css-rac2gd ennws580\"]")
	private List<WebElement> itemList;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::button[@data-automation=\"decrease-qty\"]")
	private List<WebElement> removeButton;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::button[@data-automation=\"increase-qty\"]")
	private List<WebElement> addButton;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::input[@aria-label=\"Quantity\"]")
	private List<WebElement> count;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::span[@data-automation=\"product-subtotal-price\"]")
	private List<WebElement> subTotal;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::span[@data-automation=\"product-each-price\"]")
	private List<WebElement> eachTotal;
	
	@FindBy(xpath = "//div[@data-automation=\"active-cart\"]//following::button[@data-automation=\"remove-product-from-cart\"]")
	private List<WebElement> removeItem;
	
	@FindBy(xpath = "//div[@data-automation=\"money-box-pre-discount-subtotal\"]")
	private WebElement emptyTotal;
	
	
	
	

	public ShoppingCart(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}


	public void searchBox(String item) {
		searchBox.clear();
		searchBox.sendKeys(item);
		searchBox.submit();
	}
	
	public void addCart() {
		 addCart.click();;
	}
	
	public void checkOut() {
		checkOut.click();;
	}
	
	public double total() {
		String s = total.getText();
		return conString(s);
	}
	
	public String totalItemCount() {
		return totalItemCount.getText();
	}
	
	public int itemList() {
		return itemList.size();
	}
	
	public void removeButton(int i) {
		 removeButton.get(i).click();
	}
	
	public void addButton(int i) {
		 addButton.get(i).click();
	}
	
	public String count(int i) {
		return count.get(i).getAttribute("value");
	}
	
	public double subTotal(int i) {
		String s = subTotal.get(i).getText();
		return conString(s);
	}
	
	public double eachTotal(int i) {
		String s = eachTotal.get(i).getText();
		return conString(s);
	}
	
	public void removeItem(int i) {
		removeItem.get(i).click();
	}
	
	public double emptyTotal() {
		String s = emptyTotal.getText();
		return conString(s);
	}
	
	public double conString(String strValue) {
		String s = strValue.replaceAll("\\$", "").replaceAll(",", "").replaceAll("Subtotal:", "").trim();
		return Double.parseDouble(s);
		
	}
	

	

}
