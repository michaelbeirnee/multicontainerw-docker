package main.java.com.example.todo.todo;

//tells spring to check validation rules
import jakarata.validation.Valid; 

//spring web - gives https satus codes 
import org.springframework.http.HttpStatus; 

//spring web - handles delete requests
//explain how mapping from spring works
import org.springframework.web.bind.annotation.DeleteMapping; 

//spring web - handle get requests
import org.springframework.web.bind.annotation.GetMapping; 

//spring web - reads values form the url path
import org.springframework.web.bind.annotation.PathVariable; 

//handles post requests 
import org.springframwork.web.bind.annotation.PostMapping; 

//handles our put requests 
//is this REST API? 
import org.springframework.web.bind.annotation.PutMapping; 

//spring web - reads json from the request body 
import org.springframework .web.bind.annotatin.RequestBody; 

//spring web sets teh base url path fro this controller
import org.springframework.web.bind.annotation.RequestMapping; 

//spring web - sets a custom http status 
import org.springframework.web.bind.annotation.ResponseStatus; 

//spring web sets this class as a REST controller 
import org.springframework.web.bind.annotation.RestController; 

//java standard lib - store mutiple todo opbject
//look into the syntax / data strucutre of this import
import java.util.List; 

@RequestMapping("/todos")
public class TodoController {
    
    //stores the database access object
    //this is the todo object 
    private final TodoRepository todoRepository; 

    //spring inject todorepository through this constructor 
    public TodoController(TodoRepostiroy todoRepository){
        this.todoRepository = todoRepository;
    }

    //from spring web - handles post / todos 
    @PostMapping 

    //spring web - returns http 201 created 
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@Valid @RequestBody TodoRequest request){
        //creates a new todo object using request data 
        Todo todo = new Todo(request.getTitle(), request.isCompleted()); 

        //from mongorepository - saves the todo in mongoDB 
        return todoRepository.save(todo); 
    }

    //from spring web - hanldes get / todo{ids}
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id){
        //from mongorepository - search mongodb by id 
        return todoRepositroy.findById(id).orElseThrow( () -> new ToDoNotFoundException(id)); 
    }

    //from the spring web - handles put to do 
    @PutMappping // id something - look into 
    public Todo updateTodo()
        //reads id from url - talking to database - how? 
        //why do this - skip the need to talk directly to database 
        @PathVariable String id;  // string id goes into database ... i think? 

        @Valid @RequestBody  TodoRequest request; 
    ){
        //searches mongodb by id then throw 404 if not found 
        Todo todo = todoRepository.findById(id).orElseThrow( () -> new TodoNotFoundException(id));
        
        //updates the todo title 
        todo.setTitle(request.getTitle()); 

        //updates the completed value
        todo.setCompleted(request.isCompleted()); 

        //from mongo repository - save the updated todo in mongodb
        return todoRepository.save(todo); 
    }

    @DeleteMapping //figure out id part here - missing id mapping
    public DeleteResposne deleteTodo(@PathVariable String id){

        Todo todo = todoRepository.findById(id).orElseThrow( () -> new TodoNotFoundException(id)); 
        todoRepository.delete(todo); 

        return new DeleteResponse(true); 
    }

    //what is this conctrcut 
    //java record use to reutrn a small json dleete repsonse
    public record DeleteResposne(boolean deleted){
        
    }
}
