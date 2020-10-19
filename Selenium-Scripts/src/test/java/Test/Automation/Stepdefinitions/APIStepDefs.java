package Test.Automation.Stepdefinitions;

import Test.Automation.Utils.PropertyReader;
import Test.Automation.Utils.REST_GET_Action;
import cucumber.api.java.en.Given;

public class APIStepDefs {


    @Given("^I should see response code \"([^\"]*)\" for the requested API \"([^\"]*)\"$")
    public void i_should_see_response_code_for_the_requested_API(String http_code, String Endpoint) throws Throwable {

        String url = (new PropertyReader().readProperty(Endpoint));
        System.out.println(url);
        REST_GET_Action.GETRequest(url);
        REST_GET_Action.getStatusCode(http_code);
    }
}
