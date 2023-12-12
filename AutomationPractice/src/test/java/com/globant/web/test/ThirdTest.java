package com.globant.web.test;

import com.globant.web.pages.LoginPage;
import com.globant.web.pages.ProductPage;
import com.globant.web.test.util.DataProviderTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderTest.class)
    public void test3(String user, String psw) {
        ProductPage productPage = loginPage.getProductPage(user, psw);
        productPage.clickOnMenu();
        LoginPage loginPage1 = productPage.clickLogout();
        Assert.assertEquals(loginPage1.comprobateLogin(), "Swag Labs");
    }

    @AfterTest
    public void close(){
        driver.close();
    }
}
