import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WishListTest {

    @Test

    public static void addToWishList() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

//        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        account.click();

//        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
//        login.click();
//
//        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");
//
//        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");
//
//        driver.findElement(By.cssSelector("#send2")).click();

        WebElement sale = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        sale.click();
        WebElement product = driver.findElement(By.cssSelector("#product-collection-image-423"));
        product.click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();

//        driver.close();


    }
}
