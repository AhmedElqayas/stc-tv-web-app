package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.FileReaderManager;


public class ProjectStability {
    TestContext context;

    public ProjectStability(TestContext context) {
        this.context = context;
    }

    @Given("user is on stc tv home page")
    public void userIsOnStcTvHomePage() {
        context.getWebDriverManager().getDriver();
    }

    @Then("close the web page")
    public void closeTheWebPage() {
        context.getWebDriverManager().closeDriver();
    }
}