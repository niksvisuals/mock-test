// Java Program to Illustrate TodoServiceImpl File

// Importing required classes

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl {

    private TodoService todoService;

    public TodoServiceImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToJava(String user) {

        List<String> filteredTodos = new ArrayList<>();
        //Get list of Todos using helper TodoService --- injecting Mock data
        List<String> todos = todoService.retrieveTodos(user);

        // processing of data
        for (String todo : todos) {
            if (todo.contains("Java")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
