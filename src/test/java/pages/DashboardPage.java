package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    private By btnServiceRequest = By.xpath("//*[@id=\"__next\"]/div/div/div/div/div/section[1]/a/div");
    private By btnShipmentRequest = By.xpath("//*[@id=\"__next\"]/div/div/div/div/div/section[2]/a/div");


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnServiceRequest() {
        driver.findElement(btnServiceRequest).click();
    }

    public void clickOnShipmentRequest() {
        driver.findElement(btnShipmentRequest).click();
    }

}
