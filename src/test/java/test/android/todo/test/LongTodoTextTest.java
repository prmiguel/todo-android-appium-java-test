package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class LongTodoTextTest extends BaseTest {

    @Test(description = "Add a todo with very long text.", groups = {"ui"})
    public void longTodoText() {
        String longText = "This is a very long todo item that should wrap to multiple lines and not break the application layout in any way. It contains a lot of text to test the UI's resilience.";
        mainScreen.addTodo(longText);

        Assert.assertTrue(mainScreen.isTodoDisplayed(longText), "Todo with long text should be displayed.");
        Assert.assertTrue(mainScreen.isTodoDisplayed("..."), "Todo text should be truncated or wrapped correctly.");
    }

}
