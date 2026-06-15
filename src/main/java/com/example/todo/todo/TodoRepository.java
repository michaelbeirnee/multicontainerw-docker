package main.java.com.example.todo.todo;

//from spring data mongodb - gives built in database actions 
import org.springframework.data.mongodb.MongoRepository; 

//this interface gives database access for todo objects with string ids 
public interface TodoRepository extends MongoRepository<Todo, String>{

}