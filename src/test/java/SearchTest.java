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
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    private WebDriver driver;

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
        search.sendKeys("linen");

        WebElement searchButton = driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
        searchButton.click();

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2 a"));

        for (WebElement productNamesElement : productNames) {
            assertThat("Some of the returned products' names do not contain the searched keyword.",
                    productNamesElement.getText(),
                    containsString("LINEN"));
        }


    }

    @Test
    public void searchTest2() {
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement search = driver.findElement(By.cssSelector("#search"));
        search.click();
        search.sendKeys("vase");

        WebElement searchButton = driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
        searchButton.click();

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2 a"));

        for (WebElement productNameElement : productNames) {
            MatcherAssert.assertThat("Some of the returned products' names do not contain the searched keyword.",
                    productNameElement.getText(),
                    containsString("VASE"));
        }

    }

    @After
    public void quitDriver() {

        driver.quit();
    }
}
