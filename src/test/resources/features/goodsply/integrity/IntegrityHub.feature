@GoodsPlyRegression @IntegrityHub
Feature: Integrity Hub - Single console for warehouse, inventory, and fulfillment. Same data, three workflows.

  Background: Login into GoodsPly and navigate to Integrity Hub page
    Given User login into GoodsPly
    And User open Integrity Hub page

  @IntegrityHub01
  Scenario: Open each link and validate navigation
    When User click on each link and validate navigation
      | Link                      | ExpectedPage        |
      | WMS Dashboard             | dashboard           |
      | Live Tracking             | live-tracking       |
      | QR Scanner                | qr-scanner          |
      | Facilities                | facilities          |
      | Layouts & Bins            | layouts             |
      | Products & SKUs           | products            |
      | Appointments              | appointments        |
      | Check-In                  | check-in            |
      | Purchase Orders           | purchase-orders     |
      | Inbound Deliveries        | inbound-deliveries  |
      | Goods Receiving           | receiving           |
      | GRN Entry                 | grn                 |
      | Put-Away                  | putaway-console     |
      | Order Management (OMS)    | oms                 |
      | Warehouse Execution (WES) | warehouse-execution |
      | Reports & KPIs            | reports             |
      | AI Inventory              | ai-inventory        |
      | Quality Surveillance      | quality             |
      | AI Vehicle Monitor        | vehicle-ai          |
    And User click on Storage Tab
    When User click on each link and validate navigation
      | Link                   | ExpectedPage |
      | Stock Overview         | inventory    |
      | Inventory Control      | inventory    |
      | Safety Stock & Reorder | safety-stock |
      | Adjustments            | adjustments  |
      | Cycle Counts           | cycle-counts |
      | Stock Movement         | receiving    |
    And User click on Outbound Tab
    When User click on each link and validate navigation
      | Link               | ExpectedPage      |
      | Sales Orders       | orders            |
      | Picking Console    | picking-console   |
      | Packing & Labeling | packing           |
      | Dispatch Console   | dispatch-console  |
      | Returns            | returns           |
      | Fulfillment Hub    | order-fulfillment |
      | Shipping           | shipping          |
      | Proof of Delivery  | pod               |