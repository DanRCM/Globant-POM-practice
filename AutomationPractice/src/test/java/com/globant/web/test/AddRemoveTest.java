package com.globant.web.test;

import com.globant.web.test.util.BaseTest;
import com.globant.web.test.util.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveTest extends BaseTest {

    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderTest.class)
    public void test2(String user, String psw) {
        loginPage.enterLoginPage(user,psw);
        productPage.addThreeProducts();
        yourCartPage.removeThreeElements();
        Assert.assertEquals(yourCartPage.comprobateShoopingCart(),"");
    }

}
