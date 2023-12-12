package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement btnCart;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElement btnCart2;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement btnCart3;

    @FindBy(className = "shopping_cart_link")
    private WebElement btnShop;

    @FindBy(id="react-burger-menu-btn")
    private WebElement btnmenu;

    @FindBy(id="logout_sidebar_link")
    private WebElement btnLogout;

    public void selectProduct(){
        btnCart.click();
    }
    public YourCartPage addProduct(){
        selectProduct();
        btnShop.click();
        return new YourCartPage(super.getDriver());
    }

    public void clickOnMenu(){
        btnmenu.click();
    }

    public LoginPage clickLogout(){
        btnLogout.click();
        return new LoginPage(super.getDriver(), "https://www.saucedemo.com/");
    }

    public  YourCartPage addThreeProducts(){
        btnCart.click();
        btnCart2.click();
        btnCart3.click();
        btnShop.click();
        return new YourCartPage(super.getDriver());
    }
}
