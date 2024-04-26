@tag1
Feature: Advanced Calculator Operations

  Scenario Outline: Performing arithmetic operations between two numbers
    Given I have a calculator
    And Two input values, <first> and <second>
    When I <opt> the two values
    Then I expect the result <result>

    Examples:
      | first | second | opt | result |
      | 6     | 2      | *   | 12     |
      | 6     | 2      | /   | 3      |
      | 6     | 2      | ^   | 36     |
