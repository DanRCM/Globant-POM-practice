package com.globant.web.test.util;
import org. testng.annotations.DataProvider;
public class DataProviderTest {
        @DataProvider(name = "LoginDataProvider")
        public Object [][] getDatalogIn() { return new Object[][]{{"standard_user", "secret_sauce"} }; }

        @DataProvider(name = "PurchaseDataProvider")
        public Object[][] getDataPurchase(){
            return new Object[][] {{"Dan", "Cortez", "2918222", "Checkout: Complete!"} };
        }
}
