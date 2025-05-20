package org.example.pages.flightreservation;

import org.example.pages.AbstaractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstaractPage {

    @FindBy(id="go-to-flights-search")
    private WebElement goToFlightSearchButton;

    @FindBy(css="#registration-confirmation-section p b")
    private WebElement firstNameElement;

    public RegistrationConfirmationPage (WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightSearchButton));
        return this.goToFlightSearchButton.isDisplayed();
    }

    public String getFirstName ()
    {
        return this.firstNameElement.getText();
    }
    public void goToFlightSearchButton()
    {
        this.goToFlightSearchButton.click();
    }
}
