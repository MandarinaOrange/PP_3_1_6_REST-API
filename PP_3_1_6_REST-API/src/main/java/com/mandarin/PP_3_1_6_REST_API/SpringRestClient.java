package com.mandarin.PP_3_1_6_REST_API;

import com.mandarin.PP_3_1_6_REST_API.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpringRestClient {
    private static final String GET_EMPLOYEES_ENDPOINT_URL = "http://94.198.50.185:7081/api/users";
    private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://94.198.50.185:7081/api/users/3";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://94.198.50.185:7081/api/users";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://94.198.50.185:7081/api/users";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://94.198.50.185:7081/api/users/3";
    //private static RestTemplate restTemplate = new RestTemplate();

    private static String res = "";



    public static void main(String[] args) {
        SpringRestClient springRestClient = new SpringRestClient();

        String cookie = springRestClient.getUsers();

        // Step1: first create a new employee
        springRestClient.createUser(cookie);

        // Step 2: get new created employee from step1
        //springRestClient.getUserById();

        // Step3: get all employees
        //springRestClient.getUsers();

        // Step4: Update employee with id = 3
        springRestClient.updateUser(cookie);

        // Step5: Delete employee with id = 3
        springRestClient.deleteUser(cookie);

        System.out.println("\n\n\n" + res);
    }
    private String getUsers() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        //ResponseEntity<String> result = restTemplate.exchange(GET_EMPLOYEES_ENDPOINT_URL, HttpMethod.GET, entity,
          //      String.class);

        ResponseEntity<String> result = restTemplate.getForEntity(GET_EMPLOYEES_ENDPOINT_URL, null, String.class);
        return result.getHeaders().get("Set-Cookie").get(0);

        //System.out.println(cookie);
    }

    private void createUser(String cookie) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", cookie);

        User newUser = new User();
        newUser.setId(3L);
        newUser.setName("James");
        newUser.setLastName("Brown");
        newUser.setAge((byte) 18);

        HttpEntity<User> requestEntity = new HttpEntity<>(newUser, headers);
        //System.out.println(requestEntity.getHeaders());
        ResponseEntity<String> responseEntity = restTemplate.exchange(CREATE_EMPLOYEE_ENDPOINT_URL,
                HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        res = res + responseEntity.getBody();
        //System.out.println(responseEntity.getHeaders().get("Set-Cookie").toString());
        //System.out.println(cookie);
        //return res


        //RestTemplate restTemplate = new RestTemplate();
        //User result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, newUser, User.class);

        //System.out.println(result);
    }

    private void updateUser(String cookie) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", cookie);
        User updatedUser = new User((long) 3,"Thomas", "Shelby", (byte) 18);
        Map<String, String> params = new HashMap<>();
        params.put("id", "3");
        //params.put("name", "Thomas");
        //params.put("lastName", "Shelby");
        //params.put("age", "18");
        HttpEntity<User> requestEntity = new HttpEntity<>(updatedUser, headers);
        restTemplate.setErrorHandler(new HandlerError());
        ResponseEntity<String> responseEntity = restTemplate.exchange(UPDATE_EMPLOYEE_ENDPOINT_URL,
                HttpMethod.PUT, requestEntity, String.class, params);

        System.out.println(responseEntity.getBody());
        //System.out.println(responseEntity.getHeaders().get("Set-Cookie").toString());
        res = res + responseEntity.getBody();



        //RestTemplate restTemplate = new RestTemplate();

        //restTemplate.put(UPDATE_EMPLOYEE_ENDPOINT_URL, updatedUser);


        //System.out.println(cookie);


    }

    private void deleteUser(String cookie) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", cookie);
        Map<String, String> params = new HashMap<>();
        params.put("id", "3");
        HttpEntity<String> entity = new HttpEntity<>("params", headers);
        restTemplate.setErrorHandler(new HandlerError());
        ResponseEntity<String> responseEntity = restTemplate.exchange(DELETE_EMPLOYEE_ENDPOINT_URL,
                    HttpMethod.DELETE, entity, String.class);

        System.out.println(responseEntity.getBody());
        //System.out.println(responseEntity.getHeaders().get("Set-Cookie").toString());
        res = res + responseEntity.getBody();




        ResponseEntity<String> result = restTemplate.exchange(DELETE_EMPLOYEE_ENDPOINT_URL, HttpMethod.DELETE, entity,
                String.class);
    }
}
