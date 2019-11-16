import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;


public class Main {
    public static void main(String[] args) {

//        WishListTest test = new WishListTest();
//        RegisterTest test1 = new RegisterTest();

        loginTest();

        invalidLogin();

        WishListTest.addToWishList();

        RegisterTest.registerNewUser();



    }
    public static void loginTest() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();

        driver.close();

    }

    public static void invalidLogin() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        WebElement account = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111980");

        driver.findElement(By.cssSelector("#send2")).click();

        driver.close();

    }
}