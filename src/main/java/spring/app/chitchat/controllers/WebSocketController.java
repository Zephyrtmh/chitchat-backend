package spring.app.chitchat.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import spring.app.chitchat.entities.Conversation;
import spring.app.chitchat.entities.Message;
import spring.app.chitchat.entities.User;
import spring.app.chitchat.repositories.ConversationRepository;
import spring.app.chitchat.repositories.MessageRepository;
import spring.app.chitchat.repositories.UserRepository;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @MessageMapping("/message") // app/message
    @SendTo("/chatroom/")
    public Message receivePublicMessage(@Payload Message message) throws Exception {
        try {
            System.out.println("receiving message");
            System.out.println(message);
//            int conversationId = message.getMessageId();
            String messageContent = message.getMessageContent();
            System.out.println(messageContent);
            simpMessagingTemplate.convertAndSend("/chatroom/"+2, message);

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return message;

    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message) {
        System.out.println(message);
        User fromUser = userRepository.findById(message.getFromUserId()).get();
        String fromUserName = fromUser.getUsername();
        simpMessagingTemplate.convertAndSendToUser(fromUserName, "/private", message); // /user/{{username}}/private
        return message;
    }

    @MessageMapping("/hello")
    @SendTo("/chatroom/hello")
    public String hello(String message) {
        System.out.println(message);
        return "hello";
    }
}
