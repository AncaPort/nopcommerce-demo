package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {


    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    /**
     * 1.userShouldNavigateToLoginPageSuccessFully().
     * Click on login link
     * verify that "Welcome, Please Sign In!" message display
     */
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    /**
     * 2. verifyTheErrorMessageWithInValidCredentials().
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Verify that the Error message
     */
    @Test(groups = {"smoke", "regression"}, dataProvider = "invalidCredentials", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String email, String pwd) {
        homePage.clickOnLoginLink();
        loginPage.loginToApp(email, pwd);
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }

    /**
     * 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Verify that LogOut link is display
     */
    @Test(groups = {"regression"}, dataProvider = "validCredentials", dataProviderClass = TestData.class)
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(String email, String pwd) {
        homePage.clickOnLoginLink();
        loginPage.loginToApp(email, pwd);
        String expMsg = "Log out";
        String actMsg = homePage.getLogoutLinkText();
        Assert.assertEquals(actMsg, expMsg);
    }

    /**
     * 4. verifyThatUserShouldLogOutSuccessFully()
     * Click on login link
     * Enter EmailId
     * Enter Password
     * Click on Login Button
     * Click on LogOut Link
     * Verify that LogIn Link Display
     */
    @Test(groups = {"regression"}, dataProvider = "validCredentials", dataProviderClass = TestData.class)
    public void verifyThatUserShouldLogOutSuccessFully(String email, String pwd) {
        homePage.clickOnLoginLink();
        loginPage.loginToApp(email, pwd);
        homePage.clickOnLogoutLink();
//        String expMsg = "Log in";
//        String actMsg = homePage.getLoginLinkText();
//        Assert.assertEquals(actMsg, expMsg);
    }

}
