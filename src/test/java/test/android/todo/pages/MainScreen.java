package test.android.todo.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.android.todo.commons.FilterOption;

public class MainScreen extends MainElements {

    // --- Actions ---
    public void addTodo(String text) {
        getNewTodoInput().click();
        getNewTodoInput().sendKeys(text);
        getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void toggleTodo(String text) {
        getDriver().hideKeyboard();
        getDriver().findElement(By.xpath(String.format("//android.widget.TextView[@resource-id=\"app.android.todomvc:id/tvTitle\" and @text=\"%s\"]/preceding-sibling::android.widget.CheckBox", text)))
                .click();
    }

    public void editTodo(String originalText, String newText) {
        WebElement todo = findTodoElementByText(originalText);
        todo.click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/input")));
        WebElement input = getDriver().findElement(By.id("android:id/input"));
        input.clear();
        input.sendKeys(newText);
        getDriver().findElement(By.id("android:id/button1")).click(); // OK button
    }

    public void deleteTodo(String text) {
        WebElement todo = findTodoElementByText(text);
        todo.findElement(By.id("app.android.todomvc:id/btnDelete")).click();
    }

    public void selectFilter(FilterOption filterOption) {
        getFilterFab().click();
        switch (filterOption) {
            case ALL:
                getFilterAllFab().click();
                break;
            case ACTIVE:
                getFilterActiveFab().click();
                break;
            case COMPLETED:
                getFilterCompletedFab().click();
                break;
        }
    }

    public void clearCompletedTodos() {
        getClearCompletedFab().click();
    }

    // --- Verifications ---
    public boolean isTodoDisplayed(String text) {
        try {
            findTodoElementByText(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTodoChecked(String text) {
        WebElement todo = findTodoElementByText(text);
        return todo.findElement(By.id("app.android.todomvc:id/cbCompleted")).isSelected();
    }

    public String getItemCountText() {
        return getWait().until(ExpectedConditions.visibilityOf(super.getItemCount())).getText();
    }

    public boolean isFilterFabVisible() {
        return getFilterFab().isDisplayed();
    }

    public boolean isClearCompletedFabVisible() {
        return getClearCompletedFab().isDisplayed();
    }

    public int getTodoListSize() {
        getWait().until(ExpectedConditions.visibilityOf(getTodoList()));
        return getDriver().findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout")).size();
    }

    // --- Helper ---
    private WebElement findTodoElementByText(String text) {
        String uiAutomator = "new UiSelector().text(\"" + text + "\")";
        return getDriver().findElement(new MobileBy.ByAndroidUIAutomator(uiAutomator));
    }
}
