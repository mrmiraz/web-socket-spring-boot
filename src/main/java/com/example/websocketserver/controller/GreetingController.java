package com.example.websocketserver.controller;

import com.example.websocketserver.model.Greeting;
import com.example.websocketserver.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
//        Thread.sleep(500); // simulated delay
        System.out.println(message.getName());
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }
}
