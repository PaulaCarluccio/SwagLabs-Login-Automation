package pages;

import java.util.List;

public class ProductsPage extends BasePage {

    protected final String pageTitle = "//span[@class='title']";
    protected final String listOfProductsName = "//div[@class='inventory_item_name ']";
    protected final String listOfProductsImg = "//div[@class='inventory_item_img']/a/img";
    protected final String listOfItemsDisplayed = "//div[@class=\"inventory_item\"]";
    protected final String shoppingCart = "//a[@class='shopping_cart_link']";
    protected final String toggle = "//button[@id='react-burger-menu-btn']";
    protected final String logOut = "//a[@id='logout_sidebar_link']";

    public ProductsPage() {
        super(driver);
    }

    public String getPageTitle() {
        return getElementText(pageTitle);
    }

    public List<String> returnListOfItems() {
        return getElementTextValues(listOfProductsName);
    }

    public List<String> returnListOfImages() {
        return getImageSrcValues(listOfProductsImg);
    }

    public void afterLogin() {
        clickElement(toggle);
        clickElement(logOut);
        explicitWait(5);
        driver.quit();
    }
    
}
