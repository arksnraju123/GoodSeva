@GoodsPlyRegression @CheckIn
Feature: Manage driver arrivals, check-ins, and dock assignments.

  Background: Login into GoodsPly and navigate to CheckIn page
    Given User login into GoodsPly
    And User open Check-In page

  @CheckIn01
  Scenario: Verify Driver Quick Check-In
    And User create Quick Check-In
      | VehicleLicense | Notes   |
      | License_       | My Note |
    Then Verify Quick CheckIn

  @CheckIn02
  Scenario: Verify Driver Walk-In Check-In
    And User create Walk In Check-In
      | DriverName | VehicleLicense | CarrierName | LoadType        | Notes        |
      | Driver_    | License_       | Carrier_    | Outbound Pickup | Walk-In Note |
    Then Verify Walk-In CheckIn