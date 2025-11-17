package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class EditTodoItemTest extends BaseTest {

    private final String originalText = "Original Task";
    private final String newText = "Edited Task";

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        mainScreen.addTodo(originalText);
    }

    @Test(description = "Edit the text of an existing todo.", groups = {"functional", "regression"})
    public void editTodoItem() {
        mainScreen.editTodo(originalText, newText);

        Assert.assertFalse(mainScreen.isTodoDisplayed(originalText), "Original todo should be gone.");
        Assert.assertTrue(mainScreen.isTodoDisplayed(newText), "Edited todo should be visible.");
    }

}
