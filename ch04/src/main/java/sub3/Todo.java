package sub3;

public class Todo {
    private String task;
    private boolean completed;

    public Todo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "task='" + task + '\'' +
                ", completed=" + completed +
                '}';
    }

}
