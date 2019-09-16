package tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

public class LoginTests extends BaseTest {

    //Acceptance test that verifies login with wrong user and password
    @Test(priority = 0, description = "Invalid Login Scenario with wrong user and pwd")
    public void invalidUserTest(Method method){
        ExtentTestManager.startTest(method.getName(), "Invalid login scenario with wrong username and password");

        homePage
                .goToRakuten()
                .goToLoginPage();
        loginPage
                .loginToRakuten("user","password")
                .verifyEntriesLoginError();
    }

    //Acceptance test that verifies login with wrong email and password
    @Test(priority = 1, description = "Invalid Login Scenario with email and pwd")
    public void invalidPasswordTest(Method method){
        ExtentTestManager.startTest(method.getName(), "Invalid login scenario with wrong email and password");

        homePage
                .goToRakuten()
                .goToLoginPage();

        loginPage
                .loginToRakuten("user@yahoo.com","password")
                .verifyEmailAndPwdError();
    }

    //Acceptance test that verifies login with empty user and password
    @Test(priority = 1, description = "Invalid Login Scenario with empty user and pwd")
    public void emptyCredentialsTest(Method method){
        ExtentTestManager.startTest(method.getName(), "Invalid login scenario with empty username and password");

        homePage
                .goToRakuten()
                .goToLoginPage();

        loginPage
                .loginToRakuten("","")
                .verifyEntriesLoginError();
    }

}
