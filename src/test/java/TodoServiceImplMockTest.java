// Java Program to Illustrate TodoServiceImplMockTest File

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// MockitoJUnitRunner gives automatic validation
// of framework usage, as well as an automatic initMocks()
@RunWith(MockitoJUnitRunner.class)

// Main class
public class TodoServiceImplMockTest {

    TodoServiceImpl todoBusiness;

    @Mock
    TodoService todoServiceMock;

    @Before
    public void setUp() {
        todoBusiness = new TodoServiceImpl(todoServiceMock);
    }

    @Test
    public void injectMockData() {
        //Creating mock data
        List<String> todos = Arrays.asList("Learn Spring", "Learn Java", "Learn Spring Boot");
        //specifying when to inject mock data
        when(todoServiceMock.retrieveTodos("User")).thenReturn(todos);

        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToJava("User");
        assertEquals(1, filteredTodos.size());
    }

    @Test
    public void verifyMockInvokedOrNot() {
        List<String> todos = Arrays.asList("Learn Java", "Java advanced");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToJava("Dummy");
        assertEquals(2, filteredTodos.size());
        verify(todoServiceMock).retrieveTodos("Dummy");
        //verify(todoServiceMock).retrieveTodos("User"); // will fail
    }
}
