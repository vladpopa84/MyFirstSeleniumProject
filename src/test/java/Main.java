import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

public class Main {
    public static void main(String[] args) {

//        LoginTest login = new LoginTest();
//       WishListTest wish = new WishListTest();
        RegisterTest register = new RegisterTest();

//        login.loginTest();
//        login.invalidPassword();
//        login.invalidEmail();
//       wish.addToWishList();
        register.registerNewUser();


    }


}