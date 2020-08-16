package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private By tagInContainer = By.xpath("//div[@class = 'tag-list']/a");
    private By post = By.xpath("//ul[@class = 'tag-list']");
    private By togglerTag = By.xpath("//a[@class = 'nav-link active ng-binding']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateToMainPage(){
        driver.get("https://demo.realworld.io");
        return new MainPage(driver);
    }

    public WebElement getLastTag(){
        waitForElementVisibility(tagInContainer, 10);
        List<WebElement> tags = driver.findElements(tagInContainer);
        return tags.get(tags.size()-1);
    }

    public List <WebElement> getAllPagePosts(){
        waitForElementVisibility(post, 10);
        return driver.findElements(post);
    }

    public WebElement getTogglerTag(){
        return driver.findElement(togglerTag);
    }

    private MainPage waitForElementVisibility(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return new MainPage(driver);
    }

}
