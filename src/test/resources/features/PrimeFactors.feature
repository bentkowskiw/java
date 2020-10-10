Feature: Prime factors of a Big Number
  The program finds all the prime factors of a given number.

  Scenario: Finding prime factors of Number
    Given Random generated <Number>
    When The number is split into <prime factors>
    Then The <prime factors> multiplied must equal <Number>
