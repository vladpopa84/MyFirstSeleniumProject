import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccountTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void myAccountTest() {
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("div.links>ul>li.last>a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement editAccountInformation = driver.findElement(By.cssSelector(".block-content > ul > li:nth-of-type(2) > a"));
        editAccountInformation.click();

        WebElement accountInformation = driver.findElement(By.cssSelector(".page-title > h1"));
        Assert.assertEquals(accountInformation.getText(), "EDIT ACCOUNT INFORMATION");
    }

    @After
    public void quitDriver() {

        driver.quit();
    }

}
