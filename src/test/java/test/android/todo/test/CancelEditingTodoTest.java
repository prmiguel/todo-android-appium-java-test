package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class CancelEditingTodoTest extends BaseTest {

    private final String todoText = "Cancel Edit Test";

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        mainScreen.addTodo(todoText);
    }

    @Test(description = "Cancel the editing of a todo item.", groups = {"functional"})
    public void cancelEditingTodo() {
        mainScreen.cancelEditTodo(todoText);
        Assert.assertTrue(mainScreen.isTodoDisplayed(todoText), "Original todo should still be present after canceling edit.");
    }

}
