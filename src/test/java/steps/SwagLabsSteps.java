package steps;

import java.util.List;

import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
import java.util.Arrays;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;

public class SwagLabsSteps {
    //SoftAssert soft = new SoftAssert();

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Given("I am on the Swag Labs login page")
    public void navigateToSwagLabs() {
        loginPage.navigaToLoginPage();
    }

    @When("^I enter the credentials (.*) and (.*)$")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on the Login button")
    public void login() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the Products page")
    public void validatePageTitle() {
        String pageTitle = productsPage.getPageTitle(); 
        Assert.assertEquals("Products", pageTitle);
    }

    @Then("I should see inventory items")
    public void validateListOfItems() {
        List<String> actualImageLinks = productsPage.returnListOfImages();
        List<String> actualItemTitles = productsPage.returnListOfItems();
        
        List<String> expectedImageLinks = Arrays.asList(
            "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg",
            "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg",
            "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg",
            "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg",
            "https://www.saucedemo.com/static/media/red-onesie-1200x1500.2ec615b2.jpg",
            "https://www.saucedemo.com/static/media/red-tatt-1200x1500.30dadef4.jpg"
        );
        
        List<String> expectedItemTitles = Arrays.asList(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie",
            "Test.allTheThings() T-Shirt (Red)"
        );
    
        Assert.assertEquals(actualItemTitles, expectedItemTitles, "The list of item titles on the Products Page is incorrect.");
        Assert.assertEquals(actualImageLinks, expectedImageLinks, "The list of item images on the Products Page is incorrect.");
    }
    
    @Then("^I should see an error message (.*)$")
    public void validateErrorMessage(String message) {
        String actualMessage = loginPage.getErrorMessage(); 
        String expectedMessage = message; 

        Assert.assertEquals(actualMessage, expectedMessage, "The error message is unexpected.");
    }
}
