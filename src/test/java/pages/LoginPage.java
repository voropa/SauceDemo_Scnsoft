package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessageContainer = By.cssSelector("div.error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public boolean isErrorMessageContainerDisplayed() {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessageContainer).getText();
    }

    public void login(String userName, String password) {
        setUserNameInputValue(userName);
        setPasswordInputValue(password);
        clickLoginButton();
    }

    public void setUserNameInputValue(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPasswordInputValue(String passwordInputValue) {
        driver.findElement(passwordInput).sendKeys(passwordInputValue);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
