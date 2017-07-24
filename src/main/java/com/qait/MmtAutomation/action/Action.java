package com.qait.MmtAutomation.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qait.MmtAutomation.specs.Locators;
import com.qait.MmtAutomation.utility.UtilityClass;

/**
 * 
 * @author shivambharadwaj
 *
 */
public class Action {
	private static WebDriver driver;
	private static Locators locator = new Locators();
	private UtilityClass util = new UtilityClass();

	public Action(WebDriver driver) {
		Action.driver = driver;
	}
/**
 * This method will take locator and time in seconds as input and return web element for that locator
 * @param seconds
 * @param locators
 * @return
 */
	public static WebElement getWebElement(int seconds, By locators) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
		return element;

	}
/**
 * This method will click on Hotel button displayed on the dashboard of Make My Trip
 */
	public void click_on_Holets_button() {
		getWebElement(10, locator.getL_Holets_button()).click();

	}
	/**
	 * This method will click on Search button after filling the city name.
	 */
	public void click_on_search_button(String city) throws InterruptedException {
		WebElement ele1 = getWebElement(10, locator.getL_CityTextField());
		ele1.click();
		Thread.sleep(800);
		ele1.sendKeys(city);
		Thread.sleep(800);
		getWebElement(10, locator.getL_Search_Button()).click();

	}
	/**
	 * This method will click on price button displayed for the hotels in the given city
	 */
	public void click_on_price_button() throws InterruptedException {
		Thread.sleep(4000);
		WebElement ele2 = getWebElement(10, locator.getL_Price_Button());
		ele2.click();
		getWebElement(10, locator.getL_P_Range_Button()).click();

	}
	/**
	 * This method will click on price range button displayed for the hotels in the given city
	 */
	public void select_the_price() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		List<WebElement> list = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator.getL_Hotel_Price()));
		Thread.sleep(4000);
		System.out.println("No of Hotels at this page is " + list.size());
		util.calculateHotelPrice(list);
	}
}
