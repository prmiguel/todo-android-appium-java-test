package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class DeleteTodoItemTest extends BaseTest {

    private final String todoText = "To be deleted";

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        mainScreen.addTodo(todoText);
    }

    @Test(description = "Delete a single todo item.", groups = {"functional", "regression"})
    public void deleteTodoItem() {
        mainScreen.deleteTodo(todoText);

        Assert.assertFalse(mainScreen.isTodoDisplayed(todoText), "Todo should be deleted.");
        Assert.assertEquals(mainScreen.getTodoListSize(), 0, "List should be empty.");
        Assert.assertFalse(mainScreen.isFooterDisplayed(), "Footer should be hidden.");
    }

}
