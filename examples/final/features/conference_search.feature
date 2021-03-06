Feature: Conference Session Planner
  In order to attend every Neal Ford presentation at this conference
  As a conference attendee
  I want to be able to search my list of favorite sessions
  
  Background:
     Given I add the following to my list of favorite sessions:
      | Name                                    | Presenter     | Day       | Time      | Room              |
      | Visualizations for Code Metrics         | Neal Ford     | Tue       | 8:30pm    | Windsor           |
      | Implementing Evolutionary Architecture  | Neal Ford     | Wed       | 9:00am    | Westminster 1     |
      | Agile Engineering Practices             | Neal Ford     | Wed       | 11:00am   | Westminster 1     |
      | Emergent Design                         | Neal Ford     | Wed       | 1:30pm    | Standley I        |
      | JRuby for the win                       | Ola Bini      | Wed       | 1:30pm    | Cotton Creek I    |
      | Workshop: JRuby in Depth                | Neal Ford     | Wed       | 3:15pm    | Cotton Creek I    |
      | Workshop: JRuby in Depth                | Neal Ford     | Wed       | 5:00pm    | Cotton Creek I    |
      | Workshop: ATDD/BDD with Cucumber        | Paul Rayner   | Thu       | 1:30pm    | Cotton Creek I    |

  Scenario: Manage session details
    Then I should have 8 sessions in my favorites
        And I should see the following sessions in my favorites:
        | Name                                    |
        | Visualizations for Code Metrics         |
        | Implementing Evolutionary Architecture  |
        | Agile Engineering Practices             |
        | Emergent Design                         |
        | JRuby for the win                       |
        | Workshop: JRuby in Depth                |
        | Workshop: JRuby in Depth                |
        | Workshop: ATDD/BDD with Cucumber        |

  Scenario: Search for session by presenter and day
    When I search for sessions by Ola Bini on Wed
    Then I should see the following sessions in the search results:
        | Name              |
        | JRuby for the win |

  Scenario: Search for session by day and time
    When I search for sessions at 1:30pm on Wed
    Then I should see the following sessions in the search results:
        | Name              |
        | Emergent Design   |
        | JRuby for the win |
        
  @wip
  Scenario Outline: Search for matching sessions by time and day
    When I search for sessions at <Time> on <Day> 
    Then I should see <Session> in the search results
          
        Examples:
        
            | Day   | Time      | Session                           |
            | Tue   | 8:30pm    | Visualizations for Code Metrics   |
            | Wed   | 11:00am   | Agile Engineering Practices       |
            | Wed   | 1:30pm    | Emergent Design                   |
            | Thu   | 1:30pm    | Workshop: ATDD/BDD with Cucumber  |
