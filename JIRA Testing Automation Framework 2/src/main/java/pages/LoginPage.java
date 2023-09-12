package pages;

import com.telerikacademy.testframework.BasePage;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver, "jira.loginPage");
    }

    public void loginUser() {
        String username = getConfigPropertyByKey("jira.users.user.username");
        String password = getConfigPropertyByKey("jira.users.user.password");

        navigateToPage();
        assertPageNavigated();

        // Set username - email
        actions.waitForElementVisible("jira.loginPage.username");
        actions.typeValueInField(username, "jira.loginPage.username");

        // Continue
        actions.waitForElementVisible("jira.loginPage.continueSubmitButton");
        actions.clickElement("jira.loginPage.continueSubmitButton");

        // Set password
        actions.waitForElementClickable("jira.loginPage.password");
        actions.typeValueInField(password, "jira.loginPage.password");

        // Submit
        actions.waitForElementClickable("jira.loginPage.continueSubmitButton");
        actions.clickElement("jira.loginPage.continueSubmitButton");

        actions.waitForElementVisible("jira.homePage.home");
    }
}
