package com.walmart.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileSettings {

	WebDriver ldriver;

	@FindBy(xpath = "//a[normalize-space()='Profile Settings']")
	@CacheLookup
	private WebElement profileLink;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[1]/div[1]/button")
	@CacheLookup
	private WebElement feditButton;

	@FindBy(id = "firstName")
	@CacheLookup
	private WebElement firstName;

	@FindBy(id = "lastName")
	@CacheLookup
	private WebElement lastName;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[3]/button[1]")
	@CacheLookup
	private WebElement saveButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[3]/button[1]")
	@CacheLookup
	private WebElement saveEnabled;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[2]/div/div/section/p")
	@CacheLookup
	private WebElement saveMessage;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[3]/button[2]")
	@CacheLookup
	private WebElement cancelButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[3]/div[1]/button")
	@CacheLookup
	private WebElement peditButton;

	@FindBy(id = "postalCode")
	@CacheLookup
	private WebElement postalCode;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[4]/button[1]")
	@CacheLookup
	private WebElement postalSave;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[4]/button[1]")
	@CacheLookup
	private WebElement postalEnabled;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[4]/div/div/section/p")
	@CacheLookup
	private WebElement saveZipMessage;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[4]/button[2]")
	@CacheLookup
	private WebElement postalCancel;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[1]/div[1]/button")
	@CacheLookup
	private WebElement emailIdEdit;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[1]/input")
	// @CacheLookup
	private WebElement emailId;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[2]/div/input")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[2]/div/button")
	@CacheLookup
	private WebElement passShowButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[3]/button[1]")
	@CacheLookup
	private WebElement emailEnabled;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[4]/div/div/section/p")
	@CacheLookup
	private WebElement saveEmailMessage;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[2]/div/div/section/button")
	@CacheLookup
	private WebElement closePopUp;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[3]/button[1]")
	@CacheLookup
	private WebElement accountSecuritySaveButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[3]/button[2]")
	@CacheLookup
	private WebElement accountSecuritycancelButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[3]/div[1]/button")
	@CacheLookup
	private WebElement passwordEdit;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[3]/div/input")
	@CacheLookup
	private WebElement currentPassword;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[3]/div/button")
	@CacheLookup
	private WebElement showPassword;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[4]/div/input")
	@CacheLookup
	private WebElement newPassword;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[4]/div/button")
	@CacheLookup
	private WebElement showNewPassword;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[5]/button[1]")
	@CacheLookup
	private WebElement updatePassword;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[5]/button[1]")
	@CacheLookup
	private WebElement passwordEnabled;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[5]/button[2]")
	@CacheLookup
	private WebElement cancelPassword;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[6]/div/div/section/p")
	@CacheLookup
	private WebElement passwordMessage;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[4]/div/div/section/button")
	@CacheLookup
	private WebElement closePasswordPopup;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[5]/div[1]/button")
	@CacheLookup
	private WebElement phoneEdit;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[2]/div/div/div[5]/input")
	@CacheLookup
	private WebElement updatePhone;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[2]/div/div/div[5]/div[2]/button[2]")
	@CacheLookup
	private WebElement cancelPhone;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[3]/div/div[1]/div[1]/button")
	@CacheLookup
	private WebElement languageEdit;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[3]/div/div[2]/div[1]/input")
	@CacheLookup
	private WebElement languageEnglish;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[3]/div/div[2]/div[2]/input")
	@CacheLookup
	private WebElement languageFrench;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[3]/div/div[4]/button[1]")
	@CacheLookup
	private WebElement saveLangButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[3]/div/div[4]/button[2]")
	@CacheLookup
	private WebElement cancelLangButton;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[3]/div/div[2]/div/div/section/p")
	@CacheLookup
	private WebElement langMessage;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[3]/div/div[2]/div/div/section/button")
	@CacheLookup
	private WebElement langPopup;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[4]/div/div/div[1]/button")
	@CacheLookup
	private WebElement discountEdit;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[4]/div/div[1]/input")
	@CacheLookup
	private WebElement WIN;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[4]/div/div[2]/input")
	@CacheLookup
	private WebElement discountNumber;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[4]/div/div[3]/div/input")
	@CacheLookup
	private WebElement termsCheckBox;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[4]/div/div[4]/button[1]")
	@CacheLookup
	private WebElement discountSave;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[4]/div/div[4]/button[2]")
	@CacheLookup
	private WebElement discountCancel;

	@FindBy(xpath = "//*[@id=\"skip-to-main\"]/div[1]/div[4]/div/div[5]/div/div/section/p")
	@CacheLookup
	private WebElement discountMessage;

	@FindBy(xpath = "/html/body/div[1]/div/div[3]/div[1]/div[2]/main/div[1]/div[4]/div/div[2]/div/div/section/button")
	@CacheLookup
	private WebElement discountPopup;

	public ProfileSettings(WebDriver ldriver) {
		this.ldriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void profileLink() {
		profileLink.click();
	}

	public void feditButton() {
		feditButton.click();
	}

	public void firstName(String fname) {
		firstName.clear();
		firstName.sendKeys(fname);
	}

	public void lastName(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	}

	public void nameSave() {
		saveButton.click();
	}

	public boolean isnameEnabled() {
		return saveEnabled.isEnabled();
	}

	public String getMessage() {
		return saveMessage.getText();
	}

	public void nameCancel() {
		cancelButton.click();
	}

	public void editZip() {
		peditButton.click();
	}

	public void postalCode(String pcode) {
		postalCode.clear();
		postalCode.sendKeys(pcode);
	}

	public void zipSave() {
		postalSave.click();
	}

	public boolean isZipEnabled() {
		return postalEnabled.isEnabled();
	}

	public String getZipMessage() {
		return saveZipMessage.getText();
	}

	public void zipCancel() {
		postalCancel.click();
	}

	public void emailIdEdit() {
		emailIdEdit.click();
	}

	public void emailId(String eemailId) {
		emailId.clear();
		emailId.sendKeys(eemailId);
	}

	public void password(String ppassword) {
		password.clear();
		password.sendKeys(ppassword);
	}

	public void passShowButton() {
		passShowButton.click();
	}

	public boolean isEmailEnabled() {
		return emailEnabled.isEnabled();
	}

	public String getEmailMessage() {
		return saveEmailMessage.getText();
	}

	public void accountSecuritySaveButton() {
		accountSecuritySaveButton.click();
	}

	public void accountSecuritycancelButton() {
		accountSecuritycancelButton.click();
	}

	public void popupButton() {
		closePopUp.click();
	}

	public void passwordEdit() {
		passwordEdit.click();
	}

	public void currentPassword(String cPassword) {
		currentPassword.clear();
		currentPassword.sendKeys(cPassword);
	}

	public void showPassword() {
		showPassword.click();
	}

	public void newPassword(String nPassword) {
		newPassword.clear();
		newPassword.sendKeys(nPassword);
	}

	public void showNewPassword() {
		showNewPassword.click();
	}

	public String passwordMessage() {
		return passwordMessage.getText();
	}

	public void updatePassword() {
		updatePassword.click();
	}

	public boolean isPasswordEnabled() {
		return passwordEnabled.isEnabled();
	}

	public void cancelPassword() {
		cancelPassword.click();
	}

	public void closePasswordPopup() {
		closePasswordPopup.click();
	}

	public void EditPhone() {
		phoneEdit.click();
	}

	public void newPhone(String nPhone) {
		updatePhone.clear();
		updatePhone.sendKeys(nPhone);
	}

	public void cancelPhone() {
		cancelPhone.click();
	}

	public void EditLang() {
		languageEdit.click();
	}

	public void languageEnglish() {
		languageEnglish.click();
	}

	public boolean isLanguageEnglish() {
		return languageEnglish.isSelected();
	}

	public void languageFrench() {
		languageFrench.click();
	}

	public boolean isLanguageFrench() {
		return languageFrench.isSelected();
	}

	public void languageSave() {
		saveLangButton.click();
	}

	public boolean isLanguageSave() {
		return languageEnglish.isEnabled();
	}

	public void languageCancel() {
		cancelLangButton.click();
	}

	public String languageMessage() {
		return langMessage.getText();
	}

	public void langPopup() {
		langPopup.click();
	}

	public void discountEdit() {
		discountEdit.click();
	}

	public void WIN(String winNumber) {
		WIN.clear();
		WIN.sendKeys(winNumber);
	}

	public void discountNumber(String dNumber) {
		discountNumber.clear();
		discountNumber.sendKeys(dNumber);
	}
	
	public boolean isTermsCheckBox() {
		return termsCheckBox.isSelected();
	}

	public void termsCheckBox() {
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click()", termsCheckBox);
		//termsCheckBox.click();
	}

	public void discountSave() {
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click()", discountSave);
		//discountSave.click();
	}
	
	public boolean isDiscountSave() {
		return discountSave.isEnabled();
	}

	public void discuountCancel() {
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("arguments[0].click()", discountCancel);
		//discountCancel.click();
	}

	public String discuountMessage() {
		return discountMessage.getText();
	}

	public void discountPopUp() {
		discountPopup.click();
	}

}
