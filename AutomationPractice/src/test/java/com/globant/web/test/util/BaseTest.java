package com.globant.web.test.util;

import com.globant.web.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver = new ChromeDriver();
    public LoginPage loginPage;
    public ProductPage productPage;
    public InformationPage informationPage;
    public YourCartPage yourCartPage;
    public FinishPage finishPage;
    public OverViewPage overViewPage;
    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
        productPage= new ProductPage(driver);
        informationPage = new InformationPage(driver);
        yourCartPage = new YourCartPage(driver);
        finishPage = new FinishPage(driver);
        overViewPage = new OverViewPage(driver);
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
