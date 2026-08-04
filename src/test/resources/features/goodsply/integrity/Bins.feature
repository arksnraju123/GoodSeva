@GoodsPlyRegression @Bins
Feature: Bins Management

  Background: Login into GoodsPly and navigate to Bins page
    Given User login into GoodsPly
    And User open Bins page

  @Bins01
  Scenario: Create, Update and Delete Bin and verify Search
    Given User Add new Bin
      | BinCode       | BinType | Aisle | Rack | Shelf | Level | Status    | Capacity | Pickable | Receivable |
      | Auto_BinCode_ | Floor   | AS001 | R001 | S001  | 5     | Available | 123      | Yes      | Yes        |
    Then Verify newly created Bin
      | Location          | Type  | Status    | Capacity | Pickable | Receivable |
      | AS001-R001-S001-5 | floor | available | 123.00   | Yes      | Yes        |
    When User search with Bin Name in Bins page
    Then Verify search results with searched Bin Codes in Bins page
    When User reset Bins search in Bins page
    And User search with Zone in Bins page
    Then Verify search results with searched Zone in Bins page
    When User reset Zones search in Bins page
    And User search with Type in Bins page
    Then Verify search results with searched Type in Bins page
    When User reset Type search in Bins page
    And User search with Status in Bins page
    Then Verify search results with searched Status in Bins page
    When User reset Status search in Bins page
    When User Edit new Bin
      | BinCode            | BinType | Aisle | Rack | Shelf | Level | Status  | Capacity | Pickable | Receivable |
      | Auto_BinCode_Edit_ | Bulk    | AS002 | R002 | S002  | 10    | Blocked | 567      | No       | No         |
    Then Verify newly edited Bin
      | Location           | Type | Status  | Capacity | Pickable | Receivable |
      | AS002-R002-S002-10 | bulk | blocked | 567.00   | No       | No         |
    Then Verify all edited fields in edit Bin page
      | BinCode      | BinType | Aisle | Rack | Shelf | Level | Status  | Capacity | Pickable | Receivable |
      | AutoVerified | Bulk    | AS002 | R002 | S002  | 10    | Blocked | 567      | No       | No         |
    When User delete Bin in Bins page
    Then Verify Bin has deleted in Bins page

  @Bins02
  Scenario: Search Invalid Bin
    When User search for invalid Bin
    Then Verify No bins found in table
    And Verify No bins yet — use "Add Bin" above to create one

  @Bins03
  Scenario: Verify Print PDF file
    Given User Add new Bin
      | BinCode       | BinType | Aisle | Rack | Shelf | Level | Status    | Capacity | Pickable | Receivable |
      | Auto_BinCode_ | Bulk    | AS001 | R001 | S001  | 5     | Available | 130      | Yes      | Yes        |
    And User click on Print button
    Then Verify downloaded PDF file
      | BinCode      | Zone         | Facility   | Type | Capacity  | Status    |
      | AutoVerified | AutoVerified | AutoVerify | Bulk | 130.00 kg | AVAILABLE |

  @Bins04
  Scenario: Verify pagination
    Then Verify Previous button disabled by default in Bins page
    When User click on Next button in Bins page
    Then Verify page navigated to page 2 in Bins page
    When User click on Previous button in Bins page
    Then Verify page navigated to page 1 in Bins page
