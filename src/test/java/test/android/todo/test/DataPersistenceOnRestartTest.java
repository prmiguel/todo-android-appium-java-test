package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class DataPersistenceOnRestartTest extends BaseTest {

    @Test(description = "Verify todos are saved and restored on app restart.", groups = {"persistence", "smoke"})
    public void dataPersistenceOnRestart() {
        String todoText = "Persistent Task";
        mainScreen.addTodo(todoText);
        mainScreen.toggleTodo(todoText);

        mainScreen.reopen();

        Assert.assertTrue(mainScreen.isTodoDisplayed(todoText), "Todo was not restored after restart.");
        Assert.assertTrue(mainScreen.isTodoChecked(todoText), "Todo state was not restored after restart.");
    }

}
