package com.mandarin.PP_3_1_6_REST_API;

import com.mandarin.PP_3_1_6_REST_API.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpringRestClient {
    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://localhost:8080/api/users";
    private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/users/{id}";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/users";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/users";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/users/{id}";
    private static RestTemplate restTemplate = new RestTemplate();



    public static void main(String[] args) {
        SpringRestClient springRestClient = new SpringRestClient();

        // Step1: first create a new employee
        springRestClient.createUser();

        // Step 2: get new created employee from step1
        springRestClient.getUserById();

        // Step3: get all employees
        springRestClient.getUsers();

        // Step4: Update employee with id = 3
        springRestClient.updateUser();

        // Step5: Delete employee with id = 3
        springRestClient.deleteUser();
    }
    private void getUsers() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
                String.class);

        System.out.println(result);
    }

    private void getUserById() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "3");

        RestTemplate restTemplate = new RestTemplate();
        User result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, User.class, params);

        System.out.println(result);
    }

    private void createUser() {

        User newUser = new User(3L,"James", "Brown", (byte) 55);

        RestTemplate restTemplate = new RestTemplate();
        User result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newUser, User.class);

        System.out.println(result);
    }

    private void updateUser() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("id", "3");
        User updatedUser = new User(3L,"Thomas", "Shelby", (byte) 55);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedUser);
    }

    private void deleteUser() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "3");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DELETE_EMPLOYEE_ENDPOINT_URL, params);
    }
}
