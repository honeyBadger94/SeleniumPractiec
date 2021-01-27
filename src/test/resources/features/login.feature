Feature: Consistency of prices

  @smoke
  Scenario Outline:  List and Cart should match

    Given User is on the login page
    And User searches "Books" as "software testing book for beginners"
    Then User clicks on the "<first>" option
    And Product page price and Listing price should match
    Then User click on Add to cart button
    Then All prices should match
    Examples: test
        |first|
        |  1  |


    Scenario: sadsa
      Given asda
      When asdas
      Then asdas


