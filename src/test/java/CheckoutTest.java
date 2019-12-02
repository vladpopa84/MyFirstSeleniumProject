import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CheckoutTest {

    private WebDriver driver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkOut() {

        driver.get("http://testfasttrackit.info/selenium-test/");


        WebElement account = driver.findElement(By.cssSelector("a.skip-account"));
        account.click();

        WebElement login = driver.findElement(By.cssSelector("div.links>ul>li.last>a"));
        login.click();

        driver.findElement(By.cssSelector("#email")).sendKeys("vladpopa84@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("30111984");

        driver.findElement(By.cssSelector("#send2")).click();


        Actions actions = new Actions(driver);
        WebElement menMenuElement = driver.findElement(By.cssSelector(".nav-2>a"));
        actions.moveToElement(menMenuElement);

        WebElement newArrivals = driver.findElement(By.cssSelector(".nav-2-1>a"));
        Action action = actions.moveToElement(newArrivals).click().build();
        action.perform();

        WebElement linenBlazer = driver.findElement(By.cssSelector("#product-collection-image-406"));
        linenBlazer.click();

        WebElement selectColor = driver.findElement(By.cssSelector("#swatch22"));
        selectColor.click();

        WebElement selectSize = driver.findElement(By.cssSelector("#swatch78"));
        selectSize.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart"));
        addToCartButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".bottom .btn-proceed-checkout"));
        checkoutButton.click();

        WebElement insertAdress = driver.findElement(By.cssSelector("#billing\\:street1"));
        String adress = RandomStringUtils.randomAlphabetic(12) + ", " + "Nr" + " " + 12;
        insertAdress.sendKeys(adress);

        WebElement insertCity = driver.findElement(By.cssSelector("#billing\\:city"));
        insertCity.sendKeys("Cluj-Napoca");

        WebElement insertCountry = driver.findElement(By.cssSelector("#billing\\:country_id"));
        insertCountry.click();
        WebElement selectCountry = driver.findElement(By.cssSelector("#billing\\:country_id > option:nth-child(186)"));
        selectCountry.click();

        WebElement insertPostalCode = driver.findElement(By.cssSelector("#billing\\:postcode"));
        String postalCode = RandomStringUtils.randomAlphabetic(6);
        insertPostalCode.sendKeys(postalCode);

        WebElement insertState = driver.findElement(By.cssSelector("#billing\\:region_id"));
        insertState.click();
        WebElement selectState = driver.findElement(By.cssSelector("#billing\\:region_id > option:nth-child(14)"));
        selectState.click();

        WebElement insertTelephone = driver.findElement(By.cssSelector("#billing\\:telephone"));
        insertTelephone.sendKeys("12345678");

        WebElement continueButton = driver.findElement(By.cssSelector("#billing-buttons-container .button"));
        continueButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement shippingMethod = driver.findElement(By.cssSelector(".gift-messages>h3"));
        Assert.assertEquals(shippingMethod.getText(), "DO YOU HAVE ANY GIFT ITEMS IN YOUR ORDER?");

    }

    @After
    public void quitDriver() {
        driver.quit();
    }
}