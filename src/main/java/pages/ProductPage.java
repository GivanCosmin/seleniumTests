package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    //Constructor
    public ProductPage(WebDriver driver){
        super(driver);
    }

    //Locators for buying products flow
    By productItem =  By.xpath("//div[@class='owl-stage']/div[@class='owl-item active']/li[@class='vw-productCard']/a[1]");
    By productPrice = By.xpath("//li[@class='feature -price']/span[@class='value']");
    By productTitle = By.xpath("//h1[@class='title']");
    By addProductToCart = By.xpath("//div[@class='cart']/a[@class='button add-cart -red']");
    By goToCart = By.xpath("//div[@class='buttons']/a[@href='/shopcart']");
    By goToCheckout = By.xpath("//button[@id='go_to_checkout']");
    By guestBuyOption = By.xpath("//div[@class='accordion-header']/label/input[@id='login-method1']");
    By goToNextStep = By.xpath("//button[@id='go_to_next_step']");

    By salutationField = By.xpath("//div[@class='field-container gender-container']/div/div[@class='jqTransformSelectWrapper']");
    By getSalutationFieldOption = By.xpath("//div[@class='field-container gender-container']/div/div[@class='jqTransformSelectWrapper']/ul/li[2]");
    By firstNameField = By.xpath("//input[@id='first-name']");
    By lastNameField = By.xpath("//input[@id='last-name']");
    By streetField = By.xpath("//input[@id='street']");
    By streetNrField = By.xpath("//input[@id='street-number']");
    By zipCodeField = By.xpath("//input[@id='zip-code']");
    By cityField = By.xpath("//input[@id='city']");
    By emailField = By.xpath("//input[@id='email']");
    By dayOfBirth = By.xpath("//div[@id='invoice-day-container']/div[@class='jqTransformSelectWrapper']");
    By dayOfBirthOption = By.xpath("//div[@id='invoice-day-container']/div[@class='jqTransformSelectWrapper']/ul/li[2]");
    By monthOfBirth = By.xpath("//div[@id='invoice-month-container']/div[@class='jqTransformSelectWrapper']");
    By monthOfBirthOption = By.xpath("//div[@id='invoice-month-container']/div[@class='jqTransformSelectWrapper']/ul/li[2]");
    By yearOfBirth = By.xpath("//div[@id='invoice-year-container']/div[@class='jqTransformSelectWrapper']");
    By yearOfBirthOption = By.xpath("//div[@id='invoice-year-container']/div[@class='jqTransformSelectWrapper']/ul/li[2]");
    By privacyCheckBox = By.xpath("//div[@class='field-container privacy']/input[@id='privacy']");
    By paypalPaymentOption = By.xpath("//div[@id='paypal_header']");

    //Method for selecting random product
    public ProductPage selectRandomProduct(){
        waitVisibility(productItem);
        click(productItem);
        return this;
    }

    //Method that verify product details
    public ProductPage verifyProductDetails(){
        waitVisibility(productPrice);
        waitVisibility(productTitle);
        return this;
    }

    //Method that adds product to cart
    public ProductPage addProductToCart(){
        waitVisibility(addProductToCart);
        click(addProductToCart);
        return this;
    }

    //Go To Cart Option method
    public ProductPage selectGoToCartOption(){
        waitVisibility(goToCart);
        click(goToCart);
        return this;
    }

    //Go To Checkout Option method
    public ProductPage selectGoToCheckoutOption(){
        waitVisibility(goToCheckout);
        click(goToCheckout);
        return this;
    }

    //Select guest option and go to next step method
    public ProductPage selectGuestOptionAndGoToNextStep(){
        waitVisibility(guestBuyOption);
        click(guestBuyOption);
        waitVisibility(goToNextStep);
        click(goToNextStep);
        return this;
    }

    //Introduce personal details into the credentials buying menu
    public ProductPage introducePersonalDetails(String firstName, String lastName, String street, String streetNr, String zipCode, String city, String email){
        waitVisibility(salutationField);
        click(salutationField);
        click(getSalutationFieldOption);
        writeText(firstNameField, firstName);
        writeText(lastNameField, lastName);
        writeText(streetField, street);
        writeText(streetNrField, streetNr);
        writeText(zipCodeField, zipCode);
        writeText(cityField, city);
        writeText(emailField, email);
        click(dayOfBirth);
        waitVisibility(dayOfBirthOption);
        click(dayOfBirthOption);
        click(monthOfBirth);
        waitVisibility(monthOfBirthOption);
        click(monthOfBirthOption);
        click(yearOfBirth);
        waitVisibility(yearOfBirthOption);
        click(yearOfBirthOption);
        waitVisibility(privacyCheckBox);
        click(privacyCheckBox);
        waitVisibility(goToNextStep);
        click(goToNextStep);
        waitVisibility(paypalPaymentOption);
        return this;
    }



}
