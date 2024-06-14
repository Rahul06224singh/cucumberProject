Feature: Amazon Document
  I want to use this document to test functionality of Amazon

  @amazon @uid
  Scenario: Userid test
    Given I open browser "chrome" with url "https://www.amazon.in" and initialize report "LoginReport"
    And i click signin
    When i enter valid userid "9891011939"
    And click continue button
    Then I validate the userid is valid
   
   @amazon @pwd 
   Scenario: Password test
     Given userid is valid
     When i enter a valid password "IndiaIndia12#"
     Then i should login

  @amazon @product
  Scenario Outline: Product Search
     Given i am logged in
     When i search for product <product> in range <price>
     Then results must come
     
   Examples:
   |product|price|  
   | Shirt | 500 |
   | Pant | 1200|
   
   @amazon @forget
   Scenario: Forget pwd
   Given browser "chrome" with url "https://www.amazon.in" is open and report name "ForgetReport"
   And click on signin link
   And click on help link
   And click on forget pwd link
   When enter userid "9891011939" to recover pwd
   And enter click button
   Then message should get
  
