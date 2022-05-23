package com.walmart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.walmart.pageObject.Login;
import com.walmart.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		Login lp = new Login(driver);
		
		driver.get(readconfig.getApplicationURL());
		
		lp.userName(user);
		logger.info("user name provided");
		
		lp.password(pwd);
		logger.info("password provided");
		
		lp.signIn();

		Thread.sleep(2000);

		if (driver.getTitle().equals("Shop Walmart.ca: Online Shopping & Everyday Low Prices")) {
			Assert.assertTrue(true);
			logger.info("Login passed");
		} else {
			captureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}

	}


	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/walmart/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
	}

}
