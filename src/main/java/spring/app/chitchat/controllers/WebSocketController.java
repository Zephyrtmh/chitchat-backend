package spring.app.chitchat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import spring.app.chitchat.entities.Message;
import spring.app.chitchat.entities.User;
import spring.app.chitchat.repositories.UserRepository;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserRepository userRepository;

    @MessageMapping("/message") // app/message
    @SendTo("/chatroom/public")
    public Message receivePublicMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message) {
        User fromUser = userRepository.findById(message.getFromUserId()).get();
        String fromUserName = fromUser.getUsername();
        simpMessagingTemplate.convertAndSendToUser(fromUserName, "/private", message); // /user/{{username}}/private
        return message;
    }
}
