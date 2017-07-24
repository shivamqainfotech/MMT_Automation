package com.qait.MmtAutomation.driver;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * @author shivambharadwaj
 *
 */
public class DriverClass {

	static WebDriver driver;
	private static ResourceBundle rs = ResourceBundle.getBundle("Resources.credentials");

	/**
	 * This is a static method , takes String containing Browser name to be open
	 * upon. It matches the case for different browsers and act upon the match.
	 * 
	 * @param br
	 * @return driver
	 */
	public static WebDriver getDriver(String br) {
		if (br.trim().length() > 0) {
			if (br.equalsIgnoreCase("Chrome")) {
				System.setProperty(rs.getString("ChromedriverName"), rs.getString("ChromedriverPath"));
				driver = new ChromeDriver();
			} 
			else if (br.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.firefox.bin",
						"C:\\Users\\shivambharadwaj\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
				System.setProperty(rs.getString("FirefoxdriverName"), rs.getString("FirefoxdriverPath"));
				driver = new FirefoxDriver();
			}
			else if (br.equalsIgnoreCase("IE")) {
				System.setProperty(rs.getString("IEdriverName"), rs.getString("IEdriverPath"));
				driver = new InternetExplorerDriver();
			}
		}
		return driver;
	}

	/**
	 * This method maximize the window of browser
	 */
	public static void maximizeWindow() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * This method reads the url from property file.
	 */
	public static void getUrl() {
		driver.get(rs.getString("url"));
	}
}
