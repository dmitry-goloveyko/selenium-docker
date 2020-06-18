package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitButton;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitButton;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(this.driver, this);
    }

    public void submitFindFlightPage(){
        wait.until(ExpectedConditions.elementToBeClickable(firstSubmitButton));
        firstSubmitButton.click();
    }

    public void goToFlightConfirmationPage(){
        wait.until(ExpectedConditions.elementToBeClickable(secondSubmitButton));
        secondSubmitButton.click();
    }
}
