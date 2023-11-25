package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImmediateServiceRequestPage {

    private WebDriver driver;

    private By txtStart = By.id("start");
    private By errStart = By.id("err-start");

    private By txtEnd = By.id("destiny");
    private By errEnd = By.id("err-destiny");

    private By txtPassengers = By.id("passengersNumber");
    private By errTxtPassengers = By.id("err-passengers");

    private By txtDate = By.id("time");

    private By btnSubmit = By.id("submit-btn");
    private By popupTitle = By.className("swal2-title");

    public ImmediateServiceRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterStart(String start) {
        driver.findElement(txtStart).sendKeys(start);
    }

    public void enterDate(String date) {
        driver.findElement(txtDate).sendKeys(date);
    }

    public void enterEnd(String end) {
        driver.findElement(txtEnd).sendKeys(end);
    }


    public void enterPassengers(String passengers) {
        driver.findElement(txtPassengers).sendKeys(passengers);
    }

    public String getErrorStart() {
        return driver.findElement(errStart).getText();
    }

    public String getErrorEnd() {
        return driver.findElement(errEnd).getText();
    }

    public String getErrorPassengers() {
        return driver.findElement(errTxtPassengers).getText();
    }

    public void clickOnSubmit() {
        driver.findElement(btnSubmit).click();
    }

    public String getPopupTitle() {
        return driver.findElement(popupTitle).getText();
    }
}
