package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Subscription;

import java.util.List;

public class SubscriptionPage {
    private CountryPopup countryPopup;

    public SubscriptionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        countryPopup = new CountryPopup(driver);
    }

    @FindBy(how = How.XPATH, using = "//*/h2[@class='mobile-hidden']")
    private WebElement plansPageHeading;

    @FindBy(how = How.CLASS_NAME, using = "country-current")
    private WebElement countryButton;

    @FindBy(how = How.ID, using = "name-lite")
    private WebElement litePlanName;

    @FindBy(how = How.ID, using = "name-classic")
    private WebElement classicPlanName;

    @FindBy(how = How.ID, using = "name-premium")
    private WebElement premiumPlanName;

    @FindBy(how = How.ID, using = "currency-lite")
    private WebElement litePlanPrice;

    @FindBy(how = How.ID, using = "currency-classic")
    private WebElement classicPlanPrice;

    @FindBy(how = How.ID, using = "currency-premium")
    private WebElement premiumPlanPrice;

    public void checkPlansPageIsDisplayed() {
        Assert.assertTrue(plansPageHeading.isDisplayed());
    }

    public void validateSubscriptionPlansForEachCountry(List<Subscription> subscriptions) {
        for (Subscription subscription : subscriptions) {
            selectTheCountry(subscription.country);
            validateSubscriptionPlans(subscription.subscriptionPlans);
        }
    }

    private void selectTheCountry(String country) {
        countryButton.click();
        countryPopup.switchToCountry(country);
    }

    private void validateSubscriptionPlans(List<Subscription.SubscriptionPlan> subscriptionPlans) {
        for (Subscription.SubscriptionPlan plan : subscriptionPlans) {
            String planTitle = plan.planTitle;
            switch (planTitle) {
                case "LITE":
                    Assert.assertEquals(planTitle, litePlanName.getText());
                    Assert.assertEquals(plan.planPrice, litePlanPrice.getText());
                    break;
                case "CLASSIC":
                    Assert.assertEquals(planTitle, classicPlanName.getText());
                    Assert.assertEquals(plan.planPrice, classicPlanPrice.getText());
                    break;
                case "PREMIUM":
                    Assert.assertEquals(planTitle, premiumPlanName.getText());
                    Assert.assertEquals(plan.planPrice, premiumPlanPrice.getText());
                    break;
            }
        }
    }


}
