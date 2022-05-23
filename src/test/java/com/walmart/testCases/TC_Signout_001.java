package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.Signout;

public class TC_Signout_001 extends BaseClass{
	
	Signout signout;

	@BeforeMethod
	public void checkLink() {
		signout = new Signout(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	
	@Test()
	public void clickSignoutLink() throws InterruptedException, IOException {
		Thread.sleep(1000);
		signout.signoutLink();
		Thread.sleep(1000);
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.walmart.ca/en")) {
			Assert.assertTrue(true);
			logger.info("Signout Working");
		} else {
			captureScreen(driver, "clickSignoutLink");
			Assert.assertTrue(false);
			logger.info("Signout Not Working");
		}

	}

}
