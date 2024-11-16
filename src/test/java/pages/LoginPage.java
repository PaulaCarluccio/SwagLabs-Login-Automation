package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    protected final String loginPageTitle = "//div[@class='login_logo']"; 
    protected final String usernameInput = "//input[@id='user-name']";
    protected final String passwordInput = "//input[@id='password']";
    protected final String loginButton = "//input[@id='login-button']";
    protected final String errorMessage = "//h3[@data-test='error']"; 
    protected final String closeErrorMessage = "//button[@class='error-button']"; 
    protected final String errorIcons = "//input/../*[name()='svg']"; 


    public LoginPage(WebDriver driver) {
        super(driver); 
    }

    public void navigaToLoginPage() {
        navigateTo("https://www.saucedemo.com");
        String pageName = getElementText(loginPageTitle);
        Assert.assertEquals(pageName, "Swag Labs", "The page title does not match.");
    }

    public void enterUsername(String username) {
        write(usernameInput, username);
    }

    public void enterPassword(String password) {
        write(passwordInput, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        //Validates close button in error message
        WebElement button = find(closeErrorMessage);
        Assert.assertTrue(button.isEnabled(), "Button is not interactable (disabled).");

        //Validates that error icons appeared beside inputs
        int errorIconOnInputs = getElementTextValuesCount(errorIcons);
        Assert.assertEquals(errorIconOnInputs, 2);        

        return getElementText(errorMessage);
    }
    
}