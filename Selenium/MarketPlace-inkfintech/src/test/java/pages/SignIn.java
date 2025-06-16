package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

public class SignIn extends BrowserDriver {
    public static String XEmail = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[1]/div/nz-form-item/nz-form-control/div/div/input";
    public static String XPassword = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[2]/div/nz-form-item/nz-form-control/div/div/nz-input-group/input";
    public static String XRememberMe = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[3]/div[1]/nz-form-item/label/span[1]/input";
    public static String XForgotPassword = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/form/div[3]/div[2]/nz-form-item/label/span/a";
    public static String XConfirm = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/div[2]/button[2]";
    public static String XOpenAnAccount = "/html/body/app-root/app-login/nz-layout/nz-content/div/div/div[3]/span/a";

    public static void EnterUserName() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(XEmail)).sendKeys("chayan+7@codelantic.com");
    }
    public static void EnterPassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(XPassword)).sendKeys("chayan@123");
    }
    public static void ClickRememberMe() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XRememberMe)).click();
    }
    public static void ClickForgotPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XForgotPassword)).click();
    }
    public static void ClickConfirm() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XConfirm)).click();
    }
    public static void ClickOpenAnAccount() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(XOpenAnAccount)).click();
    }
}
