import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void registerNewUser() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement register = driver.findElement(By.cssSelector("div.links>ul>li:nth-last-child(2)>a"));
        register.click();

        WebElement registerPage = driver.findElement(By.cssSelector("div.page-title"));
        Assert.assertEquals(registerPage.getText(), "CREATE AN ACCOUNT");

        driver.findElement(By.name("firstname")).sendKeys("Vlad");

        driver.findElement(By.id("lastname")).sendKeys("Popa");

        driver.findElement(By.id("email_address")).sendKeys("vladpopa84@outlook.com");

        driver.findElement(By.name("password")).sendKeys("Iphone7+");
        driver.findElement(By.name("confirmation")).sendKeys("Iphone7+");

        driver.findElement(By.className("checkbox")).click();

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

