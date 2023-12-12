package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{
    public YourCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="checkout")
    private WebElement btnCheckout;

    @FindBy(id= "remove-sauce-labs-backpack")
    private WebElement btnRemove1;

    @FindBy(id= "remove-sauce-labs-bike-light")
    private WebElement btnRemove2;

    @FindBy(id= "remove-sauce-labs-bolt-t-shirt")
    private WebElement btnRemove3;

    @FindBy(className = "shopping_cart_link")
    private WebElement shopping;

    public void clickOncheckout(){
        btnCheckout.click();
    }

    public void removeThreeElements(){
        btnRemove1.click();
        btnRemove2.click();
        btnRemove3.click();
    }

    public String comprobateShoopingCart(){
        return shopping.getText();
    }
}
