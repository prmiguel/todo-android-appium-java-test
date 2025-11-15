package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;
import test.android.todo.commons.FilterOption;

public class FilterByCompletedTest extends BaseTest {

    @Test(
            description = "Verify the 'Completed' filter functionality.",
            groups = {"functional", "regression"})
    public void filterByCompleted() {
        // Arrange
        mainScreen.addTodo("Active Task 1");
        mainScreen.addTodo("Completed Task 1");
        mainScreen.toggleTodo("Completed Task 1");

        // Action
        mainScreen.selectFilter(FilterOption.COMPLETED);

        // Assert
        Assert.assertTrue(mainScreen.isTodoDisplayed("Completed Task 1"),
                "Completed task should be visible.");
        Assert.assertFalse(mainScreen.isTodoDisplayed("Active Task 1"),
                "Active task should be hidden.");
        Assert.assertTrue(mainScreen.isClearCompletedFabVisible(),
                "Clear Completed FAB should be visible.");
    }
}
