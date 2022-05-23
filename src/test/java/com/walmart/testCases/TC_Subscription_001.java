package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.Subscription;

public class TC_Subscription_001 extends BaseClass {

	Subscription subscription;

	@BeforeMethod
	public void checkLink() {
		subscription = new Subscription(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test()
	public void clickSubscriptionLink() throws InterruptedException, IOException {

		Thread.sleep(1000);
		subscription.subLink();
		Thread.sleep(1000);
		String content = subscription.subPage();
		if (content.contains("You've no subscriptions yet!")) {
			Assert.assertTrue(true);
			logger.info("Subscription Content Available");
		} else {
			captureScreen(driver, "clickSubscriptionLink");
			Assert.assertTrue(false);
			logger.info("Subscription Content Not Available");
		}

	}

}
