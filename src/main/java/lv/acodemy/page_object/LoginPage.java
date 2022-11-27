package lv.acodemy.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By loginField = By.id("user-name");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//input[contains(@class, 'submit-button')]");

    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void authorize(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
