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

        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();

        WebElement welcomeMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));

        Assert.assertEquals(welcomeMessage.getText(), "Hello, sgdsgv dfvbs dsvsdvss!");
    }

    @Test
    public void invalidPassword() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111980");

        driver.findElement(By.cssSelector("#send2")).click();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement advicePass = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));

        Assert.assertEquals(advicePass.getText().trim(), "Invalid login or password.");

    }


    @Test
    public void invalidEmail() {

        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yaho.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement advicePass = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));

        Assert.assertEquals(advicePass.getText().trim(), "Invalid login or password.");

    }

    @After
    public void quitDriver() {

        driver.quit();
    }


}
