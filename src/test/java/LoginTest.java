import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("div.links>ul>li.last>a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement welcomeMessage = driver.findElement(By.cssSelector("p.hello>strong"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(welcomeMessage.getText(), "Hello, sgdsgv dfvbs dsvsdvss!");
    }

    @Test
    public void invalidPassword() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("div.links>ul>li.last>a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111980");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement advicePass = driver.findElement(By.cssSelector("li.error-msg >ul>li>span"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(advicePass.getText().trim(), "Invalid login or password.");

    }


    @Test
    public void invalidEmail() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("div.links>ul>li.last>a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yaho.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();


        WebElement advicePass = driver.findElement(By.cssSelector("li.error-msg >ul>li>span"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(advicePass.getText().trim(), "Invalid login or password.");

    }

    @After
    public void quitDriver() {

        driver.quit();
    }


}
