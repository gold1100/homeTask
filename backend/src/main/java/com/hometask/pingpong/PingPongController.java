package com.hometask.pingpong;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "status")
public class PingPongController {

    @GetMapping(path = "/ping")
    public String bounceBack(){
        return "pong";
    }
}
