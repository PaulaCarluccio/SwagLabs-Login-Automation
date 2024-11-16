package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    public static void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void closeBrowser() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.remove();
        }
    }

    public BasePage(WebDriver driver) {
        setDriver(driver);
    }

    public static void navigateTo(String url) {
        getDriver().get(url);
    }

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
