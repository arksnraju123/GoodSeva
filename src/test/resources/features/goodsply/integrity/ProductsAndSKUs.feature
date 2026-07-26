@GoodsPlyRegression @ProductsAndSKUs
Feature: Products Management

  Background: Login into GoodsPly and navigate to Products & SKUs page
    Given User login into GoodsPly
    And User open Products & SKUs page

  @ProductsAndSKUs01
  Scenario: Create, Update and Delete Product and verify Search
    Given User Add new Product
      | SKU       | ProductName   | Description          | Category    | Brand   | UnitOfMeasure | Weight | Length | Width | Height | BarcodeType | BarcodeValue | ActiveProduct | SerialTracked | Lot Tracked | ShelfLife | ReorderPoint | ReorderQuantity |
      | Auto_SKU_ | Auto_Product_ | New Test Description | Electronics | Samsung | Box           | 101    | 102    | 103   | 104    | QA Code     | 121212123    | Yes           | Yes           | Yes         | 11        | 12           | 14              |
    Then Verify newly created Product
      | SKU          | Name         | Category    | Brand   | Unit | Status | Tracking   |
      | AutoVerified | AutoVerified | Electronics | Samsung | Box  | Active | Serial,Lot |
    When User search with SKU in Products page
    Then Verify search results with searched SKU in Products page
    When User reset SKU search in Products page
    And User search with Name in Products page
    Then Verify search results with searched Name in Products page
    When User reset Name search in Products page
    And User search with Category in Products page
    Then Verify search results with searched Category in Products page
    When User reset Category search in Products page
    And User search with Status in Products page
    Then Verify search results with searched Status in Products page
    When User reset Status search in Products page
    When User Edit new Product
      | ProductName   | Description              | Category   | Brand | UnitOfMeasure | Weight | Length | Width | Height | BarcodeType | BarcodeValue | ActiveProduct | SerialTracked | Lot Tracked | ShelfLife | ReorderPoint | ReorderQuantity |
      | Auto_Product_ | Updated Test Description | Automotive | BMW   | Case          | 201    | 202    | 203   | 204    | UPC         | 121212223    | No            | No            | No          | 21        | 22           | 24              |
    Then Verify newly edited Product
      | SKU          | Name         | Category   | Brand | Unit | Status   | Tracking |
      | AutoVerified | AutoVerified | Automotive | BMW   | Case | Inactive | None     |
    Then Verify all edited fields in edit Product page
      | Description              | Category   | Brand | UnitOfMeasure | Weight | Length | Width | Height | BarcodeType | BarcodeValue | ActiveProduct | SerialTracked | Lot Tracked | ShelfLife | ReorderPoint | ReorderQuantity |
      | Updated Test Description | Automotive | BMW   | Case          | 201    | 202    | 203   | 204    | UPC         | 121212223    | No            | No            | No          | 21        | 22           | 24              |
    When User click on Delete in Products page
    Then Verify Bin has deleted in Products page


