package tests;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

public class SearchTests extends BaseTest {

    //Test that validates search functionality for element
    @Test(priority = 0, description = "Search into the search widget and expect result")
    public void searchElementAndExpectResult(Method method){
        ExtentTestManager.startTest(method.getName(), "Search element , validate steps for search widget");

        homePage
                .goToRakuten()
                .searchValueInSearchWidget("mobile");
    }


}
