package spring.app.chitchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.app.chitchat.entities.Message;
import spring.app.chitchat.repositories.MessageRepository;

@RestController
@RequestMapping(path="/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageContoller {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping(path="/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        try {
            System.out.println(message);
            messageRepository.save(message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

}
