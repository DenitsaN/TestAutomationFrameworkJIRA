import pages.LoginPage;
import com.telerikacademy.testframework.UserActions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class BaseTest {

    UserActions actions = new UserActions();

    @BeforeAll
    public static void setUp() {
        //UserActions.loadBrowser("jira.homePage");
    }

    @AfterAll
    public static void tearDown() {
        UserActions.quitDriver();
    }

    public void login() {
        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser();
    }
}
