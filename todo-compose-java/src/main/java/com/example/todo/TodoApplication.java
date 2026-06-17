package main.java.com.example.todo;


import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 

//anotation tells spring boot to scan this package and start the app
@SpringBootApplication 
public class TodoApplication {
    //java starts the spring boot app from here 
    public static void main(String[] args){
        SpringBootApplication(TodoApplication.class, args); 
    }
}
