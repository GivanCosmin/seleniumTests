package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void classLevelSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void methodLevelSetup(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
