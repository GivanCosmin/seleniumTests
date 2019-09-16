package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    //Click method
    public void click(By elementLocation){
        driver.findElement(elementLocation).click();
    }

    //Write text
    public void writeText(By elementLocation, String text){
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read text
    public String readText(By elementLocation){
        return driver.findElement(elementLocation).getText();
    }

    //Wait visibility
    public void waitVisibility(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Wait to be clickable
    public void waitToBeClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
