package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.MyAccount;

public class TC_MyAccount_001 extends BaseClass {

	MyAccount account;

	@BeforeMethod
	public void checkAccounts() {
		account = new MyAccount(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getAccountURL()))) {
			driver.get("https://www.walmart.ca/my-account");
		}
	}

	@Test(priority = 1)
	public void checkeVouchers() throws InterruptedException, IOException {

		account.voucherCode("MARCH12345");
		account.eVoucherButton();
		Thread.sleep(1000);
		String message = account.message();

		if (message.contains("Sorry!")) {
			Assert.assertTrue(true);
			logger.info("Coupon not Valid");
		} else {
			captureScreen(driver, "checkeVouchers");
			Assert.assertTrue(false);
			logger.info("Valid Coupon");
		}

	}

}
