package test.android.todo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.android.todo.commons.BaseScreen;

@Getter(AccessLevel.PROTECTED)
public class MainElements extends BaseScreen {

    // Header
    @AndroidFindBy(id = "app.android.todomvc:id/etNewTodo")
    private WebElement newTodoInput;

    // List
    @AndroidFindBy(id = "app.android.todomvc:id/rvTodos")
    private WebElement todoList;

    // Footer
    @AndroidFindBy(id = "app.android.todomvc:id/tvItemCount")
    private WebElement itemCount;

    // FABs
    @AndroidFindBy(id = "app.android.todomvc:id/fabFilter")
    private WebElement filterFab;
    @AndroidFindBy(id = "app.android.todomvc:id/fabFilterAll")
    private WebElement filterAllFab;
    @AndroidFindBy(id = "app.android.todomvc:id/fabFilterActive")
    private WebElement filterActiveFab;
    @AndroidFindBy(id = "app.android.todomvc:id/fabFilterCompleted")
    private WebElement filterCompletedFab;
    @AndroidFindBy(id = "app.android.todomvc:id/fabClearCompleted")
    private WebElement clearCompletedFab;

    public MainElements() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
}
