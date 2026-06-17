package main.java.com.example.todo.Exceptions;

public class TodoNotFoundException extends RuntimeException {
    //constructor accpets the missing todo id 
    public TodoNotFoundException(String id){
        super("To do not found" + id); 
    }
}
