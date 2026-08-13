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
    And User click on Pending POs tab
    Then User verify purchase order details in Inbound Deliveries
      | POOrder    | Vendor     | ExpectedDate | Items   | Status |
      | AutoVerify | AutoVerify | AutoVerify   | 1 items | issued |
    When User click on Receive button
    Then User verify purchase order
    When User click on Receive button
    And User create new GRN
      | Facility   | ReceiptType               | PurchaseOrder | VehicleNumber | DriverName  | LRNumber | Notes      |
      | AutoSelect | Purchase Order (PO-based) | AutoSelect    | TG01TG0011    | Test Driver | LR_001   | Test Notes |
    And User click on GRNs tab
    Then User verify purchase order details in Inbound Deliveries
      | GRNNumber  | Vendor     | Items | ReceivedQty | Received At | QC Status |
      | AutoVerify | AutoVerify | 0     | 0           | Today       | draft     |
    When User click on Complete button
    And User complete GRN
      | Product    | Received | Accepted | Rejected | LotNumber | Expiry Date |
      | AutoSelect | 100      | 95       | 5        | Lot_001   | Today+1     |
    Then User verify completed GRN
      | GRNNumber  | Vendor     | Items | ReceivedQty | Received At | QC Status |
      | AutoVerify | AutoVerify | 1     | 100         | Today       | completed |




