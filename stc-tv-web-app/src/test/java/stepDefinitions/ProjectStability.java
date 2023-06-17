package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ProjectStability {

    @Given("initialize the project")
    public void initializeTheProject() {
    }

    @Then("close the project")
    public void closeTheWebPage() {
//        context.getWebDriverManager().closeDriver();
    }
}