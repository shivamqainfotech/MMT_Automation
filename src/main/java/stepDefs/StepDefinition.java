package stepDefs;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	/**
	 * @author shivambharadwaj
	 */
	WebDriver driver;
	
	
	By Holets_button=By.id("header_tab_hotels");
	By CityTextField=By.id("hp-widget__sDest");
	By Search_Button=By.id("searchBtn");
	By Price_Button=By.linkText("Price");
	By P_Range_Button=By.xpath(".//a[contains(.,'Rs  4,001 & Above')]");
	By Hotel_Price= By.cssSelector("span[mt-id='hotel_splashed_price']");
	
	static ResourceBundle rs = ResourceBundle.getBundle("Resources.credentials");
	
	
	
	@Given("^I am on MMT dashboard page$")
	
	public void i_am_on_MMT_dashboard_page()  {
		System.setProperty(rs.getString("driverName"), rs.getString("driverPath"));
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get(rs.getString("url"));

	}

	@When("^I click on Holets button next page should be updated with url containing /hotels$")
	public void i_click_on_Holets_button_next_page_should_be_updated_with_url_containing_hotels()  {
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated(Holets_button));
	    ele1.click();
	   
	}

	@When("^I passes \"([^\"]*)\" click on search button page should be updated with hotels$")
	public void i_passes_click_on_search_button_page_should_be_updated_with_hotels(String city) throws InterruptedException{
	WebDriverWait wait=new WebDriverWait(driver,20);
	
	WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(CityTextField));
	  
	   ele2.click();
      wait.until(ExpectedConditions.visibilityOf(ele2));
	   Thread.sleep(800);
	   ele2.sendKeys(city);
	  
	   Thread.sleep(800);
	   
	
	   WebElement ele4=wait.until(ExpectedConditions.visibilityOfElementLocated(Search_Button));
	   ele4.click();
	  
	}

	@When("^I click on price button and select  last button then list of HighCost hotels should appear$")
	public void i_click_on_price_button_and_select_last_button_then_list_of_HighCost_hotels_should_appear() throws InterruptedException   {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click()", driver.findElement(Price_Button));
		WebDriverWait wait=new WebDriverWait(driver,10);
		   WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(P_Range_Button));
		   element.click();

	}
	

	@Then("^I select the price of highest price hotel$")
	public void i_select_the_price_of_highest_price_hotel() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Hotel_Price));
	    List<WebElement> list=driver.findElements(Hotel_Price);
	    Thread.sleep(4000);
	    System.out.println("No of Hotels at this page is "+list.size());
	    List<Integer> priceList=new ArrayList<Integer>();
	    for(int i=0;i<list.size();i++){
	    	String p=list.get(i).getText();
	    	priceList.add(Integer.valueOf(p.replaceAll("[,]", "")));
		    
	    }
	    System.out.println("maximum price of Hotel at this page  is  "+priceList.stream().max(Integer::compare).get());
	    System.out.println("Minimum price of Hotel at this page  is  "+priceList.stream().min(Integer::compare).get());
	}


}
