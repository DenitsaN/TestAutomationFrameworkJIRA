package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;

public class BugPage extends BaseJiraPage {
    public BugPage(WebDriver driver) {
        super(driver, "jira.issuesPage");
    }

    // TODO: use project key and set it in the url as placeholder
    public void createBug() {
        // Navigating to the project might do a redirect through login, do not assert
        navigateToPage();

        String bugName = getConfigPropertyByKey("bug.name");
        String bugDescription = getConfigPropertyByKey("bug.description");
        String bugPriority = getConfigPropertyByKey("bug.priority");

        // Click Create item
        actions.waitForElementClickable("jira.header.create.menuButton");
        actions.clickElement("jira.header.create.menuButton");

        // Change type to Story
        actions.waitForElementClickable("jira.create.issue.type.button");
        actions.clickElement("jira.create.issue.type.button");

        actions.waitForElementClickable("jira.create.issue.type.selection", "Bug");
        actions.clickElement("jira.create.issue.type.selection", "Bug");

        // Set Summary
        actions.waitForElementClickable("jira.create.issue.summary");
        actions.typeValueInField(bugName, "jira.create.issue.summary");

        // Set Description
        actions.waitForElementClickable("jira.create.issue.description");
        actions.typeValueInField(bugDescription, "jira.create.issue.description");

        // Set Priority
        actions.waitForElementClickable("jira.create.issue.priority.button");
        actions.clickElement("jira.create.issue.priority.button");

        actions.waitForElementClickable("jira.create.issue.priority.type", bugPriority);
        actions.clickElement("jira.create.issue.priority.type", bugPriority);

        // Create
        actions.waitForElementClickable("jira.create.issue.create.button");
        actions.clickElement("jira.create.issue.create.button");
    }

    public void assertCreateBugExists() {
        navigateToPage();
        String bugName = getConfigPropertyByKey("bug.name");

        actions.waitForElementClickable("jira.issue.search");
        actions.typeValueInField(bugName, "jira.issue.search");
        driver.switchTo().activeElement().sendKeys(Keys.RETURN);

        actions.waitForElementPresent("jira.issue.item.summary", bugName);
    }
}