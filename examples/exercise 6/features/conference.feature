Feature: Conference Session Planner
  In order to attend every Neal Ford presentation at this conference
  As a conference attendee
  I want to manage the list of sessions that I will attend

  Scenario: Add a session to attend
    When I add "Agile Engineering Practices" to my list of sessions to attend
    Then I should see "Agile Engineering Practices" in my list
    And I should have 1 session in my list
 
  Scenario: Remove a session to attend
    Given I add "Agile Engineering Practices" to my list of sessions to attend
    When I remove "Agile Engineering Practices" from my list of sessions to attend
    Then I should have 0 sessions in my list

  Scenario: Remove a session from multiple sessions to attend
    Given I add "Agile Engineering Practices" to my list of sessions to attend
      And I add "Emergent Design" to my list of sessions to attend
      And I add "Implementing Evolutionary Architecture" to my list of sessions to attend
      And I add "Workshop: JRuby in Depth" to my list of sessions to attend
    When I remove "Agile Engineering Practices" from my list of sessions to attend
    Then I should have 3 sessions in my list
      And I should see "Emergent Design" in my list
      And I should see "Implementing Evolutionary Architecture" in my list
      And I should see "Workshop: JRuby in Depth" in my list
      But I should not see "Agile Engineering Practices" in my list

  Scenario: Remove a session from multiple sessions to attend (using tables)
    Given I add the following sessions to my list of sessions to attend:
      | Name                                    |
      | Agile Engineering Practices             |
      | Emergent Design                         |
      | Implementing Evolutionary Architecture  |
      | Workshop: JRuby in Depth                |
    When I remove "Agile Engineering Practices" from my list of sessions to attend
    Then I should have 3 sessions in my list
        And I should see the following sessions in my list:
          | Name                                    |
          | Emergent Design                         |
          | Implementing Evolutionary Architecture  |
          | Workshop: JRuby in Depth                |

