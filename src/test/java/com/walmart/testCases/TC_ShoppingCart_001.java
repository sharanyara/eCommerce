package com.walmart.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.walmart.pageObject.ShoppingCart;

public class TC_ShoppingCart_001 extends BaseClass {

	ShoppingCart cart;
	double subTotal;

	@BeforeClass
	public void checkCart() {
		cart = new ShoppingCart(driver);
		if (!(driver.getCurrentUrl().equals("https://www.walmart.ca/en"))) {
			driver.get("https://www.walmart.ca/en");
			// driver.get("https://www.walmart.ca/cart");
		}
	}

	@Test(priority = 1)
	public void addProducts() throws InterruptedException, IOException {

		// driver.get("https://www.walmart.ca/en");

		String initialCartCount = driver.findElement(By.xpath("//a[@data-automation=\"cart-icon-wrapper\"]"))
				.getAttribute("aria-label");

		cart.searchBox("30141499");
		Thread.sleep(2000);

		cart.addCart();
		Thread.sleep(2000);

		cart.checkOut();
		Thread.sleep(2000);

		String finalCartCount = driver.findElement(By.xpath("//a[@data-automation=\"cart-icon-wrapper\"]"))
				.getAttribute("aria-label");

		if (initialCartCount != finalCartCount) {
			Assert.assertTrue(true);
			logger.info("New Item added");
		} else {
			captureScreen(driver, "addProducts");
			Assert.assertTrue(false);
			logger.info("New item not added");

		}

	}

	@Test(priority = 2)
	public void increaseQuantity() throws InterruptedException, IOException {

		double originalPrice;

		if (cart.count(0).equals("1")) {
			originalPrice = cart.subTotal(0);
		} else {
			originalPrice = cart.eachTotal(0);
		}

		System.out.println("originalPrice" + originalPrice);

		double initialTotal = cart.subTotal(0) + originalPrice;
		System.out.println("initialTotal" + initialTotal);

		cart.addButton(0);
		Thread.sleep(2000);

		double finalAmount = cart.subTotal(0);
		System.out.println("finalAmount" + finalAmount);

		if (initialTotal == finalAmount) {
			Assert.assertTrue(true);
			logger.info("Add Quantity Working");
		} else {
			captureScreen(driver, "increaseQuantity");
			Assert.assertTrue(false);
			logger.info("Add Quantity Not Working");
		}

	}

	@Test(priority = 3)
	public void addSameItems() throws InterruptedException, IOException {

		double originalPrice;

		if (cart.count(0).equals("1")) {
			originalPrice = cart.subTotal(0);
		} else {
			originalPrice = cart.eachTotal(0);
		}

		double initialTotal = cart.subTotal(0) + originalPrice;

		driver.get("https://www.walmart.ca/en");

		cart.searchBox("30141499");
		Thread.sleep(2000);

		cart.addCart();
		Thread.sleep(2000);

		cart.checkOut();
		Thread.sleep(2000);

		double finalAmount = cart.subTotal(0);

		if (initialTotal == finalAmount) {
			Assert.assertTrue(true);
			logger.info("Add Same Items Working");
		} else {
			captureScreen(driver, "addSameItems");
			Assert.assertTrue(false);
			logger.info("Add Same Items Not Working");
		}

	}

	@Test(priority = 4)
	public void differentItems() throws InterruptedException, IOException {

		int initialCount = cart.itemList();

		driver.get("https://www.walmart.ca/en");

		cart.searchBox("31357822");
		Thread.sleep(2000);

		cart.addCart();
		Thread.sleep(2000);

		cart.checkOut();
		Thread.sleep(2000);

		int finalCount = cart.itemList();

		if (initialCount != finalCount) {
			Assert.assertTrue(true);
			logger.info("Add different Items Working");
		} else {
			captureScreen(driver, "differentItems");
			Assert.assertTrue(false);
			logger.info("Add different Items Not Working");
		}

	}

	@Test(priority = 5)
	public void removeItems() throws InterruptedException, IOException {

		double initialAmount = cart.total();

		double initialSubAmount = cart.subTotal(0);

		double amountBefore = initialAmount - initialSubAmount;

		cart.removeItem(0);
		Thread.sleep(2000);

		double finalAmopunt = cart.total();

		if (amountBefore == finalAmopunt) {
			Assert.assertTrue(true);
			logger.info("Remove Items Working");
		} else {
			captureScreen(driver, "removeItems");
			Assert.assertTrue(false);
			logger.info("Remove Items Not Working");
		}

	}

	@Test(priority = 6)
	public void removeAllItems() throws InterruptedException, IOException {

		for (int i = 0; i < cart.itemList(); i++) {
			cart.removeItem(i);
			Thread.sleep(2000);
		}

		if (cart.emptyTotal() == 0) {
			Assert.assertTrue(true);
			logger.info("Remove All Items Working");
		} else {
			captureScreen(driver, "removeAllItems");
			Assert.assertTrue(false);
			logger.info("Remove All Items Not Working");
		}

	}

}
