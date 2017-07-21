package stepDefs;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import com.qait.MmtAutomation.action.Action;
import com.qait.MmtAutomation.driver.DriverClass;
import com.qait.MmtAutomation.specs.Locators;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	/**This is a step definition class where we can understand the simple english to know the functionality 
	 * of the method.
	 * @author shivambharadwaj
	 */
	WebDriver driver=DriverClass.getDriver(rs.getString("browser"));
	Action action =new Action(driver);
	Locators locator = new Locators();
	
	static ResourceBundle rs = ResourceBundle.getBundle("Resources.credentials");

	@Given("^I am on MMT dashboard page$")
	public void i_am_on_MMT_dashboard_page() {
		DriverClass.maximizeWindow();
		DriverClass.getUrl();

	}

	@When("^I click on Holets button next page should be updated with url containing /hotels$")
	public void i_click_on_Holets_button_next_page_should_be_updated_with_url_containing_hotels() {
		action.click_on_Holets_button();

	}

	@When("^I passes \"([^\"]*)\" click on search button page should be updated with hotels$")
	public void i_passes_click_on_search_button_page_should_be_updated_with_hotels(String city) throws InterruptedException
			{
		action.click_on_search_button(city);

	}

	@When("^I click on price button and select  last button then list of HighCost hotels should appear$")
	public void i_click_on_price_button_and_select_last_button_then_list_of_HighCost_hotels_should_appear()
			throws InterruptedException {
		action.click_on_price_button();
	}

	@Then("^I select the price of highest price hotel$")
	public void i_select_the_price_of_highest_price_hotel() throws InterruptedException {
		action.select_the_price();
	}	

}
