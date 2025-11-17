package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class AddEmptyTodoTest extends BaseTest {

    @Test(description = "Attempt to add an empty or whitespace-only todo.",
            groups = {"functional", "regression"})
    public void addEmptyTodo() {
        mainScreen.addTodo("   ");
        Assert.assertEquals(mainScreen.getTodoListSize(), 0, "Empty todo should not be added.");
        Assert.assertFalse(mainScreen.isFilterFabVisible(), "Filter FAB should not be visible.");
    }
}
