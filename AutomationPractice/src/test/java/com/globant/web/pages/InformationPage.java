package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationPage extends BasePage{
    public InformationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="first-name")
    private WebElement fName;

    @FindBy(id="last-name")
    private WebElement lName;

    @FindBy(id="postal-code")
    private WebElement pCode;

    @FindBy(id="continue")
    private WebElement btnContinue;

    public OverViewPage getOverViewPage(String first, String last, String postalC){
        fName.sendKeys(first);
        lName.sendKeys(last);
        pCode.sendKeys(postalC);
        btnContinue.click();
        return new OverViewPage(super.driver);
    }
}
