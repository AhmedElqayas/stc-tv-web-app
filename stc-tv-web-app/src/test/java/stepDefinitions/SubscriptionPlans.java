package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.PlansPage;

public class SubscriptionPlans {
    TestContext context;
    PlansPage plansPage;

    public SubscriptionPlans(TestContext context) {
        this.context = context;
        plansPage = context.getPageObjectManager().getPlansPage();
    }

    @Given("user is on plans page")
    public void userIsOnPlansPage() {
        plansPage.checkPlansPageIsDisplayed();
    }

    @Then("each plan should have the correct details for the corresponding country")
    public void validatePlans() {
        plansPage.validateSubscriptionPlansForEachCountry(FileReaderManager.getInstance().getJsonReader().getSubscriptionPlans());
    }
}
