package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CountryPopup;
import pageObjects.SubscriptionPage;

public class PageObjectManager {
    private WebDriver driver;
    private SubscriptionPage subscriptionPage;
    private CountryPopup countryPopup;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public SubscriptionPage getPlansPage() {
        return (subscriptionPage == null) ? subscriptionPage = new SubscriptionPage(driver) : subscriptionPage;
    }

    public CountryPopup getCountryPage() {
        return (countryPopup == null) ? countryPopup = new CountryPopup(driver) : countryPopup;
    }
}
