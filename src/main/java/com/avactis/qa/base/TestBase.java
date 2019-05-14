package com.avactis.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					"E:\\automation\\AvactisTest\\src\\main\\java\\com\\avactis\\qa\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"src\\test\\resources\\geckodriver-32bit.exe");
			driver = new FirefoxDriver();

		}
         driver.manage().deleteAllCookies();
         driver.manage().window().maximize();
         driver.get(prop.getProperty("URL_Local"));
	}

}
