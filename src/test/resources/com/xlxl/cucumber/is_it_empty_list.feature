Feature: Is it empty list?
  Everybody wants to know if the list is empty

  Scenario Outline: Not empty
    Given A is a list with <val> elements
    When I ask whether it's an empty list
    Then I should be told "<answer>"

    Examples:
      | val | answer |
      | 1   | Nope   |
      | 0   | Yep    |
      | 100 | Nope   |
