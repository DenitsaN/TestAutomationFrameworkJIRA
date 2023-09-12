package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class StoryPage extends BaseJiraPage {
    public StoryPage(WebDriver driver) {
        super(driver, "jira.issuesPage");
    }

    // TODO: use project key and set it in the url as placeholder
    public void createStory() {
        // Navigating to the project might do a redirect through login, do not assert
        navigateToPage();

        String storyName = getConfigPropertyByKey("story.name");
        String storyDescription = getConfigPropertyByKey("story.description");
        String storyPriority = getUIMappingByKey("story.priority");

        // Click Create item
        actions.waitForElementClickable("jira.header.create.menuButton");
        actions.clickElement("jira.header.create.menuButton");

        // Change type to Story
        actions.waitForElementClickable("jira.create.issue.type.button");
        actions.clickElement("jira.create.issue.type.button");

        actions.waitForElementClickable("jira.create.issue.type.selection", "Story");
        actions.clickElement("jira.create.issue.type.selection", "Story");

        // Set Summary
        actions.waitForElementClickable("jira.create.issue.summary");
        actions.typeValueInField(storyName, "jira.create.issue.summary");

        // Set Description
        actions.waitForElementClickable("jira.create.issue.description");
        actions.typeValueInField(storyDescription, "jira.create.issue.description");

        // Set Priority
        actions.waitForElementClickable("jira.create.issue.priority.button");
        actions.clickElement("jira.create.issue.priority.button");

        actions.waitForElementClickable("jira.create.issue.priority.type", storyPriority);
        actions.clickElement("jira.create.issue.priority.type", storyPriority);

        // Create
        actions.waitForElementClickable("jira.create.issue.create.button");
        actions.clickElement("jira.create.issue.create.button");
    }

    public void linkBug() {
        navigateToPage();

        String storyName = getConfigPropertyByKey("story.name");
        String bugName = getConfigPropertyByKey("bug.name");
        String relation = getConfigPropertyByKey("story.link.relation");

        // Find Story
        actions.waitForElementClickable("jira.issue.search");
        actions.typeValueInField(storyName, "jira.issue.search");
        driver.switchTo().activeElement().sendKeys(Keys.RETURN);

        // Click Story
        actions.waitForElementClickable("jira.issue.item.summary", storyName);
        actions.clickElement("jira.issue.item.summary", storyName);

        // Wait for Story
        actions.waitForElementPresent("jira.issue.header", storyName);

        // Click Link
        actions.waitForElementClickable("jira.issue.link.button");
        actions.clickElement("jira.issue.link.button");

        // Scroll to bottom
        //String xpath = actions.getLocatorValueByKey("jira.issue.details.container");
        //driver.findElement(By.xpath(xpath)).sendKeys(Keys.PAGE_DOWN);
//        Actions a = new Actions(driver);
//        a.sendKeys(Keys.PAGE_DOWN).perform();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String xpath = actions.getLocatorValueByKey("jira.issue.details.container");
//        WebElement element = driver.findElement(By.xpath(xpath));
//        js.executeScript("arguments[0].scrollIntoView();", element);

        // Find issue to link
        actions.waitForElementClickable("jira.issue.link.search");
        actions.moveAndScrollToElement("jira.issue.link.search");
        actions.clickElement("jira.issue.link.search");

        driver.switchTo().activeElement().sendKeys(bugName);

        // Select issue
        actions.waitForElementClickable("jira.issue.link.issue");
        actions.clickElement("jira.issue.link.issue");

        // Select relation
        actions.waitForElementClickable("jira.issue.link.select");
        actions.clickElement("jira.issue.link.select");

        actions.waitForElementClickable("jira.issue.link.option", relation);
        actions.clickElement("jira.issue.link.option", relation);

        // Click Link
        actions.waitForElementClickable("jira.issue.link.link.button");
        actions.moveAndScrollToElement("jira.issue.link.link.button");
        actions.clickElement("jira.issue.link.link.button");
    }

    public void assertCreateStoryExists() {
        navigateToPage();

        String storyName = getConfigPropertyByKey("story.name");
        actions.waitForElementClickable("jira.issue.search");
        actions.typeValueInField(storyName, "jira.issue.search");
        driver.switchTo().activeElement().sendKeys(Keys.RETURN);

        actions.waitForElementPresent("jira.issue.item.summary", storyName);
    }
}
