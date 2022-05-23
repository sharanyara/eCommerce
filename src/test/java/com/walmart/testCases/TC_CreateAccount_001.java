package com.walmart.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.walmart.pageObject.CreateAccount;

import junit.framework.Assert;

public class TC_CreateAccount_001 extends BaseClass {

	@Test
	public void CreateAccount() throws IOException {

		driver.get(readconfig.getRegistrationURL());

		CreateAccount reg = new CreateAccount(driver);

		reg.firstName(readconfig.getRegistrationFirstName());
		logger.info("Registration FirstName is: " + readconfig.getRegistrationFirstName());

		reg.lastName(readconfig.getRegistrationLastName());
		logger.info(readconfig.getRegistrationLastName());

		reg.phoneNumber(readconfig.getRegistrationPhoneNumber());
		logger.info(readconfig.getRegistrationPhoneNumber());

		reg.email(readconfig.getRegistrationEmail());
		logger.info(readconfig.getRegistrationEmail());

		reg.passWord(readconfig.getRegistrationPassword());
		logger.info(readconfig.getRegistrationPassword());

		reg.showPassWord();

		reg.termsOfUse();

		reg.createAccountButton();

		if (driver.getCurrentUrl().equals(readconfig.getAccountURL())) {
			Assert.assertTrue(true);
			logger.info("Registration test passed");

		} else {
			captureScreen(driver, "CreateAccount");
			Assert.assertTrue(false);
			logger.info("Registration test failed");
		}
	}

}
