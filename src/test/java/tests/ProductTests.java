package tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

public class ProductTests extends BaseTest {

    //Product buying test flow and validation until Select method page
    @Test(priority = 0, description = "Add product to cart checkout and go to payment field")
    public void addProductToCartAndCheckout(Method method){
        ExtentTestManager.startTest(method.getName(), "Add product scenario , validate steps until payment");

        homePage
                .goToRakuten();

        productPage
                .selectRandomProduct()
                .verifyProductDetails()
                .addProductToCart()
                .selectGoToCartOption()
                .selectGoToCheckoutOption()
                .selectGuestOptionAndGoToNextStep()
                .introducePersonalDetails("John","Snow","Legiendamm","1","10115","Berlin","co@yahoo.com");
    }


}
