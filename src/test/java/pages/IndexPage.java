package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class IndexPage {

    private WebDriver driver;

    private By searchBar = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    private By productInfoContainer = By.cssSelector("div.a-section.a-spacing-small.puis-padding-left-small.puis-padding-right-small");
    private By productName = By.cssSelector("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-4");
    private By productDetailUl = By.cssSelector("ul.a-unordered-list.a-vertical.a-spacing-mini");
    private By freeShipingButton = By.xpath("//*[@id=\"p_n_is_free_shipping/10236242011\"]/span/a/span");
    private By AddToCartButton = By.cssSelector("input#add-to-cart-button");
    private By cartItemsCount = By.cssSelector("span#nav-cart-count");


    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSearchBar() {
        driver.findElement(searchBar).click();
    }

    public void enterSearch(String text) {
        driver.findElement(searchBar).sendKeys(text);
    }

    public void submitSearch() {
        driver.findElement(searchBar).submit();
    }

    public List<String> getProducts() {
        return driver.findElements(productInfoContainer).stream()
                .map(webElement -> webElement.findElement(productName)
                        .getText())
                .collect(Collectors.toList());
    }

    public List<String> getProductDetails() {
        WebElement detailUl = driver.findElement(productDetailUl);
        return detailUl.findElements(By.cssSelector("span.a-list-item"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnFreeShipping() {
        driver.findElement(freeShipingButton).click();
    }

    public void clickOnAddToCart() {
        driver.findElement(AddToCartButton).click();
    }

    public void clickOnFirstResult() {
        driver.findElements(productName).get(0).findElement(By.tagName("a")).click();
    }

    public Long getCartItemsCount() {
        return Long.valueOf(driver.findElement(cartItemsCount).getText());
    }
}
