package steps.cart;

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

public class AddItemToCart {

    private WebDriver driver = new ChromeDriver();
    private IndexPage indexPage = new IndexPage(driver);

    @Given("El usuario esta en la vista de inicio")
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
    }

    @When("Encuentra el producto que desea comprar")
    public void encuentra_producto_a_comprar() {
        indexPage.clickOnSearchBar();
        indexPage.enterSearch("Ropa deportiva hombre");
    }

    @When("Agrega el producto al carrito de compra")
    public void agrega_producto_carrito_compras() {
        indexPage.submitSearch();
        indexPage.clickOnFirstResult();
        new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) driver -> {
            assert driver != null;
            return !driver.getCurrentUrl().equals("https://www.amazon.com/");
        });
        indexPage.clickOnAddToCart();
    }

    @Then("El carrito de compra debe tener un elemento")
    public void carrito_compras_debe_tener_1_producto() {
        new WebDriverWait(driver, Duration.of(5L, ChronoUnit.SECONDS));
        Long cartItemsCount = indexPage.getCartItemsCount();
        Assert.assertEquals(1L, cartItemsCount.longValue());
        driver.close();
    }


}
