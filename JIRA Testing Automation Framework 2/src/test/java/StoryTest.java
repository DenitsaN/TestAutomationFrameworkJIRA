import com.telerikacademy.testframework.UserActions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.StoryPage;

public class StoryTest extends BaseTest {

    private WebDriver driver;

    @Test
    public void createStoryWhenCreateClicked() {
        login();

        StoryPage storyPage = new StoryPage(actions.getDriver());
        storyPage.createStory();

        // Assert
        storyPage.assertCreateStoryExists();
    }

    @Test
    public void linkExistingBugToExistingStory() {
        login();

        StoryPage storyPage = new StoryPage(actions.getDriver());
        storyPage.linkBug();

        // Assert
        //storyPage.assertCreateStoryExists();
    }
}
