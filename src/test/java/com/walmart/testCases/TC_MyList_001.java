package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.MyList;

public class TC_MyList_001 extends BaseClass {

	MyList myList;

	@BeforeMethod
	public void checkLink() {
		myList = new MyList(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test()
	public void clickMyListLink() throws InterruptedException, IOException {

		Thread.sleep(1000);
		myList.myListLink();
		Thread.sleep(1000);
		myList.searchBox("Laptop");
		Thread.sleep(1000);
		myList.searchButton();

		String content = myList.searchList();
		if (content.contains("Add to list")) {
			Assert.assertTrue(true);
			logger.info("MyList Content Available");
		} else {
			captureScreen(driver, "clickMyListLink");
			Assert.assertTrue(false);
			logger.info("MyList Content Not Available");
		}

	}

}
