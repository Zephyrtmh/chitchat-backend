package spring.app.chitchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import spring.app.chitchat.entities.Conversation;
import spring.app.chitchat.entities.Message;
import spring.app.chitchat.repositories.ConversationRepository;
import spring.app.chitchat.repositories.MessageRepository;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path="/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageContoller {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @PutMapping(path="/add/{conversationId}")
    public ResponseEntity<Message> addMessageToConversation(@RequestBody Message message, @PathVariable(name="conversationId") int conversationId) {
        try {
            Conversation conversation = conversationRepository.findById(conversationId).get();
            message.setConversation(conversation);
            Message messageSaved = messageRepository.save(message);
            List<Message> currMessages = conversation.getMessages();
            currMessages.add(messageSaved);
            conversation.setMessages(currMessages);
            conversationRepository.save(conversation);

            return new ResponseEntity<>(message, HttpStatus.OK);

        }
        catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(path="/get/messages/{conversationId}")
    public List<Message> getMessagesFromConversation(@PathVariable(value="conversationId") int conversationId) {
        Conversation conversation = conversationRepository.findById(conversationId).get();
        System.out.println(conversation.getMessages());
        return conversation.getMessages();
    }


    //websocket methods
    @MessageMapping("/test")
    @SendTo("/topic/testing")
    public Message testing(@RequestBody Message message) {
        String messageContent = message.getMessageContent();
        System.out.println(messageContent);
        return message;
    }

}
