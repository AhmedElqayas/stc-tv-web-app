package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.Plan;

import java.util.List;

public class PlansPage {
    private CountryPopup countryPopup;

    public PlansPage(WebDriver driver) {
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

    public void validateSubscriptionPlansForEachCountry(List<Plan> plans) {
        for (Plan plan : plans) {
            countryButton.click();
            countryPopup.switchToCountry(plan.country);
            Assert.assertEquals(plan.subscriptionPlans.get(0), litePlanName.getText());
            Assert.assertEquals(plan.subscriptionPlans.get(0), litePlanPrice);

            Assert.assertEquals(plan.subscriptionPlans.get(1), classicPlanName.getText());
            Assert.assertEquals(plan.subscriptionPlans.get(1), classicPlanPrice);

            Assert.assertEquals(plan.subscriptionPlans.get(2), premiumPlanName.getText());
            Assert.assertEquals(plan.subscriptionPlans.get(2), premiumPlanPrice);
        }
    }




}
