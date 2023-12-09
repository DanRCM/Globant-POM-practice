package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverViewPage extends BasePage{
    public OverViewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className ="btn_action")
    private WebElement btnFinish;

    public FinishPage getFinishPage(){
        btnFinish.click();
        return new FinishPage(super.driver);
    }
}
