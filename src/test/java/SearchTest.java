import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class SearchTest {

    private WebDriver driver;
    String searchKeyword;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement search = driver.findElement(By.cssSelector("#search"));
        search.click();
        searchKeyword = "linen";
        search.sendKeys(searchKeyword);


        WebElement searchButton = driver.findElement(By.cssSelector("button.search-button"));
        searchButton.click();

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2 a"));

        for (WebElement productNamesElement : productNames) {
            MatcherAssert.assertThat("Some of the returned products' names do not contain the searched keyword.",
                    productNamesElement.getText(),
                    containsString(searchKeyword.toUpperCase()));
        }


    }

    @Test
    public void searchTest2() {
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement search = driver.findElement(By.cssSelector("#search"));
        search.click();
        searchKeyword = "vase";
        search.sendKeys(searchKeyword);


        WebElement searchButton = driver.findElement(By.cssSelector("button.search-button"));
        searchButton.click();

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2 a"));

        for (WebElement productNameElement : productNames) {
            MatcherAssert.assertThat("Some of the returned products' names do not contain the searched keyword.",
                    productNameElement.getText(),
                    containsString(searchKeyword.toUpperCase()));
        }

    }

    @Test
    public void checkInputValue() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement search = driver.findElement(By.cssSelector("#search"));
        search.click();
        searchKeyword = "pantaloni";
        search.sendKeys(searchKeyword);

        WebElement input = driver.findElement(By.cssSelector("#search"));
        Assert.assertEquals(input.getAttribute("value"), searchKeyword);

    }

    @After
    public void quitDriver() {

        driver.quit();
    }
}
