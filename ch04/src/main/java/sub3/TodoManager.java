package sub3;

import java.util.ArrayList;
import java.util.List;

public class TodoManager {

    private List<Todo> todos;

    public TodoManager() {
        todos = new ArrayList<>();
    }

    public void addTodo(String task){
        todos.add(new Todo(task, false));
    };

    public void setTodoCompleted(String task){
        for(Todo todo : todos){
            if(task.equals(todo.getTask())){
                todo.setCompleted(true);
                return;
            }
        }
    };

    public List<Todo> getCompletedTodos(){
        List<Todo> completedTodos = new ArrayList<>();
        for(Todo todo : todos){
            if(todo.isCompleted()){
                completedTodos.add(todo);
            }
        }
        return completedTodos;
    };

    public List<Todo> getAllTodos(){
        return todos;
    };


}
