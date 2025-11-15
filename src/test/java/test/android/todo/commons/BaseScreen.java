package test.android.todo.commons;

import io.appium.java_client.android.AndroidDriver;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.android.todo.utils.AndroidDriverTodoApp;

import java.time.Duration;

@Getter(AccessLevel.PROTECTED)
public class BaseScreen {
    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public BaseScreen() {
        driver = AndroidDriverTodoApp.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
