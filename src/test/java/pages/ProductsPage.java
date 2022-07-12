package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private By itemContainersLocator = By.cssSelector("div.inventory_item");

    String itemContainer =
            "//div[@class='inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    By headerContainer = By.id("header_container");
    By itemDetailsLink = By.cssSelector("a[id$=_title_link]");
    By removeButton = By.cssSelector("button[id^=remove-]");
    By addToCartButton = By.cssSelector("button[id^=add-]");
    By productPrice = By.cssSelector("div.inventory_item_price");
    By productDescription = By.cssSelector("div.inventory_item_desc");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderContainerDisplayed() {
        return driver.findElement(headerContainer).isDisplayed();
    }

    public String getProductPrice(String productName) {
        WebElement productContainer = getProductContainer(productName);
        return productContainer.findElement(productPrice).getText();
    }

    public String getProductPrice1(String productName) {
        List<WebElement> itemContainers = driver.findElements(itemContainersLocator);
        for (WebElement container:
                itemContainers) {
            String itemName = container.findElement(By.cssSelector("div.inventory_item_name")).getText();
            if(itemName == productName) {
                container.findElement(productPrice).getText();
            }
        }

        WebElement productContainer = getProductContainer(productName);
        return productContainer.findElement(productPrice).getText();
    }


    public String getProductDescription(String productName) {
        WebElement productContainer = getProductContainer(productName);
        return productContainer.findElement(productDescription).getText();
    }

    public void clickAddToCartButton(String productName) {
        WebElement productContainer = getProductContainer(productName);
        productContainer.findElement(addToCartButton).click();
    }

    public void clickRemoveButton(String productName) {
        WebElement productContainer = getProductContainer(productName);
        productContainer.findElement(removeButton).click();
    }

    public void openProductDetails(String productName) {
        WebElement productContainer = getProductContainer(productName);
        productContainer.findElement(itemDetailsLink).click();
    }

    private WebElement getProductContainer(String productName) {
        return driver.findElement(By.xpath(
                String.format(itemContainer, productName)
        ));
    }
}
