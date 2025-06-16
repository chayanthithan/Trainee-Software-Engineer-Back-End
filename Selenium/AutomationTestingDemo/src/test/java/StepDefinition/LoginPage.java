package StepDefinition;

import Pages.Dashboard;
import Utility.BrowserDriver;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private BrowserDriver browserDriver;
    private WebDriver driver;
    private Login login;
    private Dashboard dashboardPage;

    @Before
    public void setup() {
        browserDriver = new BrowserDriver();
        driver = browserDriver.getDriver();
    }

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {
        driver.get("https://astore.qaebosui.codelantic.com/login");
        login = new Login(driver);
    }

    @When("user enter valid credentials")
    public void user_enter_valid_credentials() {
        login.enterEmail("abinaya+166@codelantic.com");
        login.enterPassword("Test_1user");
        login.clickLogin();
    }

    @Then("user able to redirect to dashboard page")
    public void user_able_to_redirect_to_dashboard_page() {
        // Wait for URL to change
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard"));

        String expectedUrl = "https://astore.qaebosui.codelantic.com/dashboard";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("User was not redirected to dashboard", expectedUrl, actualUrl);
    }
    @Then("the {string} popup should be visible")
    public void popup_should_be_visible(String popupTitle) {
        dashboardPage = new Dashboard(driver);
        Assert.assertTrue(dashboardPage.isPopupVisible(popupTitle));
    }

    @When("user clicks {string} in the popup")
    public void user_clicks_in_popup(String buttonText) {
        dashboardPage.clickPopupButton(buttonText);
    }

    @Then("the store creation interface should be displayed")
    public void interface_should_be_displayed(String interfaceName) {
        Assert.assertTrue(dashboardPage.isInterfaceDisplayed(interfaceName));
    }
    @When("user click addStore button")
    public void user_click_addStore_button() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/nz-modal-container/div/div/div/app-get-started-screen/nz-spin/div/div/div[2]/div[3]/div[1]/div[1]")));
        login.clickAddStoreHeading();
    }

    @Then("display text")
    public void display_text(){
        System.out.println(login.getAddStoreButtonText());
    }
//    @After
//    public void tearDown() {
//        browserDriver.closeDriver();
//    }
}