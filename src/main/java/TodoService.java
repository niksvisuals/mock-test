// Java Program to Illustrate TodoService File

// Importing List class
import java.util.List;

// Interface
public interface TodoService {

    // A method that relies on external source like DB or API for data
    public List<String> retrieveTodos(String user);
}
