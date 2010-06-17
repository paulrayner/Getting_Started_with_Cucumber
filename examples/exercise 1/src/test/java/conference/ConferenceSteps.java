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
}
