package test.android.todo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class ApplicationLaunchTest extends BaseTest {

    @Test(description = "Application Launch - Empty State", groups = {"smoke"})
    public void applicationLaunchEmptyState() {
        // Verification
        Assert.assertTrue(mainScreen.isTitleDisplayed(), "App title should be visible.");
        Assert.assertTrue(mainScreen.isInputFieldDisplayed(), "Input field should be visible.");
        Assert.assertFalse(mainScreen.isFooterDisplayed(), "Footer should not be visible.");
        Assert.assertFalse(mainScreen.isFilterFabVisible(), "Filter FAB should not be visible.");
    }
}
