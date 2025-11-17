package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;
import test.android.todo.commons.FilterOption;

public class FilterByActiveTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setupData() {
        mainScreen.addTodo("Active Task 1");
        mainScreen.addTodo("Completed Task 1");
        mainScreen.toggleTodo("Completed Task 1");
    }

    @Test(description = "Verify the 'Active' filter functionality.", groups = {"functional", "regression"})
    public void filterByActive() {
        mainScreen.selectFilter(FilterOption.ACTIVE);

        Assert.assertTrue(mainScreen.isTodoDisplayed("Active Task 1"), "Active task should be visible.");
        Assert.assertFalse(mainScreen.isTodoDisplayed("Completed Task 1"), "Completed task should be hidden.");
    }

}
