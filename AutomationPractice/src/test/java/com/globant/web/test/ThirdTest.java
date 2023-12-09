package com.globant.web.test;

import com.globant.web.pages.LoginPage;
import com.globant.web.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThirdTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
    }

    @Test
    public void LoginPage() {
        ProductPage productPage = loginPage.getProductPage("standard_user", "secret_sauce");
        productPage.clickOnMenu();
        LoginPage loginPage1 = productPage.clickLogout();
        Assert.assertEquals(loginPage1.comprobateLogin(), "Swag Labs");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
