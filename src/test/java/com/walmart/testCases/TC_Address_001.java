package com.walmart.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.Address;

public class TC_Address_001 extends BaseClass {

	Address myAddress;

	@BeforeMethod
	public void Address() {
		myAddress = new Address(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test(priority = 1)
	public void editAddress() throws InterruptedException, IOException {

		myAddress.addressTab();
		List<WebElement> editButton = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]//*[contains(text(),'Edit')]"));
		editButton.get(0).click();
		myAddress.firstName("Sharanya");
		myAddress.lastName("Rajasekaran");
		myAddress.aptNo("200");
		// myAddress.phoneNumber("2014963922");
		Thread.sleep(3000);
		myAddress.saveButton();
		Thread.sleep(3000);
		
		List<WebElement> message = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]/div//*[@class=\"css-wckgdq enou6w54\"]"));
		List<WebElement> close = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]/div//*[@aria-label=\"Close\"]"));
		String content = message.get(0).getText();

		if (content.contains("updated.")) {
			Assert.assertTrue(true);
			close.get(0).click();
			logger.info("Edit Address passed");
		} else {
			captureScreen(driver, "editAddress");
			Assert.assertTrue(false);
			logger.info("Edit Address failed");
		}

	}

	@Test(priority = 2)
	public void removeAddress() throws InterruptedException {

		myAddress.addressTab();
		//myAddress.removeAddress();
		Thread.sleep(2000);
		List<WebElement> removeButton = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]//*[contains(text(),'Remove')]"));
		removeButton.get(0).click();
		Thread.sleep(2000);

		//myAddress.removeCancelButton();

		myAddress.addressRemove();
		
		List<WebElement> message = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]/div//*[@class=\"css-wckgdq enou6w54\"]"));
		List<WebElement> close = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]/div//*[@aria-label=\"Close\"]"));

		String content = message.get(0).getText();

		if (content.contains("removed successfully.")) {
			Assert.assertTrue(true);
			close.get(0).click();
			logger.info("Edit Address passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Edit Address failed");
		}

	}

	@Test(priority = 3)
	public void addAddress() throws InterruptedException, IOException {
		Thread.sleep(1000);
		myAddress.addressTab();
		myAddress.addAddressButton();
		Thread.sleep(2000);
		myAddress.addFirstName("Sharanya");
		myAddress.addLastName("Rajasekaran");
		myAddress.addAddress1("330 Burnhamthorpe Rd W");
		myAddress.addAddress2("200");
		myAddress.addCity("Mississauga");
		myAddress.addProvince();
		myAddress.addPostal("L5B 0E1");
		myAddress.addPhone("2014963911");
		Thread.sleep(1000);
		myAddress.selectRecom();
		Thread.sleep(1000);
		myAddress.selectSaveButton();
		List<WebElement> close = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]/div//*[@aria-label=\"Close\"]"));
		List<WebElement> message = driver.findElements(By.xpath("//*[@id=\"skip-to-main\"]/div//*[@class=\"css-wckgdq enou6w54\"]"));
		String content = message.get(0).getText();

		if (content.contains("Address has been saved successfully.")) {
			close.get(0).click();
			Assert.assertTrue(true);
			logger.info("Add Address passed");
		} else {
			captureScreen(driver, "addAddress");
			Assert.assertTrue(false);
			logger.info("Add Address failed");
		}

	}

}
