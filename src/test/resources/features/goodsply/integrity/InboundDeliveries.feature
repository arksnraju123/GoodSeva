@GoodsPlyRegression @InboundDeliveries
Feature: Inbound Deliveries

  Background: Login into GoodsPly and navigate to Inbound Deliveries
    Given User login into GoodsPly
    And User open Inbound Deliveries page

  @InboundDeliveries01
  Scenario: Create Purchase Orders and change Status
    Given User open Products & SKUs page
    When User Add new Product
      | SKU     | ProductName | Description          | Category    | Brand   | UnitOfMeasure | Weight | Length | Width | Height | BarcodeType | BarcodeValue | ActiveProduct | SerialTracked | LotTracked | ShelfLife | ReorderPoint | ReorderQuantity |
      | ID_SKU_ | ID_Product_ | New Test Description | Electronics | Samsung | Box           | 101    | 102    | 103   | 104    | QR Code     | 121212123    | Yes           | Yes           | Yes        | 11        | 12           | 14              |
    And User open Facilities page
    And User Add new Facility
      | FacilityName | Address              | HoursStart | HoursEnd | TotalDockDoors |
      | ID_Fac_      | 123, KPHB, Hyderabad | 09:00 AM   | 06:00 PM | 5              |
    And User open Purchase Orders page
    And User Add new Purchase Orders
      | Vendor | ExpectedDeliveryDate | PaymentTerms | Description | Quantity | UnitOfMeasure | UnitPrice | Notes      |
      | HPCL   | today+1              | Net 45       | Electronics | 10       | BOX           | 250       | Test Notes |
    And User click on Approve action
    And User click on Issue action
    And User open Inbound Deliveries page
    # Newly created PO is not showing immediately on GRN page so refresh page
    And User refresh the page
    And User click on GRNs tab
    And User get latest GRN number
    And User click on Pending POs tab
    And User search with PO Number in Inbound Deliveries Pending POs tab
    Then User verify purchase order details in Inbound Deliveries Pending POs tab
      | POOrder    | Vendor     | ExpectedDate | Items   | Status |
      | AutoVerify | AutoVerify | AutoVerify   | 1 items | issued |
    When User click on Receive button
    Then User verify create GRN Report with default values
      | Facility   | ReceiptType               | PurchaseOrder |
      | AutoVerify | Purchase Order (PO-based) | AutoVerify    |
    When User click on Receive button
    And User create new GRN
      | Facility   | ReceiptType | PurchaseOrder | VehicleNumber | DriverName  | LRNumber | Notes      |
      | AutoSelect | AutoSelect  | AutoSelect    | TG01TG0011    | Test Driver | LR_001   | Test Notes |
    And User click on GRNs tab
    Then User verify purchase order details in Inbound Deliveries GRNs tab
      | GRNNumber  | Vendor     | Items | ReceivedQty | ReceivedAt | QCStatus |
      | AutoVerify | AutoVerify | 0     | 0           | AutoVerify | draft    |
    When User click on Complete button
    And User complete GRN
      | Product    | Received | Accepted | Rejected | LotNumber | ExpiryDate |
      | AutoSelect | 100      | 95       | 5        | Lot_001   | Today+1    |
    Then User verify purchase order details in Inbound Deliveries GRNs tab
      | GRNNumber  | Vendor     | Items | ReceivedQty | ReceivedAt | QCStatus  |
      | AutoVerify | AutoVerify | 1     | 100         | AutoVerify | completed |

  @InboundDeliveries02
  Scenario: Verify Pending POs pagination
    When User click on Pending POs tab
    Then Verify Previous button disabled by default in Pending POs page
    When User click on Next button in Pending POs page
    Then Verify page navigated to page 2 in Pending POs page
    When User click on Previous button in Pending POs page
    Then Verify page navigated to page 1 in Pending POs page

  @InboundDeliveries03
  Scenario: Verify Pending POs pagination
    When User click on GRNs tab
    Then Verify Previous button disabled by default in GRNs page
    When User click on Next button in GRNs page
    Then Verify page navigated to page 2 in GRNs page
    When User click on Previous button in GRNs page
    Then Verify page navigated to page 1 in GRNs page

  @InboundDeliveries04
  Scenario: Verify Pending POs, In-Progress GRNs, Completed GRNs and Total GRNs count
    Then Verify Pending POs total count
    And User click on GRNs tab
    And Verify In-Progress GRNs total count
    When User refresh the page
    And User click on GRNs tab
    And Verify Completed GRNs total count
    And Verify Total GRNs total count

  @InboundDeliveries05
  Scenario: Verify filter functionality in Pending POs
    Then Verify search PO number filter in Pending POs Tab
    When User reset POs search in Pending POs Tab
    Then Verify Vendors filter in Pending POs Tab

  @InboundDeliveries06
  Scenario: Verify filter functionality in GRNs
    And User click on GRNs tab
    Then Verify search GRN number filter in GRNs tab
    When User reset GRN search in GRNs tab
    Then Verify Vendors filter in GRN Tab