@GoodsPlyRegression @PurchaseOrders
Feature: Purchase Orders

  Background: Login into GoodsPly and navigate to Purchase Orders
    Given User login into GoodsPly
    And User open Purchase Orders page

  @PurchaseOrders01
  Scenario: Create Purchase Orders and change Status
    Given User Add new Purchase Orders
      | Vendor | ExpectedDeliveryDate | PaymentTerms | Description | Quantity | UnitOfMeasure | UnitPrice | Notes      |
      | HPCL   | today+1              | Net 45       | Electronics | 10       | BOX           | 250       | Test Notes |
    Then Verify newly created Purchase Orders
      | PONumber     | Vendor | Date    | Amount | Unit | Status |
      | AutoVerified | HPCL   | today+0 | ₹2,950 | BOX  | draft  |
    Then Verify newly created Purchase Orders Details on view popup
      | PONumber     | Vendor | Status | PODate  | DeliveryDate | PaymentTerms | TotalAmount | Notes      | Description | Quantity | UnitOfMeasure | UnitPrice | Tax | LineTotal | Total  |
      | AutoVerified | HPCL   | draft  | today+0 | today+1      | net 45       | ₹2,950      | Test Notes | Electronics | 10       | BOX           | ₹250.00   | 18% | ₹2,950    | ₹2,950 |
    When User click on Approve action
    Then Verify status is approved
    And Verify approved status on view popup
    When User click on Issue action
    Then Verify status is issued
    And Verify issued status on view popup

  @PurchaseOrders02
  Scenario: Verify Add Line Items on Create PO popup
    Given User click on Create PO button
    When User Add bellow Line Items on Create Purchase Orders Popup
      | Description | Quantity | UnitOfMeasure | UnitPrice |
      | Electronics | 10       | KG            | 100       |
      | Food        | 20       | BOX           | 200       |
      | Chemicals   | 30       | KG            | 300       |
    Then Verify added Line Items on Create Purchase Orders Popup
      | Description | Quantity | UnitOfMeasure | Price   | Total    |
      | Electronics | 10       | KG            | ₹100.00 | ₹1000.00 |
      | Food        | 20       | BOX           | ₹200.00 | ₹4000.00 |
      | Chemicals   | 30       | KG            | ₹300.00 | ₹9000.00 |
    And Verify SUbTotal, Tax_GST and Total
      | SubTotal  | Tax      | Total     |
      | ₹14000.00 | ₹2520.00 | ₹16520.00 |
    When User delete row 2 in Line Items
    Then Verify added Line Items on Create Purchase Orders Popup
      | Description | Quantity | UnitOfMeasure | Price   | Total    |
      | Electronics | 10       | KG            | ₹100.00 | ₹1000.00 |
      | Chemicals   | 30       | KG            | ₹300.00 | ₹9000.00 |
    And Verify SUbTotal, Tax_GST and Total
      | SubTotal  | Tax      | Total     |
      | ₹10000.00 | ₹1800.00 | ₹11800.00 |
    When User close Create PO popup

  @PurchaseOrders03
  Scenario: Verify pagination
    Then Verify Previous button disabled by default in Purchase Order page
    When User click on Next button in Purchase Order page
    Then Verify page navigated to page 2 in Purchase Order page
    When User click on Previous button in Purchase Order page
    Then Verify page navigated to page 1 in Purchase Order page

  @PurchaseOrders04
  Scenario: Verify Filters
    Given User search for PO number
    Then Verify search results with searched PO number in Purchase Orders page
    When User reset PO number search in Purchase Orders page
    When User search for HPCL Vendors
    Then Verify search results with HPCL Vendors in Purchase Orders page

  @PurchaseOrders05
  Scenario: Verify Total Purchase Orders
    Then Verify total Purchase Orders

