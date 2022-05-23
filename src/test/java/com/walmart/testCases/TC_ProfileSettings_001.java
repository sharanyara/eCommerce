package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.walmart.pageObject.ProfileSettings;

public class TC_ProfileSettings_001 extends BaseClass {

	ProfileSettings profile;

	@BeforeClass
	public void testProfileSettings() {

		profile = new ProfileSettings(driver);

		if (!(driver.getCurrentUrl().equals(readconfig.getAccountURL()))) {
			driver.get(readconfig.getAccountURL());
		}

	}

	@Test(priority = 1)
	public void checkProfileLink() throws InterruptedException, IOException {

		profile.profileLink();

		if (driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL())) {
			Assert.assertTrue(true);
			logger.info("Profile Click passed");
		} else {
			captureScreen(driver, "checkProfileLink");
			Assert.assertTrue(false);
			logger.info("Profile Click failed");
		}

	}

	@Test(priority = 2, dependsOnMethods = { "checkProfileLink" })
	public void CheckPersonalInfo() throws InterruptedException, IOException {

		profile.feditButton();
		profile.firstName("Sharanya");
		profile.lastName("Rajasekaran");

		if (profile.isnameEnabled()) {
			profile.nameSave();
			Thread.sleep(2000);
			String content = profile.getMessage();
			if (content.equalsIgnoreCase("Full name has been successfully updated.")) {
				Assert.assertTrue(true);
				logger.info("Personal Info Saved Successfully");
			} else {
				captureScreen(driver, "CheckPersonalInfo");
				Assert.assertTrue(false);
				logger.info("Personal Info Not Saved Successfully");
			}
		} else {
			profile.nameCancel();

		}

	}

	@Test(priority = 3, dependsOnMethods = { "checkProfileLink" })
	public void CheckPostalInfo() throws InterruptedException, IOException {

		profile.editZip();
		profile.postalCode("L5B 0E2");

		if (profile.isZipEnabled()) {
			profile.zipSave();
			Thread.sleep(2000);
			String content = profile.getZipMessage();
			if (content.equalsIgnoreCase("Postal code has been successfully updated.")) {
				Assert.assertTrue(true);
				logger.info("Postal Info Saved Successfully");
			} else {
				captureScreen(driver, "CheckPostalInfo");
				Assert.assertTrue(false);
				logger.info("Postal Info Not Saved Successfully");
			}
		} else {
			profile.zipCancel();

		}

	}

	@Test(priority = 4, dependsOnMethods = { "checkProfileLink" })
	public void updateEmailInfo() throws InterruptedException, IOException {

		profile.emailIdEdit();
		profile.emailId("Sharanya.Rajasekarann@gmail.com");
		profile.password("Tenderfoot@2022");
		profile.passShowButton();

		if (profile.isEmailEnabled()) {
			profile.accountSecuritySaveButton();
			Thread.sleep(2000);
			String content = profile.getEmailMessage();
			if (content.equalsIgnoreCase(
					"Sorry! The email address you entered is already in use. Please try using another email address.")) {
				profile.accountSecuritycancelButton();
				profile.popupButton();
				Assert.assertTrue(true);
				logger.info("Email Info working good");
			} else {
				captureScreen(driver, "updateEmailInfo");
				Assert.assertTrue(false);
				logger.info("Email Info Not working.");
			}
		} else {
			profile.accountSecuritycancelButton();

		}

	}

	@Test(priority = 5, dependsOnMethods = { "checkProfileLink" })
	public void updatePasswordInfo() throws InterruptedException, IOException {

		profile.passwordEdit();
		profile.currentPassword("Sharanya.Rajasekarann@gmail.com");
		profile.showPassword();
		profile.newPassword("Tenderfoot@2022");
		profile.showNewPassword();

		if (profile.isPasswordEnabled()) {
			profile.updatePassword();
			Thread.sleep(2000);
			String content = profile.passwordMessage();
			if (content
					.equalsIgnoreCase("We're sorry! that's not your current password. Please check and try again.")) {
				profile.cancelPassword();
				profile.closePasswordPopup();
				Assert.assertTrue(true);
				logger.info("Password Info working good");
			} else {
				captureScreen(driver, "updatePasswordInfo");
				Assert.assertTrue(false);
				logger.info("Password Info Not working.");
			}
		} else {
			profile.cancelPassword();

		}

	}

	@Test(priority = 6, dependsOnMethods = { "checkProfileLink" })
	public void updatePhoneInfo() throws InterruptedException {

		profile.EditPhone();
		profile.newPhone("123-456-7890");
		Thread.sleep(2000);
		profile.cancelPhone();
		Assert.assertTrue(true);

	}

	@Test(priority = 7, dependsOnMethods = { "checkProfileLink" })
	public void updateLanguageInfo() throws InterruptedException, IOException {

		profile.EditLang();
		if (profile.isLanguageEnglish()) {
			profile.languageFrench();
		} else {
			profile.languageEnglish();
		}

		if (profile.isLanguageSave()) {
			profile.languageSave();
			Thread.sleep(2000);
			String content = profile.languageMessage();
			if (content.equalsIgnoreCase("Language preference has been successfully updated.")) {
				profile.langPopup();
				Assert.assertTrue(true);
				logger.info("Language Preference Info works good");
			} else {
				captureScreen(driver, "updateLanguageInfo");
				Assert.assertTrue(false);
				logger.info("Language preference Info is Not working.");
			}
		} else {
			profile.languageCancel();

		}

	}

	@Test(priority = 8, dependsOnMethods = { "checkProfileLink" })
	public void updateDiscountInfo() throws InterruptedException, IOException {

		profile.discountEdit();
		profile.WIN("111111111");
		profile.discountNumber("1111111111111111");
		profile.termsCheckBox();

		if (profile.isDiscountSave()) {
			profile.discountSave();
			Thread.sleep(2000);
			String content = profile.discuountMessage();
			if (content.equalsIgnoreCase(
					"We're sorry! Invalid discount card number / Walmart identification number. Please check and try again later.")) {
				profile.discuountCancel();
				profile.discountPopUp();
				Assert.assertTrue(true);
				logger.info("Discount Info working good");
			} else {
				captureScreen(driver, "updateDiscountInfo");
				Assert.assertTrue(false);
				logger.info("Discount Info Not working.");
			}
		} else {
			profile.discuountCancel();

		}

	}

}
