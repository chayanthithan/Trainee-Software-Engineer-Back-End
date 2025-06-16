package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login{
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Updated locators - use more reliable selectors
    private final By emailField = By.xpath("/html/body/app-root/app-login/div/div/div[3]/form/nz-form-item[1]/nz-form-control/div/div/input");
    private final By passwordField = By.xpath("/html/body/app-root/app-login/div/div/div[3]/form/nz-form-item[2]/nz-form-control/div/div/nz-input-group/input");
    private final By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div[3]/button");
    private final By addStoreHeading = By.id("store");
    private final By addStoreButton = By.xpath("/html/body/div/div[2]/div/nz-modal-container/div/div/div/app-get-started-screen/nz-spin/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div[2]/button");

    public Login(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
    public void clickAddStoreHeading() {
        WebElement addStoreH = wait.until(ExpectedConditions.elementToBeClickable(addStoreHeading));
        addStoreH.click();
    }
    public void clickAddStoreButton() {
        WebElement addStoreBtn = wait.until(ExpectedConditions.elementToBeClickable(addStoreButton));
        addStoreBtn.click();
    }
    public String getAddStoreButtonText() {
        WebElement addStoreBtn = wait.until(ExpectedConditions.elementToBeClickable(addStoreButton));
        return addStoreBtn.getText();
    }
}