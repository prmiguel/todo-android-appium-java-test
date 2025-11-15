package test.android.todo.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;
import java.time.Duration;

public final class AndroidDriverTodoApp {
    private static AndroidDriver driver;

    private AndroidDriverTodoApp() {
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setApp(new URL(System.getProperty("appium.app.url")));
                options.setNewCommandTimeout(Duration.ofSeconds(20));

                driver = new AndroidDriver(new URL(System.getProperty("appium.server.url")), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize Appium driver.");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}