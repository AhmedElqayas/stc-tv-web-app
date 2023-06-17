package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CountryPopup {

    public CountryPopup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "sa")
    private WebElement ksa;

    @FindBy(how = How.ID, using = "kw")
    private WebElement kuwait;

    @FindBy(how = How.ID, using = "bh")
    private WebElement bahrain;

    @FindBy(how = How.ID, using = "country-poppup-close")
    private WebElement countryPopupCloseButton;

    public void switchToCountry(String country) {
        switch (country) {
            case "KSA":
                ksa.click();
                break;
            case "Kuwait":
                kuwait.click();
                break;
            case "Bahrain":
                bahrain.click();
                break;
        }
        countryPopupCloseButton.click();
    }


}
