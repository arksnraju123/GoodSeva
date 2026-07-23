@GoodsPlyRegression @PublishTrip
Feature: Publish your available capacity, routes, and schedules to reduce empty miles

  Background: Login into GoodsPly and navigate to Publish Trip Hub page
    Given User login into GoodsPly
    And User open Publish Trip page

  @PublishTrip01
  Scenario: Publish FTL - Full Truck Load Trip
    When User click on each link and validate navigation in Velocity Hub