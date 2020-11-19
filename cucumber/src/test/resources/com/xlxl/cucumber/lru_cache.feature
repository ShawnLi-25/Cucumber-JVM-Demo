@lru
Feature: Verify the correctness of LRU cache implementation
  We need to make sure every public API is correct

  Background:
    Given I have a LRU cache with capacity 3
    And I put an entry with key 1 and value 1
    And I put an entry with key 2 and value 2

  Scenario:
    When I put an entry with key 1 and value 2
    Then the cache will have 2 entries
    And I should get 2 with key 1
    And I should get 2 with key 2

  Scenario:
    When I put an entry with key 3 and value 3
    Then the cache will have 3 entries
    And the head of the cache will be 3
    And the tail of the cache will be 1

  Scenario:
    When I put an entry with key 3 and value 3
    And I put an entry with key 4 and value 4
    Then I should not get entry with key 1
