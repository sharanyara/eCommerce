package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.OrderHistory;

public class TC_OrderHistory_001 extends BaseClass {

	OrderHistory order;

	@BeforeMethod
	public void checkLink() {
		order = new OrderHistory(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test()
	public void clickOrderLink() throws InterruptedException, IOException {
		Thread.sleep(1000);

		order.ordersLink();
		Thread.sleep(1000);
		String content = order.orderPage();
		if (content.contains("Sorry!")) {
			captureScreen(driver, "clickOrderLink");
			Assert.assertTrue(false);
			logger.info("Order Content Not Available");
		} else {
			Assert.assertTrue(true);
			logger.info("Order Content Available");
		}

	}

}
