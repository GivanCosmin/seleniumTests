package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver){
        super(driver);
    }

    //Home Page locators
    String baseUrl = "https://www.rakuten.de/";

    By signInButton = By.xpath("//a[@href='/kundenkonto' and text()='Einloggen']");
    By cookiePopUpAccept = By.xpath("//div[@id='consent_prompt_submit']");

    By searchWidget = By.xpath("//div[@class='search-input-wrapper']/div/input[@id='search-input']");
    By autocompleteItem = By.xpath("//div[@class='easy-autocomplete-container']/ul/li/div/b");
    By searchButton = By.xpath("//button[@class='button-search']");

    //Method to open Rakuten website , sleep used due to vulnerabilities when waiting for cookies pop-up
    public HomePage goToRakuten(){
        driver.get(baseUrl);
        waitVisibility(searchButton);

        Boolean isPresent = driver.findElements(cookiePopUpAccept).size() > 0;
        if(isPresent == true){
            waitVisibility(cookiePopUpAccept);
            click(cookiePopUpAccept);
        }
        return this;
    }

    //Method to navigate to the Login Page
    public LoginPage goToLoginPage(){
        waitVisibility(signInButton);
        click(signInButton);
        return new LoginPage(driver);
    }

    //Method that is searching an element and validates output
    public HomePage searchValueInSearchWidget(String elementToSearch){
        waitVisibility(searchWidget);
        writeText(searchWidget, elementToSearch);
        waitToBeClickable(autocompleteItem);
        click(autocompleteItem);
        waitVisibility(searchButton);
        click(searchButton);
        String searchResultsField = driver.findElement(By.xpath("//div[@class='search-input-wrapper']/div/input[@id='search-input']")).getAttribute("value");
        String searchResultsPageTitle = driver.findElement(By.xpath("//h1[@class='search-title']/span[@class='term']")).getText();
        assertTrue(searchResultsPageTitle.contains(searchResultsField));
        return this;
    }

}
