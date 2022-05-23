package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.CreditCard;

public class TC_CreditCard_001 extends BaseClass {

	CreditCard card;

	@BeforeMethod
	public void checkLink() {
		card = new CreditCard(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test(priority = 1)
	public void addCardDetails() throws InterruptedException, IOException {

		card.cardLink();
		card.addCard();
		card.firstName("Sharanya");
		card.lastName("Rajasekaran");
		card.cardNumber("1111111111111111");
		card.securityCode("111");
		card.expiryMonth();
		card.expiryYear();
		card.saveCard();
		Thread.sleep(2000);

		String content = card.cardMessage();

		if (content.contains("Sorry")) {
			Assert.assertTrue(true);
			logger.info("Add Card working");
		} else {
			captureScreen(driver, "addCardDetails");
			Assert.assertTrue(false);
			logger.info("Add Card not working");
		}

	}

}
