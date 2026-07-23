@GoodsPlyRegression @Bins
Feature: Bins Management

  Background: Login into GoodsPly and navigate to Bins page
    Given User login into GoodsPly
    And User open Bins page

  @Bins01
  Scenario: Create new bin and verify Search
    Given User Add new Bin
      | BinCode       | BinType | Aisle | Rack | Shelf | Lever | Status    | Capacity | Pickable | Receivable |
      | Auto_BinCode_ | Floor   | AS001 | R001 | S001  | 5     | Available | 123      | Yes      | Yes        |
    Then Verify newly created Bin
      | Location          | Type  | Status    | Capacity | Pickable | Receivable |
      | AS001-R001-S001-5 | floor | available | 123.00   | Yes      | Yes        |
    When User search with Bin Name
    Then Verify search results with searched Bin Codes
    When User search with Zone
    Then Verify search results with searched Zone
    When User search with Type
    Then Verify search results with searched Type
    When User search with Status
    Then Verify search results with searched Status
    When User Edit new Bin
      | BinCode            | BinType | Aisle | Rack | Shelf | Lever | Status  | Capacity | Pickable | Receivable |
      | Auto_BinCode_Edit_ | Bulk    | AS002 | R002 | S002  | 10    | Blocked | 567      | No       | No         |
    Then Verify newly created Bin
      | Location           | Type | Status  | Capacity | Pickable | Receivable |
      | AS002-R002-S002-10 | bulk | blocked | 567.00   | No       | No         |