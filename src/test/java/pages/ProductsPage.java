package pages;

import java.util.List;

public class ProductsPage extends BasePage {

    private final String pageTitle = "//span[@class='title']";
    private final String listOfProductsName = "//div[@class='inventory_item_name ']";
    private final String listOfProductsImg = "//div[@class='inventory_item_img']/a/img";

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
    
}
