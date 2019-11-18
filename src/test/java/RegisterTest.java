import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest {

    @Test

    public static void registerNewUser() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a"));
        account.click();

        WebElement register = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));
        register.click();

        driver.findElement(By.name("firstname")).sendKeys("Vlad");

        driver.findElement(By.id("lastname")).sendKeys("Popa");

        driver.findElement(By.id("email_address")).sendKeys("vladpopa84@outlook.com");

        driver.findElement(By.name("password")).sendKeys("Iphone7+");
        driver.findElement(By.name("confirmation")).sendKeys("Iphone7+");

        driver.findElement(By.className("checkbox")).click();

//        driver.close();

    }
}
