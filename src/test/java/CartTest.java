import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addToCart() {

        driver.get("http://testfasttrackit.info/selenium-test/");


        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("div.links>ul>li.last>a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement sale = driver.findElement(By.cssSelector("li.nav-5>a"));
        sale.click();
        WebElement product = driver.findElement(By.cssSelector("#product-collection-image-423"));
        product.click();

        WebElement color = driver.findElement(By.id("option18"));
        color.click();
        WebElement size = driver.findElement(By.id("option78"));
        size.click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons > .btn-cart")).click();

        WebElement succeessMsg = driver.findElement(By.cssSelector("li.success-msg span:first-of-type"));
        Assert.assertEquals(succeessMsg.getText(), "Racer Back Maxi Dress was added to your shopping cart.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void quitDriver() {

        driver.quit();
    }
}