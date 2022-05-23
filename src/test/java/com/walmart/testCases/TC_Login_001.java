package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.walmart.pageObject.Login;

public class TC_Login_001 extends BaseClass {

	@Test
	public void login() throws InterruptedException, IOException {

		Login login = new Login(driver);

		driver.get(readconfig.getApplicationURL());

		login.userName(readconfig.getUsername());

		login.password(readconfig.getPassword());

		login.showPassWord();

		login.signIn();

		Thread.sleep(2000);

		String actual = driver.getTitle();
		String expected = "Shop Walmart.ca: Online Shopping & Everyday Low Prices";

		if (actual.equals(expected)) {
			Assert.assertTrue(true);
			logger.info("Login passed");
		} else {
			captureScreen(driver, "login");
			Assert.assertTrue(false);
			logger.info("Login failed");
		}

	}

}
