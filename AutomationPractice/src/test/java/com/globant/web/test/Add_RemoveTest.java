package com.globant.web.test;

import com.globant.web.pages.*;
import com.globant.web.test.util.DataProviderTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Add_RemoveTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver, "https://www.saucedemo.com/");
    }

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderTest.class)
    public void test2(String user, String psw) {
        ProductPage productPage = loginPage.getProductPage(user, psw);
        YourCartPage yourCartPage = productPage.addThreeProducts();
        yourCartPage.removeThreeElements();
        Assert.assertEquals(yourCartPage.comprobateShoopingCart(),"");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
