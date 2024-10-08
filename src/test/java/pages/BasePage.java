package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
   protected static WebDriver driver;  

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    } 

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    /*public static void explicitWait(int seconds) {
        //No se pudo resolver la espera explícita de 5 segundos.
        Thread.sleep(seconds);
    }*/

    public WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public List<WebElement> findElements(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    public String getElementText(String locator) {
        return find(locator).getText();
    }

    public List<String> getElementTextValues(String locator) {
        List<WebElement> elements = findElements(locator);
        List<String> list = new ArrayList<>();
        for (WebElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }

    public List<String> getImageSrcValues(String locator) {
        List<WebElement> imageElements = findElements(locator);
        List<String> imageSrcs = new ArrayList<>();
        for (WebElement imageElement : imageElements) {
            String imageSrc = imageElement.getAttribute("src");
            imageSrcs.add(imageSrc);
        }
        return imageSrcs;
    }

    public int getElementTextValuesCount(String locator) {
        List<WebElement> elements = findElements(locator);
        return elements.size();
    }
}
