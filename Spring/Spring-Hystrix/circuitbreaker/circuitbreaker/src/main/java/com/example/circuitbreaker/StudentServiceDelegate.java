package com.example.circuitbreaker;

import java.util.Date;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callStudentService_Fallback")
    public String callStudentService(String schoolname) {
        System.out.println("Getting School details for " + schoolname);

        String response = restTemplate
                .exchange("http://localhost:8098/getStudentDetailsForSchool/{schoolname}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, schoolname).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - School Name -  " + schoolname + " :::  " +
                " Student Details " + response + " -  " + new Date();
    }

    private String callStudentService_Fallback(String schoolname) {
        System.out.println("Student Service is down!!! fallback route enabled...");

        return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. " +
                " Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
