@GoodsPlyRegression
Feature: Manage dock appointments and scheduling

  Background: Login into GoodsPly and navigate to Appointments page
    Given User login into GoodsPly
    And User open Appointments page

  @Appointments01
  Scenario: Create new Appointment Scheduling
    Given User click on New Appointment button
    Then Verify Book Appointment page has opened
    When User enter basic info
      | Facility                     | Carrier           | BookedBy    |
      | Bangalore Tech Hub Warehouse | Blue Dart Express | Transporter |
    And User enter schedule details
    And User enter Load Information
      | LoadType            | EstimatedDuration |
      | Outbound (Shipping) | 90                |
    And User book appointment
    Then Verify Scheduled status
    And Verify Mark Arrived button
    When User click on Mark Arrived button in appointments scheduling page
    Then Verify Arrived status
    And Verify Start Loading button
    When User click on Start Loading button in appointments scheduling page
    Then Verify Loading status
    And Verify Mark Departed button
    When User click on Mark Departed button in appointments scheduling page
    Then Verify Departed status