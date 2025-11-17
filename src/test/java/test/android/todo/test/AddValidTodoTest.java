package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class AddValidTodoTest extends BaseTest {

    @Test(description = "Add a new todo item.", groups = {"functional", "regression"})
    public void addValidTodo() {
        String todoText = "Buy milk";
        mainScreen.addTodo(todoText);

        Assert.assertTrue(mainScreen.isTodoDisplayed(todoText), "Todo item was not added to the list.");
        Assert.assertEquals(mainScreen.getItemCountText(), "1 item left", "Item count is incorrect.");
        Assert.assertTrue(mainScreen.isFilterFabVisible(), "Filter FAB should be visible.");
    }
}
