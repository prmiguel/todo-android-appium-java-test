package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;
import test.android.todo.commons.FilterOption;

public class ClearCompletedTodosTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setupData() {
        mainScreen.addTodo("Active Task 1");
        mainScreen.addTodo("Completed Task 1");
        mainScreen.addTodo("Completed Task 2");
        mainScreen.toggleTodo("Completed Task 1");
        mainScreen.toggleTodo("Completed Task 2");
    }

    @Test(description = "Verify the 'Clear Completed' functionality.", groups = {"functional", "regression"})
    public void clearCompletedTodos() {
        mainScreen.selectFilter(FilterOption.COMPLETED);
        Assert.assertEquals(mainScreen.getTodoListSize(), 2, "There should be 2 completed tasks.");

        mainScreen.clearCompletedTodos();
        Assert.assertEquals(mainScreen.getTodoListSize(), 0, "Completed list should be empty.");

        mainScreen.selectFilter(FilterOption.ALL);
        Assert.assertTrue(mainScreen.isTodoDisplayed("Active Task 1"), "Active task should still exist.");
        Assert.assertEquals(mainScreen.getTodoListSize(), 1, "Only one task should remain.");
    }

}
