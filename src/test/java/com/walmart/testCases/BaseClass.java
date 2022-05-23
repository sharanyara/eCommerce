package com.walmart.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.walmart.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("ecommerce");
		PropertyConfigurator.configure("Log4j.properties");

		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:9222");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
