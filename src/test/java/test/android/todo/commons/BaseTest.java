package test.android.todo.commons;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import test.android.todo.pages.MainScreen;
import test.android.todo.utils.AndroidDriverTodoApp;

public class BaseTest {
    protected MainScreen mainScreen;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("appium.app.url", "https://prmiguel.github.io/todo-android-app/todo-debug.apk");
        System.setProperty("appium.server.url", "http://192.168.0.33:4723/wd/hub");
        AndroidDriverTodoApp.getDriver();
        mainScreen = new MainScreen();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        AndroidDriverTodoApp.quitDriver();
    }
}