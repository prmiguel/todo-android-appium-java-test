package test.android.todo.commons;

public enum FilterOption {
    ALL("all"),
    ACTIVE("active"),
    COMPLETED("completed");

    private final String filter;

    FilterOption(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return this.filter;
    }
}
