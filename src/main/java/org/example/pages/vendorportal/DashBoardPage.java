package org.example.pages.vendorportal;

import org.example.pages.AbstaractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashBoardPage extends AbstaractPage {

    private static final Logger log= LoggerFactory.getLogger(DashBoardPage.class);

    @FindBy(id="monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id="annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id="profit-margin")
    private WebElement profitMarginElement;


    @FindBy(id="available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(css="#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id="dataTable_info")
    private WebElement searchResultsCountElement;


    @FindBy(css="img.img-profile")
    private WebElement userProfilePictureElement;


    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css="#logoutModal a")
    private WebElement modalLogoutButton;
    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.monthlyEarningElement));
        return this.monthlyEarningElement.isDisplayed();
    }

    public String getMonthlyEarnings()
    {
        return this.monthlyEarningElement.getText();
    }

    public String getAnnualEarning()
    {
        return this.annualEarningElement.getText();
    }

    public String getProfitMargin()
    {
        return this.profitMarginElement.getText();
    }

    public String getAvailableInventory()
    {
        return this.availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword)
    {
        this.searchInput.sendKeys(keyword);
    }

    public int getSearchResultCount()
    {
      String resultsText=this.searchResultsCountElement.getText();
      String[] arr=resultsText.split(" ");
      int count= Integer.parseInt(arr[5]);
      log.info("Results Count : {}", count);
      return count;
    }

    public void logout()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.userProfilePictureElement));

        this.userProfilePictureElement.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.logoutLink));
        this.logoutLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.modalLogoutButton));
        this.modalLogoutButton.click();

    }
}
