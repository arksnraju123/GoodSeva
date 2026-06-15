@GoodsPlyRegression @WMSDashboard
Feature: Warehouse Management System Dashboard

  Background: Login into GoodsPly and navigate to WMSDashboard page
    Given User login into GoodsPly
    And User open WMS Dashboard page

  @WMSDashboard01
  Scenario: Verify Warehouse Management System Dashboard
    Then Verify total Facilities
    And Verify total Zones
    And Verify total Bins
    And Verify total Products
    And Verify total Inventory
    When User click on each link in WMS Overview Quick Actions and validate navigation
      | Link               | ExpectedPage |
      | Manage Facilities  | facilities   |
      | Manage Zones       | zones        |
      | Manage Bins        | bins         |
      | Manage Products    | products     |
      | Manage Inventory   | inventory    |
      | Manage Orders      | orders       |
      | Booking Management | booking-mgmt |
