package com.example.test_from_chmykhalov.controller;

import com.example.test_from_chmykhalov.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }


    @PostMapping
    public ResponseEntity<CopyOnWriteArrayList<CopyOnWriteArrayList<String>>> stringArraysJoining(
            @RequestBody CopyOnWriteArrayList<CopyOnWriteArrayList<String>> inputArray){
        CopyOnWriteArrayList<CopyOnWriteArrayList<String>> outputArray = testService.processingAndJoining(inputArray);
        System.out.println(outputArray);
        return new ResponseEntity<>(outputArray, HttpStatus.OK);
    }
}
