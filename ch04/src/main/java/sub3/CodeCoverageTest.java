package sub3;

import java.util.List;

public class CodeCoverageTest {
    public static void main(String[] args) {

        TodoManager tm = new TodoManager();

        tm.addTodo("독서하기");
        tm.addTodo("운동하기");
        tm.addTodo("코딩하기");
        tm.addTodo("자바하기");
        tm.addTodo("집에가기");

        tm.setTodoCompleted("독서하기");
        tm.setTodoCompleted("코딩하기");

        List<Todo> doneTodo = tm.getCompletedTodos();
        for(Todo todo : doneTodo){
            System.out.println(todo);
        }
        System.out.println("-----------------------");
        for(Todo todo : tm.getAllTodos()){
            System.out.println(todo);
        }


    }
}