package main.java.com.example.todo.todo;

//jakarta validation - chekcs that s tring is not blank 
import jakarta.validation.constraints.NotBlank; 

//this class represents JSON sent by client 
public class TodoRequest {
    
    //title cannot be empty or only spaces 
    @NotBlank
    private String title; 

    //stores the compelted value from our reuqest body 
    private boolean completed; 

    public TodoRequest(){

    }

    //returns the title from the request
    public String getTitle(){
        return title; 
    }

    //returns the completed value from the request 
    public boolean isCompleted(){
        return completed; 
    }

    //lets string set the title from json
    public void setTitle(String title){
        this.title = title; 
    }

    public void setCompleted(boolean completed){
        this.completed = completed; 
    }
}
