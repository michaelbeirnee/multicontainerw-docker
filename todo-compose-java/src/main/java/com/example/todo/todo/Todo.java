//puts this class in the todo feature package 
package main.java.com.example.todo.todo;

//from spring - data - this field as the MongoBD id 
import org.springframework.data.annotation.Id; 

//from spring data mongodb - connects this vaava class to MongoDb collection
import org.springframework.data.mongodb.core.mapping.Document; 

//java standard library for data / time
import java.time.instant; 

@Document(collection = "todo") 
public class Todo {
    
    //from spring data - tells database / mongodb this is unqiue id 
    @Id 
    private String id; 

    //stores todo tittle 
    private String title; 

    //is task finished or not 
    private boolean completed; 

    //sotres when the todo was created
    private Instant createdAt; 

    //stores when the todo was upadted 
    private Instant updatedAt;
    
    //empty constructer reuqired by spring 
    public Todo(){
    }

    public Todo(String title, boolean completed){
        this.title = title; 
        this.completed = completed;
        this.createdAt = createdAt; 
        this.updatedAt = updatedAt; 
    }

    public String getId(){
        return id; 
    }

    public String getTitle{
        return title; 
    }

    public boolean isCompleted(){
        return completed; 
    }

    public Instant getCreatedAt(){
        return createdAt; 
    }

    public Instant getUpdatedAt(){
        return updatedAt; 
    }

    public void setTitle(String title){
        this.title = title; 
        updatedAt = Instant.now(); 
    }

    public void setCompleted(boolean completed){
        this.completed = completed; 
        updatedAt = Instant.now(); 
    }
}
