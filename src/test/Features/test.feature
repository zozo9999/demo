@featureTest
Feature: Check sorting is working.
	#tag name above feature will run all tags in the below.	
	#tag names = or, and, , or and, and not,
	
	Background:
		Given validate brwoser
		When browser is triggared
		Then check if brwoser is started
	
	#verify if login successfully
	@Login
	Scenario: Login in
    Given Log in "standard_user"
	  When Click log in button
    Then Verify if login in
			
	#Sort
	#A to Z, Z to A, low to high, high to, low
	@Login @Sorting
  Scenario Outline: User sorts A to Z
    Given Login <username>, Sorting tab is seen
    And Enter "secret_sauce" in password
    When click <sort> is clicked.
    Then Vertify_A_to_Z
		Examples:
			|username 				|fname |lname |zip |sort				|
			|"standard_user" 	|fname1|lname1|zip1|"A to Z"			|
			|"standard_user" 	|fname1|lname1|zip1|"Z to A"			|
			|"standard_user"	|fname2|lname2|zip1|"low to high"	|
			|"standard_user"	|fname3|lname3|zip1|"high to low"	|
#	|performance_glitch_user	|fname4|lname4|zip1|

	@Login @Buy
	Scenario: Check products
    Given Log in "standard_user"
	  When Click log in button
    Then Verify if login in
    And Click Products
    Then Check Products
	
	@Login @Sorting2
  Scenario Outline: User sorts A to Z
    Given Login "standard_user", Sorting tab is seen
    And Enter "secret_sauce" in password
    When click "low to high" is clicked.
    Then Vertify_A_to_Z		
	

#| Jung | Shin | email@email.com |
# data driving testign
# DataTable data
# List<List<String>> obj = daa.raw
# get(0).get(0)
# get(0).get(1)
# get(0).get(2) 

#"" means regular exression and can reduce duplicate .

 	
  
 # The Scenario Outline keyword can be used to run the same Scenario multiple times, with different combinations of values.

	#tag names = or, and, , or and, and not, 
#	@Sorting_AZ
  #Scenario: User sorts A to Z
    #Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting A to Z is clicked.
    #Then Products are sorted from A to Z.

  #@Sorting_ZA
  #Scenario: User sorts Z to A
 #		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting Z to A is clicked.
#		Then Products are sorted from Z to A.

#	@Sorting_LH
  #Scenario: Price low to high
#		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting low to high is clicked.
#		Then Products are sorted from low to high
 
#	@Sorting_HL
  #Scenario: Price high to low
#		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting high to low is clicked.
  #	Then Products are sorted from high to low
	

