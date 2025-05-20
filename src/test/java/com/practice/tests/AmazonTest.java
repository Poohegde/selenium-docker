package com.practice.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.*;

public class AmazonTest extends base.BaseTest {

        @Test
        public void testAmazonSearchAndAddToCart() {
            driver.get("https://www.amazon.com/");

            pages.HomePage homePage = new pages.HomePage(driver);
            homePage.searchProduct("Laptop");

            pages.SearchResultsPage searchResultsPage = new pages.SearchResultsPage(driver);
            searchResultsPage.clickFirstProduct();

            pages.ProductPage productPage = new pages.ProductPage(driver);
            productPage.addToCart();

            pages.CartPage cartPage = new pages.CartPage(driver);
            Assert.assertTrue(cartPage.isProductAddedToCart(), "Product was not added to the cart!");

            System.out.println("✅ Product successfully added to cart!");
        }
    }



