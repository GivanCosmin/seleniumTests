package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Login locators
    By userNameID = By.name("loginEmail");
    By passwordID = By.name("loginPassword");
    By loginClass = By.xpath("//button[contains(text(), \"EINLOGGEN\")]");
    By loginOutputCheckEntries = By.xpath("//div[@class='message-error' and text()='Bitte überprüfen Sie Ihre Eingaben.']");
    By loginOutputEmailError = By.xpath("//div[@class='message-error' and text()='Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe.']");

    //Login method parametrized
    public LoginPage loginToRakuten(String username, String pwd){
        writeText(userNameID, username);
        writeText(passwordID, pwd);
        click(loginClass);
        return this;
    }

    //Method that verifies output error message after introducing credentials
    public LoginPage verifyEntriesLoginError(){
        waitVisibility(loginOutputCheckEntries);
        return this;
    }

    //Method that verifies output error message after introducing credentials
    public LoginPage verifyEmailAndPwdError(){
        waitVisibility(loginOutputEmailError);
        return this;
    }
}