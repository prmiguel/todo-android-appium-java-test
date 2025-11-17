package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class FabVisibilityLogicTest extends BaseTest {

    @Test(description = "Verify the visibility logic for the main filter FAB.", groups = {"ui", "regression"})
    public void fabVisibilityLogic() {
        // Initial state
        Assert.assertFalse(mainScreen.isFilterFabVisible(), "FAB should be hidden initially.");

        // Add one todo
        mainScreen.addTodo("Test task");
        Assert.assertTrue(mainScreen.isFilterFabVisible(), "FAB should be visible after adding a todo.");

        // Delete the todo
        mainScreen.deleteTodo("Test task");
        Assert.assertFalse(mainScreen.isFilterFabVisible(), "FAB should be hidden after deleting the last todo.");
    }

}
