package com.walmart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.Communication;

public class TC_Communication_001 extends BaseClass {

	Communication comm;

	@BeforeMethod
	public void checkLink() {
		comm = new Communication(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test(priority = 1)
	public void checkTextLink() throws InterruptedException {

		comm.communicationTab();
		comm.textLink();
		comm.updateText();
		Thread.sleep(1000);
		comm.closeUpdateText();
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void checkEmailLink() throws InterruptedException {
		comm.communicationTab();
		Thread.sleep(1000);
		comm.emailLink();
		Thread.sleep(1000);
		comm.emailText();
		Assert.assertTrue(true);
	}

}
