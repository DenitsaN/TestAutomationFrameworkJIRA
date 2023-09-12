import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.BugPage;
import pages.StoryPage;

public class BugTest extends BaseTest {

    private WebDriver driver;

    @Test
    public void createStoryWhenCreateClicked() {
        login();

        BugPage bugPage = new BugPage(actions.getDriver());
        bugPage.createBug();

        // Assert
        bugPage.assertCreateBugExists();
    }
}
