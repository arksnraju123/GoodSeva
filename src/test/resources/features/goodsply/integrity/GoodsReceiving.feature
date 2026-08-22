@GoodsPlyRegression @GoodsReceiving
Feature: Goods Receiving

  Background: Login into GoodsPly and navigate to Goods Receiving
    Given User login into GoodsPly
    And User open Goods Receiving page

  @GoodsReceiving01
  Scenario: Clear Form functionality and Receive new Goods
    When User open Facilities page
    And User Add new Facility
      | FacilityName | Address              | HoursStart | HoursEnd | TotalDockDoors |
      | Auto_GR_Fac_ | 123, KPHB, Hyderabad | 09:00 AM   | 06:00 PM | 5              |
    And User search with newly created Facility
    And User click on newly created facility
    And User open Zones tab
    And User add new Zones in facility
      | ZoneName          | ZoneCode | ZoneType | MaxCapacity | Description             |
      | Auto_GR_Fac_Zone_ | 99887    | Shipping | 2000        | Test Zone from Facility |
    And User open Bins tab
    And User add new Bins in facility
      | Zone       | BinCode          | BinType | Aisle | Rack |
      | AutoSelect | Auto_GR_Fac_Bin_ | Bulk    | AS001 | R001 |
    And User open Products & SKUs page
    And User Add new Product
      | SKU          | ProductName      | Description          | Category    | Brand   | UnitOfMeasure | Weight | Length | Width | Height | BarcodeType | BarcodeValue | ActiveProduct | SerialTracked | LotTracked | ShelfLife | ReorderPoint | ReorderQuantity |
      | Auto_GR_SKU_ | Auto_GR_Product_ | New Test Description | Electronics | Samsung | Box           | 101    | 102    | 103   | 104    | QR Code     | 121212123    | Yes           | Yes           | Yes        | 11        | 12           | 14              |
    And User open Goods Receiving page
    # Newly created PO is not showing immediately on Goods Receiving page so refresh page
    And User refresh the page
    And User Add new Goods Receiving
      | Facility   | Product    | Bin        | Quantity | UnitCost | LotNumber | PONumber | Notes               | IsSave |
      | AutoSelect | AutoSelect | AutoSelect | 250      | 20.5     | 1122      | PO-2233  | New Goods Receiving | false  |
    And User click on Clear Form button
    Then Verify Receiving Details form has default values
    When User Add new Goods Receiving
      | Facility   | Product    | Bin        | Quantity | UnitCost | LotNumber | PONumber | Notes               | IsSave |
      | AutoSelect | AutoSelect | AutoSelect | 250      | 20.5     | 1122      | PO-2233  | New Goods Receiving | true   |
    When User search with Product
    Then Verify table data
      | Date  | Product      | QtyReceived | Bin          | POReference | Notes               |
      | Today | AutoVerified | +250.000    | AutoVerified | PO-2233     | New Goods Receiving |
    When User search with Bin
    Then Verify table data
      | Date  | Product      | QtyReceived | Bin          | POReference | Notes               |
      | Today | AutoVerified | +250.000    | AutoVerified | PO-2233     | New Goods Receiving |
    When User search with PO/Reference
    Then Verify table data
      | Date  | Product      | QtyReceived | Bin          | POReference | Notes               |
      | Today | AutoVerified | +250.000    | AutoVerified | PO-2233     | New Goods Receiving |

  @GoodsReceiving02
  Scenario: Verify pagination
    Then Verify Previous button disabled by default in Goods Receiving page
    When User click on Next button in Goods Receiving page
    Then Verify page navigated to page 11 in Goods Receiving page
    When User click on Previous button in Goods Receiving page
    Then Verify page navigated to page 1 in Goods Receiving page