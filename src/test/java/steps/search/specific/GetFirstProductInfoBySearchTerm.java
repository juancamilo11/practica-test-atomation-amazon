package steps.search.specific;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IndexPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class GetFirstProductInfoBySearchTerm {
    private WebDriver driver = new ChromeDriver();
    private IndexPage indexPage = new IndexPage(driver);

    @Given("El usuario se encuentra en la pagina de inicio")
    public void el_usuario_se_encuentra_en_index() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-extensions");
//        options.addArguments("window-size=1200x600");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--remote-debugging-port=45444");


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(40, ChronoUnit.SECONDS));
        driver.manage().timeouts().pageLoadTimeout(Duration.of(40, ChronoUnit.SECONDS));
        driver.navigate().to("https://www.amazon.com/");

        /*
        // El usuario se registró correctamente
        new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return driver.getCurrentUrl().equals("http://localhost:3000/servicios/usuario");
        });
        dashboardPage.clickOnServiceRequest();

        // El usuario se registró correctamente
        new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return driver.getCurrentUrl().equals("http://localhost:3000/servicios/usuario/viajarAhora");
        }); */
    }

    @When("Ingresa el termino de busqueda en el buscador")
    public void ingresa_termino_busqueda() {
        indexPage.clickOnSearchBar();
        indexPage.enterSearch("Consolas de videojuegos");
    }

    @When("Presiona Enter")
    public void presiona_enter_buscar() {
        indexPage.submitSearch();
        new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return !driver.getCurrentUrl().equals("https://www.amazon.com/");
        });
    }

    @When("Selecciona el primer resultado")
    public void selecciona_primer_resultado() {
        indexPage.clickOnFirstResult();
        new WebDriverWait(driver, Duration.of(4L, ChronoUnit.SECONDS));
    }

    @Then("El usuario deberá ver la pagina del producto")
    public void debe_ver_pagina_producto() {
        List<String> details = indexPage.getProductDetails();

        System.out.println("--------------------------------");
        details.forEach((detail) -> {
            System.out.println(detail);
            System.out.println();
        });
        System.out.println("--------------------------------");
        Assert.assertNotNull(details);
        Assert.assertFalse(details.isEmpty());
        driver.close();
    }

}
