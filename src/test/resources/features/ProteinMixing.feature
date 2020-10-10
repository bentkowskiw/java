Feature: This Test does N mixing steps of proteins
  The mixing algorithm is a XOR operation
  Scenario: Comparing the given string of proteins with the outcome after N cycles
    Given The protein pattern table
    |CAABDEEAAABBBCDE|
    |AAAAADDDEEEBBCAA|
    |ABCDDCAEACCEEBBA|
    |DDEECCCAABBCCCAA|
    When number of cycles is
    |1|2|3|4|5|6|7|8|
    Then The output pattern table should be
    
