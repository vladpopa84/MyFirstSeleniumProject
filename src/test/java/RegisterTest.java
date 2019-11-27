import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;


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


        String firstName = RandomStringUtils.randomAlphabetic(5);
        driver.findElement(By.name("firstname")).sendKeys(firstName);

        String lastName = RandomStringUtils.randomAlphabetic(6);
        driver.findElement(By.id("lastname")).sendKeys(lastName);

        String emailAdress = RandomStringUtils.randomAlphabetic(8) + "@yahoo.com";
        driver.findElement(By.id("email_address")).sendKeys(emailAdress);

        String password = RandomStringUtils.randomAlphabetic(6);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmation")).sendKeys(password);

//        driver.findElement(By.className("checkbox")).click();

        WebElement registerButton = driver.findElement(By.cssSelector(".button[title='Register']"));
        registerButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement successMsg = driver.findElement(By.cssSelector(".success-msg>ul>li>span"));
        Assert.assertEquals(successMsg.getText(), "Thank you for registering with Madison Island.");
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}

