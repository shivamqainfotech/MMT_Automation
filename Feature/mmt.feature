
@tag
Feature: Exploring MMT Hotels
	I want to automate the selection of cheapest hotel at "<cityName>"


@tag2
Scenario Outline: Select cheapest hotel in "<cityName>"
Given I am on MMT dashboard page

When I click on Holets button next page should be updated with url containing /hotels
And  I passes "<cityName>" click on search button page should be updated with hotels
And  I click on price button and select  last button then list of HighCost hotels should appear
Then I select the price of highest price hotel

Examples:
    | cityName|  
    | Delhi| 
   
