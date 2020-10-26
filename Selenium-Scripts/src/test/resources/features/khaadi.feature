Feature: Khaddi

  Background:
    Given Navigate to Application

  Scenario: Validate user is able to proceed guest checkout on searched product
    When user click on "closepopup" button on "SearchPage"
    And user click on "searchBtn" button on "SearchPage"
    And user enter text "Searchproduct" in "searchBar" on "SearchPage"
    Then Assert that "searchResult" appear on "SearchPage"
    And user click on "searchedProduct" button on "SearchPage"
    Then Assert that "productName" appear on "PDP"
    Then Assert that "productPrice" appear on "PDP"
    And user click on "size" button on "PDP"
    And user click on "AddtoCart" button on "PDP"
    And user click on "check-Out" button on "PDP"
    Then Assert that "productCount" appear on "PDP"
    And user enter text "email" in "email" on "ShipperForm"
    And user select "Title" from "Title" on "ShipperForm"
    And user enter text "firstName" in "firstName" on "ShipperForm"
    And user enter text "lastName" in "lastName" on "ShipperForm"
    And user enter text "phone" in "phone" on "ShipperForm"
    And user enter text "address" in "address" on "ShipperForm"
    And user enter text "street" in "street" on "ShipperForm"
    And user select "Country" from "Country" on "ShipperForm"
    And user select "province" from "province" on "ShipperForm"
    And user select "City" from "City" on "ShipperForm"
    And user enter text "landMark" in "landMark" on "ShipperForm"
    And user enter text "SpecialInstruction" in "SpecialInstruction" on "ShipperForm"
    And user click on "Next" button on "ShipperForm"
