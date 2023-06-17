package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.FileReaderManager;
import pageObjects.SubscriptionPage;
import testDataTypes.Subscription;

import java.util.List;

public class SubscriptionPlans {
    TestContext context;
    SubscriptionPage subscriptionPage;

    public SubscriptionPlans(TestContext context) {
        this.context = context;
        subscriptionPage = context.getPageObjectManager().getPlansPage();
    }

    @Given("user is on subscription page")
    public void userIsOnPlansPage() {
        subscriptionPage.checkPlansPageIsDisplayed();
    }

    @Then("each plan should have the correct details for the corresponding country")
    public void validatePlans() {
        List<Subscription> subscriptions = FileReaderManager.getInstance().getJsonReader().getSubscriptionPlans();
        subscriptionPage.validateSubscriptionPlansForEachCountry(subscriptions);
    }
}
