#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
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
   
