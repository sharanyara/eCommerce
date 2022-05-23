package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.MyRegistries;

public class TC_MyRegistries_001 extends BaseClass {
	MyRegistries myRegistries;

	@BeforeMethod

	public void checkLink() {
		myRegistries = new MyRegistries(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test()
	public void MyRegistries() throws InterruptedException, IOException {
		Thread.sleep(3000);
		myRegistries.registriesLink();
		Thread.sleep(1000);
		String registriesContent = myRegistries.registriesContent();

		if (registriesContent.contains("October 27, 2020")) {
			Assert.assertTrue(true);
			logger.info("MyRegistries Content Available");
		} else {
			captureScreen(driver, "MyRegistries");
			Assert.assertTrue(false);
			logger.info("MyRegistries Content Not Available");
		}

	}
}
