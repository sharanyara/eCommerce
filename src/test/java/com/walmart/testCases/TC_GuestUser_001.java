package com.walmart.testCases;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.walmart.pageObject.GuestUser;

public class TC_GuestUser_001 extends BaseClass {

	GuestUser user;

	@BeforeClass
	public void checkGuest() {
		user = new GuestUser(driver);
		if (!(driver.getCurrentUrl().equals("https://www.walmart.ca/en"))) {
			driver.get("https://www.walmart.ca/en");
		}
	}

	@Test(priority = 1)
	public void searchProducts() throws InterruptedException, IOException {

		user.search("macbook pro silver 2021");
		// user.search("31357822");

		Thread.sleep(2000);

		if (driver.getCurrentUrl().contains("https://www.walmart.ca/search")) {
			Assert.assertTrue(true);
			logger.info("Valid Search");
		} else {
			captureScreen(driver, "searchProducts");
			Assert.assertTrue(false);
			logger.info("Not Valid Search");
		}

	}

	@Test(priority = 2, dependsOnMethods = { "searchProducts" })
	public void searchPage() throws InterruptedException, IOException {

		// user.firstPage();

		// user.lastPage();

		// user.previousPage();

		// user.nextPage();

		int pageCount = Integer.parseInt(user.totalPage());
		/*
		 * for(int i=0;i<pageCount-1;i++) { Thread.sleep(5000); user.nextPage(); }
		 */

		logger.info(pageCount);

		if (pageCount > 0) {
			Assert.assertTrue(true);
			logger.info("Page Count available");
		} else {
			captureScreen(driver, "searchPage");
			Assert.assertTrue(false);
			logger.info("Page Count not availble");

		}

	}

	@Test(priority = 3, dependsOnMethods = { "searchProducts" })
	public void duplicates() throws InterruptedException, IOException {

		Set<String> set = new HashSet<String>();

		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\"product-results\"]/div"));

		for (int i = 1; i <= findElements.size(); i++) {
			String attribute = driver.findElement(By.xpath("//*[@id=\"product-results\"]/div[" + i + "]/div/a"))
					.getAttribute("aria-label");

			if (set.add(attribute) == false) {
				Assert.assertTrue(true);
				logger.info("Duplicate items available");
			} else {
				captureScreen(driver, "duplicates");
				Assert.assertTrue(false);
				logger.info("Duplicate items not availble");
			}
		}
	}

	@Test(priority = 4, dependsOnMethods = { "searchProducts" })
	public void sortingTest() throws InterruptedException, IOException {

		user.sortProducts();
		Thread.sleep(3000);
		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"left-navigation\"]/div[5]/div/div/div/div[1]/button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"11\"]"));
		executor.executeScript("arguments[0].click();", element1);
		Thread.sleep(3000);
		driver.findElement(By.linkText("Price: High to Low")).click();
		Thread.sleep(3000);
		List<WebElement> findElements = driver
				.findElements(By.xpath("//*[@id=\"product-results\"]/div/div/a/div/div[2]/div[3]/div/div/span/span"));
		double previous = 0.0;

		for (int i = 0; i <= findElements.size() - 1; i++) {
			String s = findElements.get(i).getText();
			String s2 = s.replaceAll("\\$", "");
			double s1 = Double.parseDouble(s2.replaceAll(",", ""));

			if (previous != 0.0) {
				if (s1 > previous) {
					captureScreen(driver, "sortingTest");
					Assert.assertTrue(false);
					logger.info("Sorting not working");

				} else {
					Assert.assertTrue(true);
					logger.info("Sorting working fine");

				}

			}
			previous = s1;
		}
	}

}
