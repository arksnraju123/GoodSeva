@GoodsPlyRegression @Facilities
Feature: Manage facilities, dock doors, zones, and bins.

  Background: Login into GoodsPly and navigate to Facilities page
    Given User login into GoodsPly
    And User open Facilities page

  @Facilities01
  Scenario: Create facilities Doors, Zones and Bins, Search
    # Added new Facility and Verify
    Given User Add new Facility
      | FacilityName | Address              | HoursStart | HoursEnd | TotalDockDoors |
      | Auto_Fac_    | 123, KPHB, Hyderabad | 09:00 AM   | 06:00 PM | 5              |
    When User search with newly created Facility
    Then Verify bellow facility details
      | FacilityName | Address              | HoursStart | HoursEnd | TotalDockDoors | Status |
      | AutoVerify   | 123, KPHB, Hyderabad | 09:00:00   | 18:00:00 | 5 dock doors   | Active |
    When User click on newly created facility
    # Verify default messages in Dock Door, Zones and Bins tabs
    Then Verify selected facility name
    When User open Dock Door tab
    Then Verify default No dock doors yet message
    When User open Zones tab
    Then Verify default No zones yet message
    When User open Bins tab
    Then Verify default Create a zone first message
    And Verify Add Bin button disabled when no Zones exist
    # Add new Dock Door and Verify
    When User open Dock Door tab
    When User add new Dock Door in facility
      | DoorNumber | DoorType  | MaxHeight | MaxWidth |
      | AutoEnter  | Oversized | 200       | 250      |
    Then Verify Dock Door details in facility
      | DoorNumber | DoorType  | Status    |
      | AutoVerify | Oversized | available |
    # Add new Zones and Verify
    When User open Zones tab
    When User add new Zones in facility
      | ZoneName   | ZoneCode | ZoneType | MaxCapacity | Description             |
      | Auto_Zone_ | 99887    | Shipping | 2000        | Test Zone from Facility |
    Then Verify Zones details in facility
      | ZoneName   | ZoneCode | ZoneType | MaxCapacity | Status |
      | AutoVerify | 99887    | Shipping | 2000        | Active |
    # Add new Bins and Verify
    When User open Bins tab
    When User add new Bins in facility
      | Zone       | BinCode   | BinType | Aisle | Rack |
      | AutoSelect | Auto_Bin_ | Bulk    | AS001 | R001 |
    Then Verify Bin details in facility
      | BinCode    | BinType | Aisle | Rack | Status    |
      | AutoVerify | Bulk    | AS001 | R001 | available |
    And Verify total Doors 1, Zones 1 and Bins 1 from tabs

  @Facilities02
  Scenario: Validate Zones
    # Add new facility
    Given User Add new Facility
      | FacilityName | Address                  | HoursStart | HoursEnd | TotalDockDoors |
      | Auto_Fac_    | 234, Anna Nagar, Chennai | 09:00 AM   | 06:00 PM | 2              |
    When User search with newly created Facility
    And User click on newly created facility
    # Add new Zone
    And User open Zones tab
    And User add new Zones in facility
      | ZoneName   | ZoneCode | ZoneType | MaxCapacity | Description             |
      | Auto_Zone_ | 11223    | Picking  | 3500        | Test Zone from Facility |
    # Verify new Zone in Zones page
    And User open Zones page
    And User search for Zone
    Then Verify newly created Zone details
      | Facility   | ZoneName   | ZoneCode   | ZoneType | Temperature | MaximumCapacity | Status |
      | AutoVerify | AutoVerify | AutoVerify | Picking  | -           | 3500            | Active |
    # Edit Zone from Zones page
    When User click on edit Zone
    When User update Zone with bellow data
      | Facility | ZoneName               | ZoneCode | ZoneType | Temperature | MaximumCapacity | Status   |
      | _IGNORE_ | Auto_Zone_Update_Name_ | 11225    | Storage  | _IGNORE_    | 200             | Inactive |
    # Verify Edited zone in facilities page
    And User open Facilities page
    When User search with newly created Facility
    When User click on newly created facility
    When User open Zones tab
    Then Verify Zones details in facility
      | ZoneName   | ZoneCode | ZoneType | MaxCapacity | Status   |
      | AutoVerify | 11225    | Storage  | 200         | Inactive |
    # Delete Zone in Facilities
    When User delete the Zone in facility
    And User open Zones page
    # Verify Zone deleted in Zones page
    Then Verify Zone has deleted
    When User click on Add Zone button
    # Create new Zone in Zones page
    When User create new Zone with bellow data
      | Facility   | ZoneName        | ZoneCode        | ZoneType | Temperature | MaximumCapacity | Status |
      | AutoSelect | Auto_Zone_Name_ | AUTO_ZONE_CODE_ | Shipping | Frozen      | 100             | Active |
    # Verify new Zone in Facilities page
    And User open Facilities page
    When User search with newly created Facility
    And User click on newly created facility
    And User open Zones tab
    Then Verify Zones details in facility
      | ZoneName   | ZoneCode   | ZoneType | MaxCapacity | Status |
      | AutoVerify | AutoVerify | Shipping | 100         | Active |
    # Delete Zone in Zones page
    And User open Zones page
    And User search for Zone
    When User Delete Zone
    And User open Facilities page
    When User search with newly created Facility
    And User click on newly created facility
    And User open Zones tab
    # Verify deleted Zone in Facilities page
    Then Verify Zone deleted in Facilities

  @Facilities03
  Scenario: Validate Bins
    Given User Add new Facility
      | FacilityName | Address                  | HoursStart | HoursEnd | TotalDockDoors |
      | Auto_Fac_    | 333, Ameerpet, Hyderabad | 09:00 AM   | 06:00 PM | 10             |
    When User search with newly created Facility
    And User click on newly created facility
    And User open Zones tab
    And User add new Zones in facility
      | ZoneName       | ZoneCode | ZoneType | MaxCapacity | Description             |
      | Auto_Fac_Zone_ | 3344     | Picking  | 1555        | Test Zone from Facility |
    When User open Bins tab
    When User add new Bins in facility
      | Zone       | BinCode       | BinType | Aisle  | Rack  |
      | AutoSelect | Auto_Fac_Bin_ | Bulk    | AS0001 | R0001 |
    # Verify new Bin in Bins page
    And User open Bins page
    When User search with Bin Name in Bins page
    Then Verify newly created Bin from Facilities
      | BinCode    | Location     | Zone       | Facility   | Type | Status    | Capacity | Pickable | Receivable |
      | AutoVerify | AS0001-R0001 | AutoVerify | AutoVerify | bulk | available | No limit | Yes      | Yes        |
    # Edit Bind in Bins page and Verify
    When User Edit new Bin
      | BinCode            | BinType | Aisle  | Rack  | Shelf | Level | Status  | Capacity | Pickable | Receivable |
      | Auto_BinCode_Edit_ | Pallet  | AS0002 | R0002 | S0002 | 10    | Blocked | 111      | No       | No         |
    And User open Facilities page
    When User search with newly created Facility
    And User click on newly created facility
    And User open Bins tab
    Then Verify Bin details in facility
      | BinCode    | BinType | Aisle  | Rack  | Status  |
      | AutoVerify | Pallet  | AS0002 | R0002 | blocked |
    When User delete the Bin in facility
    And User open Bins page
    # Verify Bin deleted in Bins page
    Then Verify Bin has deleted in Bins page
    # Create new Bin in Bins page
    When User Add new Bin
      | BinCode       | BinType | Aisle | Rack | Shelf | Level | Status    | Capacity | Pickable | Receivable |
      | Auto_BinCode_ | Floor   | AS001 | R001 | S001  | 5     | Available | 123      | Yes      | Yes        |
    # Verify new Zone in Facilities page
    And User open Facilities page
    When User search with newly created Facility
    And User click on newly created facility
    And User open Bins tab
    Then Verify Bin details in facility
      | BinCode    | BinType | Aisle | Rack | Status    |
      | AutoVerify | Floor   | AS001 | R001 | available |
    # Delete Bin in Bins page
    And User open Bins page
    And User search with Bin Name in Bins page
    And User delete Bin in Bins page
    And User open Facilities page
    When User search with newly created Facility
    And User click on newly created facility
    And User open Bins tab
    # Verify deleted Bin in Facilities page
    Then Verify Bin deleted in Facilities

  @Facilities04
  Scenario: Verify pagination
    Then Verify Previous button disabled by default in Facilities page
    When User click on Next button in Facilities page
    Then Verify page navigated to page 2 in Facilities page
    When User click on Previous button in Facilities page
    Then Verify page navigated to page 1 in Facilities page