package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginTest() {
        loginPage.setUserNameInputValue("standard_user");
        loginPage.setPasswordInputValue("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isHeaderContainerDisplayed());
    }

    @Test
    public void negativeLoginTest() {
        loginPage.setUserNameInputValue("");
        loginPage.setPasswordInputValue("secret_sauce");
        loginPage.clickLoginButton();
        String expectedErrorMessageText = "Epic sadface: Username is required";
        Assert.assertTrue(loginPage.isErrorMessageContainerDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessageText);
    }
}
