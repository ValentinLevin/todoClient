package kz.testcenter.todo.client;

import kz.testcenter.todo.client.domain.ToDo;
import kz.testcenter.todo.client.error.ToDoErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

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

    public Iterable<ToDo> findAll() throws URISyntaxException {
        RequestEntity<Iterable<ToDo>> requestEntity =
                new RequestEntity<>(HttpMethod.GET, new URI(properties.getUrl() + properties.getBasePath() + "/todo"));

        ResponseEntity<Iterable<ToDo>> response =
                restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Iterable<ToDo>>(){});
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }

        return null;
    }

}
