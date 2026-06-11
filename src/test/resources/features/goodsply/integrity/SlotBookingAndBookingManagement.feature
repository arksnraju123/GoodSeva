@GoodsPlyRegression
Feature: Warehouse Management System Dashboard

  Background: Login into GoodsPly and navigate to Slot Booking page
    Given User login into GoodsPly
    And User open Slot Booking page

  @SlotBooking01
  Scenario: Verify Slot Booking and Reject
    When User create new Slot Booking
      | VehicleNumber | VehicleType | DriverName | LicenseNumber | MobileNumber | ExpectedArrivalDate | ArrivalTime | DepartureTime | LoadType | GoodsType   |
      | TG01TG        | Van         | VanDriver_ | Lic001        | 9876543210   | Today+1             | 10:00       | 12:30         | Inbound  | Electronics |
    And User open Booking Management page
    And Select calendar date Today+1
    Then Verify slot booking details
      | Status  |
      | Pending |
    When User open newly created slot booking
    Then Verify all details on Booking Details popup
      | Status  |
      | Pending |
    When User Reject the booking on Booking Details popup
    When User open newly created slot booking
    Then Verify all details on Booking Details popup after reject
      | Status   |
      | Rejected |
