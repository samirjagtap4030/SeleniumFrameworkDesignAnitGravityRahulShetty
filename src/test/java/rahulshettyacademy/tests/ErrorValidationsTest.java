package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = { "ErrorHandling" })
    public void loginErrorValidation() throws IOException, InterruptedException {
        log.info("Starting loginErrorValidation");
        landingPage.loginApplication("anshika@gmail.com", "Iamki000"); // Wrong password
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
        log.info("Verified error message successfully");
    }

    @Test
    public void productErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        log.info("Starting productErrorValidation for: " + productName);
        ProductCatalogue productCatalogue = landingPage.loginApplication("postman4075@gmail.com", "Hello123@");
        productCatalogue.addProductToCart(productName);
        productCatalogue.goToCartPage();

        CartPage cartPage = new CartPage(driver);
        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33"); // Wrong product name to verify false
        Assert.assertFalse(match);
        log.info("Verified product mismatch successfully");
    }
}
