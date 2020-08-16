import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.WebDriverFactory;

import java.util.List;

public class TagSelectionTests {
    private WebDriver driver;
    private MainPage mainPage;

    @Parameters(value = "browserName")
    @BeforeMethod
    public void setUp(String browserName) {
        WebDriverFactory.createDriver(browserName);
        driver = WebDriverFactory.getDriver();
        mainPage = new MainPage(driver);
    }

    @Description(value = "Selected tag is displayed in toggler on the rop of the page after selection")
    @Test
    public void selectedTagIsInToggler() {
        mainPage.navigateToMainPage()
                .getLastTag()
                .click();

        String selectedTagName = mainPage.getLastTag().getText();

        Assert.assertEquals(mainPage.getTogglerTag().getText(), selectedTagName);
    }

    @Description(value = "Selected tag is displayed in every post on page of the page after selection")
    @Test
    public void selectedTagIsAtEveryPost() {
        mainPage.navigateToMainPage()
                .getLastTag()
                .click();

        String selectedTagName = mainPage.getLastTag().getText();
        List<WebElement> records = mainPage.getAllPagePosts();

        for (WebElement element : records) {
            Assert.assertTrue(element.getText().contains(selectedTagName));
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
