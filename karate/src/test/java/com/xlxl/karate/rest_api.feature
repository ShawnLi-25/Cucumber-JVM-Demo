Feature: Test fake online REST APIs
  Karate API test for 'https://jsonplaceholder.typicode.com'

  Background:
    Given url 'https://jsonplaceholder.typicode.com'

  Scenario: Fetch all albums and then verify the 8th has a title
    Given path 'albums'
    When method get
    Then status 200

    * def firstAlbum = response[7]

    Given path 'albums', firstAlbum.id
    When method get
    Then status 200
    And match response contains { title: '#notnull' }

  Scenario: Create a user and then get it by id will return 404
    * def testUser =
      """
      {
        "name": "Test User",
        "username": "testUser",
        "email": "testUser@gmail.com",
      }
      """

    Given path 'users'
    And request testUser
    When method post
    Then status 201

    * def id = response.id
    * print 'The new created user id is: ', id

    Given path 'users', id
     When method get
     Then status 404
     And match response == {}