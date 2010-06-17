package Conference;

import cuke4duke.Table;
import cuke4duke.annotation.I18n.EN.Given;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import cuke4duke.annotation.Pending;

import java.util.*;

import static org.junit.Assert.*;

public class ConferenceSteps {

    List<String> sessionsToAttend = new ArrayList<String>();

    @When ("^I add \"([^\"]*)\" to my list of sessions to attend$")
    public void iAddASessionToMyListOfSessionsToAttend(String sessionName) {
        sessionsToAttend.add(sessionName);
    }

    @Then ("^I should see \"([^\"]*)\" in my list$")
    public void iShouldSeeTheSessionInMyListOfSessionsToAttend(String expectedSessionName) {
        assertTrue(sessionsToAttend.contains(expectedSessionName));
    }
    
    @Then ("^I should have (\\d+) sessions?? in my list$")
    public void iShouldHaveNSessionsInMyList(int expectedNumberOfSessions ) {
        assertEquals(expectedNumberOfSessions, sessionsToAttend.size());
    }
    
    @When ("^I remove \"([^\"]*)\" from my list of sessions to attend$")
    public void iRemoveASessionFromMyListOfSessionsToAttend(String sessionName) {
        sessionsToAttend.remove(sessionsToAttend.indexOf(sessionName));
    }
    
     @Then ("^I should not see \"([^\"]*)\" in my list$")
     public void iShouldNotSeeThisSessionInMyList(String expectedSessionName) {
        assertFalse(sessionsToAttend.contains(expectedSessionName));
     }
    
    @When ("^I add the following sessions to my list of sessions to attend:$")
    public void iAddTheFollowingSessionsToMyListOfSessionsToAttend(cuke4duke.Table table) {
        Iterator<Map<String,String>> iter = table.hashes().iterator();

        while (iter.hasNext())  {
            Map<String,String> item = iter.next();
            String sessionName = item.get("Name");
            sessionsToAttend.add(sessionName);            
        }
    }

    @Then ("^I should see the following sessions in my list:$")
    public void iShouldSeeTheFollowingSessionsInMyList(cuke4duke.Table table) {
        List<List<String>> diffList = new ArrayList<List<String>>();
        diffList.add(Arrays.asList("Name"));    // Add table column heading
        for (String sessionName : sessionsToAttend) {
           diffList.add(Arrays.asList(sessionName));
        }
        table.diffLists(diffList);
    }
 }
