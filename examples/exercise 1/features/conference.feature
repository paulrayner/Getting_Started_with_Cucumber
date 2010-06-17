Feature: Conference Session Planner
    In order to attend every Neal Ford presentation at this conference
    As a conference attendee
    I want to manage the list of sessions that I will attend

    Scenario: Add a session to attend
        When I add "Agile Engineering Practices" to my list of sessions to attend
        Then I should see "Agile Engineering Practices" in my list
