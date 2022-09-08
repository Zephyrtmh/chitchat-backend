package spring.app.chitchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.app.chitchat.entities.Conversation;
import spring.app.chitchat.repositories.ConversationRepository;

import java.util.List;

@RestController
@RequestMapping(path="/conversation")
public class ConversationController {

    @Autowired
    private ConversationRepository conversationRepository;

    @GetMapping(path="/get/{conversationId}")
    public ResponseEntity<Conversation> getConversation(@PathVariable(value="conversationId") Integer conversationId) {
        Conversation conversation = null;
        try {
            conversation = conversationRepository.findById(conversationId).get();
            return new ResponseEntity<>(conversation, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(conversation, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/get/all")
    public ResponseEntity<List<Conversation>> getAllConversations() {
        List<Conversation> conversations = null;
        try {
            conversations = conversationRepository.findAll();
            return new ResponseEntity<>(conversations, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(conversations, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/add")
    public ResponseEntity<Conversation> addConversation(@RequestBody Conversation conversationToAdd) {
        Conversation conversation = null;
        try {
            conversation = conversationRepository.save(conversationToAdd);
            return new ResponseEntity<>(conversation, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(conversation, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path="/get/usersInConversation/{conversationId}")
    public ResponseEntity<List<Integer>> getUsersInConversation(@PathVariable(value="conversationId") int conversationId) {
        try {
            List<Integer> userIdsInConversation = conversationRepository.getUsersByConversationId(conversationId);
            return new ResponseEntity<>(userIdsInConversation, HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}


