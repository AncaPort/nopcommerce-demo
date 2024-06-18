package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class RegisterPageTest extends BaseTest {
    RegisterPage registerPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        registerPage = new RegisterPage();
        homePage = new HomePage();
    }

    /**
     * 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
     * Click on Register Link
     * Verify "Register" text
     */

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();     //Click on register link
        String expMsg = "Register";
        String actMsg = registerPage.getRegisterHeading();
        Assert.assertEquals(actMsg, expMsg, "Register page not displayed");     //Verifying navigation of register page
    }


    /**
     * 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
     * Click on Register Link
     * Click on "REGISTER" button
     * Verify the error message "First name is required."
     * Verify the error message "Last name is required."
     * Verify the error message "Email is required."
     * Verify the error message "Password is required."
     * Verify the error message "Password is required."
     */
    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegisterLink();     //Click on register link
        registerPage.clickOnRegisterButton();       //Click on register button
        //Comparing  all the error messages
        Assert.assertEquals(registerPage.getFirstNameError(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameError(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailError(), "Email is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordError(), "Password is required.");
    }

    /**
     * 3. verifyThatUserShouldCreateAccountSuccessfully()
     * Click on Register Link
     * Select gender "Female"
     * Enter firstname
     * Enter lastname
     * Select day
     * Select month
     * Select year
     * Enter email
     * Enter password
     * Enter Confirm Password
     * Click on "REGISTER" button
     * Verify message "Your registration completed"
     */
    @Test(groups = "regression", dataProvider = "registrationData", dataProviderClass = TestData.class)
    public void verifyThatUserShouldCreateAccountSuccessfully(String gender, String fName, String lName, String date, String month, String year, String email, String pwd, String cpwd) {
        homePage.clickOnRegisterLink();         //Click on register link
        registerPage.registerToApp(gender, fName, lName, date, month, year, email, pwd, cpwd);      //Enter register data
        Assert.assertEquals(registerPage.getRegistrationSuccessMsg(), "Your registration completed");        //Comparing message
    }
}

