@GoodsPlyRegression @VelocityHub
Feature: One console for all four transport modes. Pick a mode to scope, or jump straight to Fleet Intelligence.

  Background: Login into GoodsPly and navigate to Velocity Hub page
    Given User login into GoodsPly
    And User open Velocity Hub page

  @VelocityHub01
  Scenario: Open each link and validate navigation in Velocity Hub
    When User click on each link and validate navigation in Velocity Hub
      | Link                   | ExpectedPage          |
      | Road                   | tms?tab=dashboard     |
      | Rail                   | yard-rake             |
      | Sea                    | maritime              |
      | Air                    | multimodal            |
      | Live Map               | intelligence/live     |
      | Control Tower          | control-tower         |
      | Resilience Simulator   | twin                  |
      | Dispatch & Routing     | dispatch              |
      | Safety & Anomaly       | safety                |
      | Comms & VoC            | comms                 |
      | Customer 360           | customer-360          |
      | Intralogistics         | intralogistics        |
      | Insights & ESG         | insights              |
      | Book Transport         | book-transport        |
      | Post Truck             | post-truck            |
      | Publish Trip           | publish-trip          |
      | Transport Orders       | orders                |
      | Carriers               | carriers              |
      | Fleet Management       | fleet                 |
      | Rate Calculator        | rates                 |
      | Compliance             | compliance            |
      | Driver App             | driver-mobile         |
      #Mobile Fleet is navigating to different page
      | Mobile Fleet           | fleet                 |
      | Rake Arrival Predictor | yard-rake/predictions |
      | Yard Allocation        | yard-rake/allocation  |
      | Port Congestion        | congestion            |
      | Charter Optimiser      | charters              |
      | Smart Loading Bay      | smart-loading/bay     |
      | Smart Routing          | intelligence/dispatch |
      | Safety & Anomaly AI    | intelligence/safety   |
      | Resilience Simulator   | intelligence/twin     |
      | Rake Arrival Predictor | yard-rake/predictions |