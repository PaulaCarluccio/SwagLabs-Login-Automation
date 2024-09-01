package pages;

public class LoginPage extends BasePage {

    private String usernameInput = "//input[@id='user-name']";
    private String passwordInput = "//input[@id='password']";
    private String loginButton = "//input[@id='login-button']";
    private String errorMessage = "//h3[data-test='error']"; 

    public LoginPage() {
        super(driver);
    }

    public void navigaToLoginPage() {
        navigateTo("https://www.saucedemo.com");
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
    
}