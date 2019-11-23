import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WishListTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addToWishList() {

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
        driver.findElement(By.cssSelector("a.link-wishlist")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement myWyshlist = driver.findElement(By.cssSelector("div.page-title"));
        Assert.assertEquals(myWyshlist.getText(), "MY WISHLIST");
    }

    @After
    public void quitDriver() {

        driver.quit();
    }

}

