package com.qait.MmtAutomation.specs;

import org.openqa.selenium.By;
/**
 * This class simply a POJO that keep tracks of all the locators
 * any locator can be call by using get method
 * @author shivambharadwaj
 *
 */
public class Locators {
	
	private By L_Holets_button = By.id("header_tab_hotels");
	private By L_CityTextField = By.id("hp-widget__sDest");
	private By L_Search_Button = By.id("searchBtn");
	private By L_Price_Button = By.linkText("Price");
	private By L_P_Range_Button = By.xpath(".//a[contains(.,'Rs  4,001 & Above')]");
	private By L_Hotel_Price = By.cssSelector("span[mt-id='hotel_splashed_price']");
	
	public By getL_Holets_button() {
		return L_Holets_button;
	}
	public By getL_CityTextField() {
		return L_CityTextField;
	}
	public By getL_Search_Button() {
		return L_Search_Button;
	}
	public By getL_Price_Button() {
		return L_Price_Button;
	}
	public By getL_P_Range_Button() {
		return L_P_Range_Button;
	}
	public By getL_Hotel_Price() {
		return L_Hotel_Price;
	}
}
