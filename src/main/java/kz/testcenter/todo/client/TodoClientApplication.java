package kz.testcenter.todo.client;

import kz.testcenter.todo.client.domain.ToDo;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class TodoClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner process(ToDoRestClient client) {
        return args -> {
            Iterable<ToDo> toDos = client.findAll();
            assert toDos != null;
            toDos.forEach(toDo -> log.info(toDo.toString()));
        };
    }
}
