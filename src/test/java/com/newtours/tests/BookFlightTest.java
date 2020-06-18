package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setup(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }
}
