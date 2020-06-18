package com.searchmodule.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    @FindBy(xpath = ".//*[@data-zci-link=\"videos\"]")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(this.driver, this);
    }

    public void goTo(){
        driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword){
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void goToVideos(){
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int  getResult() {
        By by = By.className("tile--vid");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return allVideos.size();
    }
}
