package com.walmart.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Address {

	WebDriver ldriver;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/div/section/div/div[1]/ul/li[9]/div/a ")
	@CacheLookup
	private WebElement addressTab;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div/div/div[3]/button[1]")
	@CacheLookup
	private WebElement editLink;

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	@CacheLookup
	private WebElement firstName;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	@CacheLookup
	private WebElement lastName;

	@FindBy(xpath = "//*[@id=\"address1\"]")
	@CacheLookup
	private WebElement address1;

	@FindBy(xpath = "//*[@id=\"address2\"]")
	@CacheLookup
	private WebElement aptNo;

	@FindBy(xpath = "//*[@id=\"phoneNumber\"]")
	@CacheLookup
	private WebElement phoneNumber;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div/div[2]/main/div/div[1]/div/div/div/form/div[2]/button")
	@CacheLookup
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div/div/div[2]/div/div/section/p")
	@CacheLookup
	private WebElement editMessage;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div/div/div[2]/div/div/section/button")
	@CacheLookup
	private WebElement editMessageClose;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]//*[contains(text(),'Remove')]")
	@CacheLookup
	private WebElement removeAddress;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div[1]/div/div/button[1]")
	@CacheLookup
	private WebElement removeCancelButton;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div[1]/div/div/button[2]")
	@CacheLookup
	private WebElement addressRemove;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div[1]/div/div/section/p")
	@CacheLookup
	private WebElement addressMessageRemove;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div[1]/div/div/section/button")
	@CacheLookup
	private WebElement addressRemovePopup;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/button")
	@CacheLookup
	private WebElement addAddressButton;

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	@CacheLookup
	private WebElement addFirstName;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	@CacheLookup
	private WebElement addLastName;

	@FindBy(xpath = "//*[@id=\"address1\"]")
	@CacheLookup
	private WebElement addAddress1;

	@FindBy(xpath = "//*[@id=\"address2\"]")
	@CacheLookup
	private WebElement addAddress2;

	@FindBy(xpath = "//*[@id=\"phoneNumber\"]")
	@CacheLookup
	private WebElement addPhone;
	
	@FindBy(xpath = "//*[@id=\"city\"]")
	@CacheLookup
	private WebElement addCity;
	
	@FindBy(xpath = "//*[@id=\"province\"]")
	@CacheLookup
	private WebElement addProvince;
	
	@FindBy(xpath = "//*[@id=\"postalCode\"]")
	@CacheLookup
	private WebElement addPostal;
	
	@FindBy(xpath = "//*[@id=\"addressForm\"]/div[2]/button")
	@CacheLookup
	private WebElement selectRecom;
	
	@FindBy(xpath = "//*[@id=\"addressForm\"]/div[2]/div/button")
	@CacheLookup
	private WebElement selectCancel;
	
	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div[1]/div/div[3]/button[2]")
	@CacheLookup
	private WebElement selectSaveButton;
	
	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div[1]/div/div[3]/button[1]")
	@CacheLookup
	private WebElement selectCancelButton;
	
	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div[1]/div/div/section/p")
	@CacheLookup
	private WebElement addMessage;
	
	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div/div[1]/div[1]/div/div/section/button")
	@CacheLookup
	private WebElement addPopup;
	
	public Address(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void addressTab() {
		addressTab.click();
	}

	public void editLink() {
		editLink.click();
	}

	public void firstName(String fName) {
		firstName.clear();
		firstName.sendKeys(fName);
	}

	public void lastName(String lName) {
		lastName.clear();
		lastName.sendKeys(lName);
	}

	public void address1(String add) {
		address1.clear();
		address1.sendKeys(add);
	}

	public void aptNo(String apt) {
		aptNo.clear();
		aptNo.sendKeys(apt);
	}

	public void phoneNumber(String pNumber) {
		phoneNumber.clear();
		phoneNumber.sendKeys(pNumber);
	}

	public void saveButton() {
		saveButton.click();
	}

	public String editMessage() {
		return editMessage.getText();
	}

	public void editMessageClose() {
		editMessageClose.click();
	}

	public void removeAddress() {
		removeAddress.click();
	}

	public void removeCancelButton() {
		removeCancelButton.click();
	}

	public void addressRemove() {
		addressRemove.click();
	}

	public String addressMessageRemove() {
		return addressMessageRemove.getText();
	}

	public void addressRemovePopup() {
		addressRemovePopup.click();
	}

	public void addAddressButton() {
		addAddressButton.click();
	}

	public void addFirstName(String fName) {
		addFirstName.clear();
		addFirstName.sendKeys(fName);
	}

	public void addLastName(String lName) {
		addLastName.clear();
		addLastName.sendKeys(lName);
	}

	public void addAddress1(String add1) {
		addAddress1.clear();
		addAddress1.sendKeys(add1);
	}

	public void addAddress2(String add2) {
		addAddress2.clear();
		addAddress2.sendKeys(add2);
	}

	public void addPhone(String phone) {
		addPhone.clear();
		addPhone.sendKeys(phone);
	}
	
	public void addCity(String city) {
		addCity.clear();
		addCity.sendKeys(city);
	}
	
	public void addProvince() {
		Select province = new Select(addProvince);
		province.selectByVisibleText("Ontario");

	}
	
	public void addPostal(String postal) {
		addPostal.clear();
		addPostal.sendKeys(postal);
	}
	
	public void selectRecom() {
		selectRecom.click();
	}
	
	public void selectCancel() {
		selectCancel.click();
	}
	
	public void selectSaveButton() {
		selectSaveButton.click();
	}
	
	public void selectCancelButton() {
		selectCancelButton.click();
	}
	
	public String addMessage() {
		return addMessage.getText();
	}
	
	public void addPopup() {
		addPopup.click();
	}
	
	

}
