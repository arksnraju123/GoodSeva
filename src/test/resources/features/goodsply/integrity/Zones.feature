@GoodsPlyRegression
Feature: Manage Zones Management

  Background: Login into GoodsPly and navigate to Zones page
    Given User login into GoodsPly
    And User open Zones page

  @Zones01
  Scenario: Create Update and Delete Zones
    Given User click on Add Zone button
    When User create new Zone with bellow data
      | Facility | ZoneName        | ZoneCode        | ZoneType | Temperature | MaximumCapacity | Status |
      | 1        | Auto_Zone_Name_ | AUTO_ZONE_CODE_ | Shipping | Frozen      | 100             | Active |
    And User search for Zone
    Then Verify newly created Zone details
      | Facility | ZoneName        | ZoneCode        | ZoneType | Temperature | MaximumCapacity | Status |
      | 1        | Auto_Zone_Name_ | AUTO_ZONE_CODE_ | Shipping | Frozen      | 100             | Active |
    When User click on edit Zone
    When User update Zone with bellow data
      | Facility | ZoneName               | ZoneCode                | ZoneType | Temperature | MaximumCapacity | Status   |
      | 2        | Auto_Zone_Update_Name_ | AUTO_ZONE_UPDATED_CODE_ | Storage  | Chilled     | 200             | Inactive |
    And User search for Zone
    Then Verify updated Zone details
      | Facility | ZoneName               | ZoneCode                | ZoneType | Temperature | MaximumCapacity | Status   |
      | 2        | Auto_Zone_Update_Name_ | AUTO_ZONE_UPDATED_CODE_ | Storage  | Chilled     | 200             | Inactive |
    When User Delete Zone
    Then Verify Zone has deleted