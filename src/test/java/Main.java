import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

public class Main {
    public static void main(String[] args) {

        LoginTest loginTest = new LoginTest();
        WishListTest wishListTest = new WishListTest();
        RegisterTest registerTest = new RegisterTest();

        loginTest.loginTest();
        loginTest.invalidEmail();
        loginTest.invalidPassword();
        wishListTest.addToWishList();
        registerTest.registerNewUser();


    }


}