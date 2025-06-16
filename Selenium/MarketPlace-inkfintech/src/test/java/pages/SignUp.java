package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

public class SignUp extends BrowserDriver {
    public static String XFirstName = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XLastName = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XEmailAddress = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XPhoneNumber = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XCompany = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XWebsite = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XNatureOfBusiness = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XPassword = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XConfirmPassword = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XCloseButton = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XCheckBox = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XCreateAccount = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XLogIn = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";

    public static void EnterFirstName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XFirstName)).sendKeys("Chayan");
    } public static void EnterLastName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XLastName)).sendKeys("Kumar");
    } public static void EnterEmailAddress() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XEmailAddress)).sendKeys("chayan+01@codelantic.com");
    } public static void EnterPhoneNumber() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XPhoneNumber)).sendKeys("0763244150");
    } public static void EnterCompany() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XCompany)).sendKeys("Codelantic");
    } public static void EnterWebsite() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XWebsite)).sendKeys("www.codelantic.com");
    } public static void EnterNatureOfBusiness() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XNatureOfBusiness)).sendKeys("auto test");
    } public static void EnterPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XPassword)).sendKeys("chayan@123");
    } public static void EnterConfirmPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XConfirmPassword)).sendKeys("chayan@123");
    } public static void ClickCloseButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(XCloseButton)).click();
    }
    public static void ClickCheckBox() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XCheckBox)).click();
    }public static void ClickCreateAccount() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XCreateAccount)).click();
    }public static void ClickLogIn() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XLogIn)).click();
    }

}
