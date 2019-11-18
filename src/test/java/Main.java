import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {


        WishListTest.addToWishList();

        RegisterTest.registerNewUser();

        LoginTest.loginTest();

        LoginTest.invalidLogin();


    }


}