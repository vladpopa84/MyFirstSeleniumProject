import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeLanguage {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void changeLanguage() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement language = driver.findElement(By.cssSelector("#select-language"));
        language.click();
        WebElement german = driver.findElement(By.cssSelector("#select-language > option:nth-child(3)"));
        german.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement frauen = driver.findElement(By.cssSelector(".first >a"));
        Assert.assertEquals(frauen.getText(), "FRAUEN");

    }

    @Test
    public void changeLanguage2() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement language = driver.findElement(By.cssSelector("#select-language"));
        language.click();
        WebElement german = driver.findElement(By.cssSelector("#select-language > option:nth-child(3)"));
        german.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement frauen = driver.findElement(By.cssSelector(".first >a"));
        Assert.assertNotEquals(frauen.getText(), "FRAUEN");

    }

    @After
    public void quitDriver() {

        driver.quit();
    }

}