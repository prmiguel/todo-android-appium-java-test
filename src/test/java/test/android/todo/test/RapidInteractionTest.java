package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;
import test.android.todo.commons.FilterOption;

public class RapidInteractionTest extends BaseTest {

    @Test(description = "Perform rapid clicks and scrolls.", groups = {"robustness", "regression"})
    public void rapidInteraction() throws InterruptedException {
        // Add many todos
        for (int i = 0; i < 20; i++) {
            mainScreen.addTodo("Task " + i);
        }
        Assert.assertEquals(mainScreen.getTodoListSize(), 20, "All todos should be added.");

        // Rapidly toggle
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mainScreen.toggleTodo("Task " + i);
            }
        }

        // Rapidly switch filters
        mainScreen.selectFilter(FilterOption.ACTIVE);
        mainScreen.selectFilter(FilterOption.COMPLETED);
        mainScreen.selectFilter(FilterOption.ALL);

        // Final verification
        Assert.assertEquals(mainScreen.getTodoListSize(), 20, "List should still contain 20 items.");
        Assert.assertEquals(mainScreen.getItemCountText(), "10 items left", "Item count should be 10.");
    }


}
