package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CountryPopup;
import pageObjects.PlansPage;

public class PageObjectManager {
    private WebDriver driver;
    private PlansPage plansPage;
    private CountryPopup countryPopup;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public PlansPage getPlansPage() {
        return (plansPage == null) ? plansPage = new PlansPage(driver) : plansPage;
    }

    public CountryPopup getCountryPage() {
        return (countryPopup == null) ? countryPopup = new CountryPopup(driver) : countryPopup;
    }
}
