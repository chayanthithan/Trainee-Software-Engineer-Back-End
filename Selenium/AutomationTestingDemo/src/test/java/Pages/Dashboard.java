package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By popupTitle = By.xpath("/html/body/div/div[2]/div/nz-modal-container/div/div/div/app-get-started-screen/nz-spin/div/div/div[2]/div[2]/div/div/div[1]");
    private final By addStoreOption = By.xpath("/html/body/div/div[2]/div/nz-modal-container/div/div/div/app-get-started-screen/nz-spin/div/div/div[2]/div[3]/div[1]/div[1]");
    private final By storeCreationInterface = By.xpath("/html/body/div/div[2]/div/nz-modal-container"); // Update with actual locator

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isPopupVisible(String title) {
        try {
            return wait.until(ExpectedConditions
                            .visibilityOfElementLocated(popupTitle))
                    .getText().contains(title);
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickPopupButton(String buttonText) {
        switch (buttonText) {
            case "Add Store":
                wait.until(ExpectedConditions.elementToBeClickable(addStoreOption)).click();
                break;
            // Add other cases as needed
        }
    }

    public boolean isInterfaceDisplayed(String interfaceName) {
        try {
            switch (interfaceName) {
                case "store creation interface":
                    return wait.until(ExpectedConditions
                                    .visibilityOfElementLocated(storeCreationInterface))
                            .isDisplayed();
                // Add other interfaces as needed
            }
        } catch (TimeoutException e) {
            return false;
        }
        return false;
    }
}