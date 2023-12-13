package com.globant.web.test;

import com.globant.web.pages.*;
import com.globant.web.test.util.DataProviderTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PurchaseTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;
    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
    }
    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderTest.class)
    public void LoginPage(String user, String psw) {
        ProductPage productPage = loginPage.getProductPage(user, psw);
        YourCartPage yourCartPage = productPage.addProduct();
        yourCartPage.clickOncheckout();
    }
    @Test(dataProvider = "PurchaseDataProvider", dataProviderClass = DataProviderTest.class)
    public void Test1(String name, String lastName, String postalIC, String expected){
        InformationPage informationPage = new InformationPage(driver);
        OverViewPage overViewPage = informationPage.getOverViewPage(name, lastName, postalIC);
        FinishPage finishPage = overViewPage.getFinishPage();
        Assert.assertEquals(finishPage.getText(), expected);
    }
    @AfterTest
    public void close(){
        driver.close();
    }
}