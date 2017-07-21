package com.qait.MmtAutomation.utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
/**
 * 
 * @author shivambharadwaj
 *
 */
public class UtilityClass {

	/**
	 * This method takes an arraylist as input and calculate Minimum and Maximum price hotels at that page
	 * @param list
	 */
	public void calculateHotelPrice(List<WebElement> list) {
		List<Integer> priceList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			String p = list.get(i).getText();
			priceList.add(Integer.valueOf(p.replaceAll("[,]", "")));

		}
		System.out
				.println("maximum price of Hotel at this page  is  " + priceList.stream().max(Integer::compare).get());
		System.out
				.println("Minimum price of Hotel at this page  is  " + priceList.stream().min(Integer::compare).get());
	}
		
	}


