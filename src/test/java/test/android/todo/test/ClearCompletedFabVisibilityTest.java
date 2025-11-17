package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;
import test.android.todo.commons.FilterOption;

public class ClearCompletedFabVisibilityTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setupData() {
        mainScreen.addTodo("Active Task");
        mainScreen.addTodo("Completed Task");
        mainScreen.toggleTodo("Completed Task");
    }

    @Test(description = "Verify the visibility logic for the 'Clear Completed' FAB.", groups = {"ui", "functional"})
    public void clearCompletedFabVisibility() {
        // On "All" filter
        mainScreen.selectFilter(FilterOption.ALL);
        Assert.assertFalse(mainScreen.isClearCompletedFabVisible(), "Clear FAB should be hidden on 'All' filter.");

        // On "Active" filter
        mainScreen.selectFilter(FilterOption.ACTIVE);
        Assert.assertFalse(mainScreen.isClearCompletedFabVisible(), "Clear FAB should be hidden on 'Active' filter.");

        // On "Completed" filter
        mainScreen.selectFilter(FilterOption.COMPLETED);
        Assert.assertTrue(mainScreen.isClearCompletedFabVisible(), "Clear FAB should be visible on 'Completed' filter.");

        // Clear completed items
        mainScreen.clearCompletedTodos();
        Assert.assertFalse(mainScreen.isClearCompletedFabVisible(), "Clear FAB should be hidden after clearing all.");
    }


}
