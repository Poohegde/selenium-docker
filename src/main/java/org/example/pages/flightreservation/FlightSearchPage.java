package org.example.pages.flightreservation;

import org.example.pages.AbstaractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstaractPage {


    @FindBy(id="passengers")
    private WebElement passengerSelect;

    @FindBy(id="search-flights")
    private WebElement searchFlightsButton;

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengerSelect));
    return this.passengerSelect.isDisplayed();
    }

    public void selectPassangers(String noofPassangers)
    {
        Select passangers = new Select(this.passengerSelect);
        passangers.selectByValue(noofPassangers);
    }
    public void searchFlight()
    {
        this.searchFlightsButton.click();
    }
}
