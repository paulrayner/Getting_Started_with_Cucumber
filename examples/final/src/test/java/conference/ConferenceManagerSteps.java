package Conference;

import cuke4duke.Table;
import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.annotation.Pending;

import java.util.*;

import static org.junit.Assert.*;

public class ConferenceManagerSteps {

    List<Session> favoriteSessions = new ArrayList<Session>();
    List<Session> sessionSearchResults = new ArrayList<Session>();

    @When ("^I add the following to my list of favorite sessions:$")
    public void iAddTheFollowingSessionsToMyListOffavoriteSessions(cuke4duke.Table table) {
        Iterator<Map<String,String>> iter = table.hashes().iterator();

        while (iter.hasNext())  {
            Map<String,String> item = iter.next();
            String sessionName = item.get("Name");
            String sessionPresenter = item.get("Presenter");
            String sessionDay = item.get("Day");
            String sessionTime = item.get("Time");
            String sessionRoom = item.get("Room");
            favoriteSessions.add(new Session(sessionName, sessionPresenter, sessionDay, sessionTime, sessionRoom));
        }
    }

    @Then ("^I should have (\\d+) sessions?? in my favorites$")
    public void iShouldHaveNSessionsInMyList(int expectedNumberOfSessions ) {
        assertEquals(expectedNumberOfSessions, favoriteSessions.size());
    }    
    
    @Then ("^I should see the following sessions in my favorites:$")
    public void iShouldSeeTheFollowingSessionsInMyList(cuke4duke.Table table) {
        List<List<String>> diffList = new ArrayList<List<String>>();
        diffList.add(Arrays.asList("Name"));    // Add table column heading
        for (Session session : favoriteSessions) {
           diffList.add(Arrays.asList(session.Name));
        }
        table.diffLists(diffList);
    }
    
    @When ("^I search for sessions by (.*?) on (.*)$")
    public void iSearchForSessionsByPresenterAndDay(String presenter, String day) {
        for (Session session : favoriteSessions) {
            if (session.Presenter.equals(presenter)&& session.Day.equals(day)) {
                sessionSearchResults.add(session);
            }
        }
    }

    @When ("^I search for sessions at (.*?) on (.*)$")
    public void iSearchForSessionsByPresenterTimeAndDay(String time, String day) {
        for (Session session : favoriteSessions) {
            if (session.Time.equals(time)&& session.Day.equals(day)) {
                sessionSearchResults.add(session);
            }
        }
    }

    @Then ("^I should see the following sessions in the search results:$")
    public void iShouldSeeTheFollowingSessionsInTheSearchResults(cuke4duke.Table table) {
        List<List<String>> diffList = new ArrayList<List<String>>();
        diffList.add(Arrays.asList("Name"));    // Add table column heading
        for (Session session : sessionSearchResults) {
          diffList.add(Arrays.asList(session.Name));
        }
        table.diffLists(diffList);
    }
    
    
    @Then ("^I should see ([^\"]*) in the search results$")
    public void iShouldSeeTheSessionInMyListOfSessionsToAttend(String expectedSessionName) {
        boolean sessionFound = false;
        for (Session session : sessionSearchResults) {
            if (session.Name.equals(expectedSessionName)) {
                sessionFound = true;
            }
        }
        assertTrue(sessionFound);
    }
 }

 