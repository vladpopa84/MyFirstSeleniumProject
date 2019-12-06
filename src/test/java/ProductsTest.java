import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductsTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void allMenProductsListTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement allProductsMen = driver.findElement(By.cssSelector(".nav-2 >a"));
        allProductsMen.click();

        List<WebElement> allMenProducts = driver.findElements(By.cssSelector(".category5"));
        System.out.println(allMenProducts.isEmpty());

    }

    @Test
    public void newArrivalsListMenTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement newProductsListMen = driver.findElement(By.cssSelector(".nav-2-1"));
        newProductsListMen.click();

        List<WebElement> newArrivals = driver.findElements(By.cssSelector(".products-grid--max-4-col"));
        System.out.println(newArrivals.isEmpty());

    }

    @After
    public void quitDriver() {
        driver.quit();
    }


}
