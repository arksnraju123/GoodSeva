@GoodsPlyRegression @SlotBooking
Feature: Warehouse Management System Dashboard

  Background: Login into GoodsPly and navigate to Slot Booking page
    Given User login into GoodsPly
    And User open Slot Booking page

  @SlotBooking01
  Scenario: Verify Slot Booking and Reject
    When User create new Slot Booking
      | VehicleNumber | VehicleType | DriverName | LicenseNumber | MobileNumber | ExpectedArrivalDate | ArrivalTime | DepartureTime | LoadType | GoodsType   |
      | TG01RJ        | Van         | VanDriver_ | Lic001        | 9876543210   | Today+1             | 10:00       | 12:30         | Inbound  | Electronics |
    And User open Booking Management page
    And Select calendar date Today+1
    Then Verify slot booking details
      | Status  |
      | Pending |
    When User open newly created slot booking
    Then Verify all details on Booking Details popup
      | Status  |
      | Pending |
    When User get total total Pending, Approved, Rejected and Total
    And User Reject the booking on Booking Details popup
    And User open newly created slot booking
    Then Verify all details on Booking Details popup after reject
      | Status   |
      | Rejected |
    And Verify Pending and Rejected after Reject
    And Verify slot booking total

  @SlotBooking02
  Scenario: Verify Slot Booking and Approved
    When User create new Slot Booking
      | VehicleNumber | VehicleType | DriverName   | LicenseNumber | MobileNumber | ExpectedArrivalDate | ArrivalTime | DepartureTime | LoadType | GoodsType  |
      | TG01AP        | Truck       | TruckDriver_ | Lic001        | 9876543210   | Today+1             | 10:00       | 12:30         | Outbound | Automotive |
    And User open Booking Management page
    And Select calendar date Today+1
    Then Verify slot booking details
      | Status  |
      | Pending |
    When User open newly created slot booking
    Then Verify all details on Booking Details popup
      | Status  |
      | Pending |
    When User get total total Pending, Approved, Rejected and Total
    When User Approve the booking on Booking Details popup
    And User open newly created slot booking
    Then Verify all details on Booking Details popup after reject
      | Status   |
      | Approved |
    And Verify Pending and Approved after Approved
