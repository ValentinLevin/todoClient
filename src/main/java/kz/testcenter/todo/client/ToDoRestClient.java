package kz.testcenter.todo.client;

import kz.testcenter.todo.client.error.ToDoErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ToDoRestClient {
    private final RestTemplate restTemplate;
    private final ToDoRestClientProperties properties;

    @Autowired
    public ToDoRestClient(ToDoRestClientProperties properties) {
        this.properties = properties;
        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(new ToDoErrorHandler());
    }

}
