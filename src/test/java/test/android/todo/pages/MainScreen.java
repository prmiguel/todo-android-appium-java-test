package test.android.todo.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
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
        todoCheckboxByText(text).click();
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

    public void cancelEditTodo(String originalText) {
        WebElement todo = findTodoElementByText(originalText);
        todo.click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button2"))).click(); // Cancel button
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
        return todoCheckboxByText(text).isSelected();
    }

    public String getItemCountText() {
        return getWait().until(ExpectedConditions.visibilityOf(super.getItemCount())).getText();
    }

    public boolean isTitleDisplayed() {
        return getTitle().isDisplayed();
    }

    public boolean isInputFieldDisplayed() {
        return getNewTodoInput().isDisplayed();
    }

    public boolean isFooterDisplayed() {
        try {
            return getFooter().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFilterFabVisible() {
        try {
            return getFilterFab().isDisplayed();
        } catch (Exception e) {
            return false;
        }
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

    public void rotate(ScreenOrientation orientation) {
        getDriver().rotate(orientation);
    }

    public void reopen() {
        getDriver().terminateApp("app.android.todomvc");
        getDriver().activateApp("app.android.todomvc");
    }
}
