package test.android.todo.test;

import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.android.todo.commons.BaseTest;

public class DataPersistenceOnRotationTest extends BaseTest {

    @Test(description = "Verify todos survive a screen rotation.", groups = {"persistence", "regression"})
    public void dataPersistenceOnRotation() {
        String todoText = "Rotation Test";
        mainScreen.addTodo(todoText);

        mainScreen.rotate(ScreenOrientation.LANDSCAPE);
        Assert.assertTrue(mainScreen.isTodoDisplayed(todoText), "Todo should be visible in landscape.");

        mainScreen.rotate(ScreenOrientation.PORTRAIT);
        Assert.assertTrue(mainScreen.isTodoDisplayed(todoText), "Todo should be visible in portrait.");
    }

}
