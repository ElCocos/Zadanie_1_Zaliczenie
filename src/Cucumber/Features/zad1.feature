Feature: Zad1

  Scenario Outline: user create new shipping address


    Given open browser
    When user log-in
    And create new address and input <address>, <city>, <postalCode>, <phone>


    Examples:
      |address          |city    |postalCode |phone    |
      |Zlota 14 |Warszawa|01-123    |123456789|
