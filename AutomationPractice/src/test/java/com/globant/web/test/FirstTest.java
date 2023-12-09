package com.globant.web.test;

import com.globant.web.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
    }

    @Test
    public void LoginPage() {
        ProductPage productPage = loginPage.getProductPage("standard_user", "secret_sauce");

        YourCartPage yourCartPage = productPage.addProduct();

        InformationPage informationPage = yourCartPage.clickOncheckout();

        OverViewPage overViewPage = informationPage.getOverViewPage("Daniel", "Cortez", "90023");

        FinishPage finishPage = overViewPage.getFinishPage();

        Assert.assertEquals(finishPage.getText(), "Checkout: Complete!");

    }
    @AfterTest
    public void close(){
        driver.close();
    }
}