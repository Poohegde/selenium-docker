package com.practice.tests.vendorportal;

import com.practice.tests.AbstractTest;
import com.practice.tests.vendorportal.model.VendorPortalTestData;
import com.practice.util.Config;
import com.practice.util.Constants;
import com.practice.util.JsonUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.vendorportal.DashBoardPage;
import org.example.pages.vendorportal.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {

    private LoginPage loginpage;
    private DashBoardPage dashboardpage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObjects(String testDataPath) throws Exception {
        this.loginpage=new LoginPage(driver);
        this.dashboardpage=new DashBoardPage(driver);
       // this.testData = JsonUtil.getTestData(testDataPath);
        this.testData = JsonUtil.getTestData(testDataPath, VendorPortalTestData.class);

    }

    @Test
    public void loginTest()
    {
       // loginpage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        loginpage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginpage.isAt());
        loginpage.login(testData.username(),testData.password());
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest()
    {
        Assert.assertTrue(dashboardpage.isAt());

        //finance metrics
        Assert.assertEquals(dashboardpage.getMonthlyEarnings(),testData.monthlyEarning());
        Assert.assertEquals(dashboardpage.getAnnualEarning(),testData.annualEarning());
        Assert.assertEquals(dashboardpage.getProfitMargin(),testData.profitMargin());
        Assert.assertEquals(dashboardpage.getAvailableInventory(),testData.availableInventory());



        //order history search
        dashboardpage.searchOrderHistoryBy("adams");
        Assert.assertEquals(dashboardpage.getSearchResultCount(),testData.searchResultsCount());


    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest()
    {
        dashboardpage.logout();
        Assert.assertTrue(loginpage.isAt());

    }


}
