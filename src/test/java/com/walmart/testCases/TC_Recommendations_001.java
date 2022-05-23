package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.pageObject.Recommendations;

public class TC_Recommendations_001 extends BaseClass {

	Recommendations recom;

	@BeforeMethod
	public void checkLink() {
		recom = new Recommendations(driver);
		if (!(driver.getCurrentUrl().equals(readconfig.getPersonalSettingsURL()))) {
			driver.get("https://www.walmart.ca/my-account/personal-settings");
		}
	}

	@Test(priority = 1)
	public void checkRecommendationsLink() throws InterruptedException, IOException {

		boolean recLink = recom.isrecommendationsLink();

		if (recLink == true) {
			Assert.assertTrue(true);
			logger.info("Recommendation Link Available");
		} else {
			captureScreen(driver, "checkRecommendationsLink");
			Assert.assertTrue(false);
			logger.info("Recommendation Link Not Available");
		}

	}

	@Test(priority = 2, dependsOnMethods = { "checkRecommendationsLink" })
	public void clickRecommendationLink() throws InterruptedException, IOException {
		recom.recommendationsLink();
		Thread.sleep(1000);
		boolean content = recom.recommendationContent();

		if (content == true) {
			Assert.assertTrue(true);
			logger.info("Recommendation Content Available");
		} else {
			captureScreen(driver, "clickRecommendationLink");
			Assert.assertTrue(false);
			logger.info("Recommendation Content Not Available");
		}

	}

}
