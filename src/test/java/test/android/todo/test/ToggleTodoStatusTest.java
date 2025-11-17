package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class ToggleTodoStatusTest extends BaseTest {

    private final String todoText = "Toggle me";

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        mainScreen.addTodo(todoText);
    }

    @Test(description = "Mark a todo as complete/incomplete.", groups = {"functional", "regression"})
    public void toggleTodoStatus() {
        // Mark as complete
        mainScreen.toggleTodo(todoText);
        Assert.assertTrue(mainScreen.isTodoChecked(todoText), "Todo should be checked.");
        Assert.assertEquals(mainScreen.getItemCountText(), "0 items left", "Item count is incorrect.");

        // Mark as active again
        mainScreen.toggleTodo(todoText);
        Assert.assertFalse(mainScreen.isTodoChecked(todoText), "Todo should be unchecked.");
        Assert.assertEquals(mainScreen.getItemCountText(), "1 item left", "Item count is incorrect.");
    }
}
