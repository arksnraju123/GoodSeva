@GoodsPlyRegression @Bins
Feature: Bins Management

  Background: Login into GoodsPly and navigate to Bins page
    Given User login into GoodsPly
    And User open Bins page

  @Bins01
  Scenario: Create, Update and Delete Bin and verify Search
    Given User Add new Bin
      | BinCode       | BinType | Aisle | Rack | Shelf | Lever | Status    | Capacity | Pickable | Receivable |
      | Auto_BinCode_ | Floor   | AS001 | R001 | S001  | 5     | Available | 123      | Yes      | Yes        |
    Then Verify newly created Bin
      | Location          | Type  | Status    | Capacity | Pickable | Receivable |
      | AS001-R001-S001-5 | floor | available | 123.00   | Yes      | Yes        |
    When User search with Bin Name
    Then Verify search results with searched Bin Codes
    When User reset Bins search
    And User search with Zone
    Then Verify search results with searched Zone
    When User reset Zones search
    And User search with Type
    Then Verify search results with searched Type
    When User reset Type search
    And User search with Status
    Then Verify search results with searched Status
    When User reset Status search
    When User Edit new Bin
      | BinCode            | BinType | Aisle | Rack | Shelf | Lever | Status  | Capacity | Pickable | Receivable |
      | Auto_BinCode_Edit_ | Bulk    | AS002 | R002 | S002  | 10    | Blocked | 567      | No       | No         |
    Then Verify newly edited Bin
      | Location           | Type | Status  | Capacity | Pickable | Receivable |
      | AS002-R002-S002-10 | bulk | blocked | 567.00   | No       | No         |
    When User click on Delete
    Then Verify Bin has deleted

  @Bins02
  Scenario: Search Invalid Bin
    When User search for invalid Bin
    Then Verify No bins found in table
    And Verify No bins yet — use "Add Bin" above to create one

  @Bins03
  Scenario: Verify Print PDF file
    Given User Add new Bin
      | BinCode       | BinType | Aisle | Rack | Shelf | Lever | Status    | Capacity | Pickable | Receivable |
      | Auto_BinCode_ | Bulk    | AS001 | R001 | S001  | 5     | Available | 130      | Yes      | Yes        |
    And User click on Print button
    Then Verify downloaded PDF file
      | BinCode      | Zone         | Facility   | Type | Capacity  | Status    |
      | AutoVerified | AutoVerified | AutoVerify | Bulk | 130.00 kg | AVAILABLE |
