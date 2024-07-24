package com.mandarin.PP_3_1_6_REST_API.controller;

import com.mandarin.PP_3_1_6_REST_API.model.User;
import com.mandarin.PP_3_1_6_REST_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/users")
    public void addUser(User user) {
        userService.saveUser(user);
    }

    @PutMapping("/users")
    public void changeUser(User user) {
        userService.updateUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getById(id);
    }



    /*@Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(" http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(user,headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }


    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/products/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }*/




}
