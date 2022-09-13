package spring.app.chitchat.controllers;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSocketController {

    @MessageMapping("/send/message")
    @SendTo("/topic/message")
    public void sendMessage(String message) {
        System.out.println(message);

    }
}
