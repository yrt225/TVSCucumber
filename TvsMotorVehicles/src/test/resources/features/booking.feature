@Booking
Feature: Booking a TVS Vehicle

  @BookingTVSJupiter
  Scenario Outline: User books TVS Vehicle.
    Given User navigates to the Booking Page
    When user selects the vehicle "<ModelName>"
    And user selects vehicle model "<ModelType>"
    And user enters personal Details for "<UserName>", "<DealerName>" and "<OTP>"
    Then user gets booking successful message

    Examples: 
      | ModelName     | ModelType | UserName    | DealerName | OTP  |
      | TVS Jupiter   | DRUM SXC  | RegularUser | Bommanahalli  | 1234 |
      | TVS NTORQ 125 | DISC SXC  | GuestUser   | Indranagar    | 1234 |
      
       @BookingTVSJupiter2
  Scenario Outline: User books TVS Vehicle.
    Given User navigates to the Booking Page
