package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;


    private By txtEmail = By.id("email");
    private By errEmail = By.id("err-email");

    private By txtFullName = By.id("fullName");
    private By errFullName = By.id("err-fullName");

    private By txtPassword = By.id("password");
    private By errPassword = By.id("err-password");

    private By txtPhone = By.id("phone");
    private By errPhone = By.id("err-phone");

    private By txtRole = By.id("role");
    private By errRole = By.id("err-role");

    private By aLogin = By.id("a_login");
    private By btnRegister = By.id("register-btn");
    private By errorPopup = By.className("swal2-html-container");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void enterFullName(String fullName) {
        driver.findElement(txtFullName).sendKeys(fullName);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void enterPhone(String phone) {
        driver.findElement(txtPhone).sendKeys(phone);
    }

    public void enterRole(String role) {
        driver.findElement(txtRole).sendKeys(role);
    }

    public String getErrorEmail() {
        return driver.findElement(errEmail).getText();
    }

    public String getErrorFullName() {
        return driver.findElement(txtFullName).getText();
    }

    public String getErrorPhone() {
        return driver.findElement(txtPhone).getText();
    }

    public String getErrorRole() {
        return driver.findElement(txtRole).getText();
    }

    public String getErrorPassword() {
        return driver.findElement(errPassword).getText();
    }

    public void clickOnLogin() {
        driver.findElement(aLogin).click();
    }

    public void clickOnRegisterButton() {
        driver.findElement(btnRegister).click();
    }

    public String getErrorPopup() {
        return driver.findElement(errorPopup).getText();
    }

    public boolean isErrorPopupDisplayed() {
        return driver.findElement(errorPopup).isDisplayed();
    }

}
