package com.example.controllers;

import com.example.diffexample.ClientComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {
    private final ClientComponent clientComponent1;
    private final ClientComponent clientComponent2;

    @GetMapping("/")
    public String hello(){
        clientComponent1.operation();
        clientComponent2.operation();
        return "Hello from ClientComponent1 = " + clientComponent1 +
                " and ClientComponent2 = " + clientComponent2;
    }
}
