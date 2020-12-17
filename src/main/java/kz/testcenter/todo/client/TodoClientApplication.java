package kz.testcenter.todo.client;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class TodoClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoClientApplication.class, args);
    }

}
