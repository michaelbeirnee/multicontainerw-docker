package main.java.com.example.todo.Exceptions;

//gives http status codes like 404
import org.springframework.http.HttpStatus; 

//from spring web - catches a chose exception type 
import org.springframework.web.bind.annotation.ExceptionHandler; 

//from spring web - sets the http status for the response
import org.springframework.web.bind.annotation.ResponseStatus; 

//applies this error handling across REST controllers 
import org.springframework.web.bind.annotation.RestControllerAdvice; 

//builds a simple key-value response
import java.util.Map;

//tells spring this class handes API errors globally 
@RestControllerAdvice 
public class GlobalExceptionHandler {
    //from spring web - runs this function when todonotfoundexceptino occurs 
    @ExceptionHandler(TodoNotFoundException.class); 

    //from spring web - returns http 404 not found 
    @ResponseStatus
    public Map<String, String> handleTodoNotFound(TodoNotFoundException exception){
        return Map.of("Error", exception.getMessage()); 
    }
}
