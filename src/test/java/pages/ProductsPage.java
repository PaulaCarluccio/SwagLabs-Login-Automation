package pages;

public class ProductsPage extends BasePage {

    private String pageTitle = "//span[@class='title']";
    private String listOfProductsName = "//div[@class='inventory_item_name ']";
    private String listOfProductsImg = "//div[@class='inventory_item_img']/a/img";

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
