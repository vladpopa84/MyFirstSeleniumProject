public class Main {
    public static void main(String[] args) {

        LoginTest loginTest = new LoginTest();
        WishListTest wishListTest = new WishListTest();
        RegisterTest registerTest = new RegisterTest();
        SearchTest searchTest = new SearchTest();
        ChangeLanguageTest language = new ChangeLanguageTest();
        CartTest addToCart = new CartTest();

        loginTest.loginTest();
        loginTest.invalidEmail();
        loginTest.invalidPassword();
        wishListTest.addToWishList();
        registerTest.registerNewUser();
        searchTest.searchTest();
        language.changeLanguage();
        addToCart.addToCart();


    }


}