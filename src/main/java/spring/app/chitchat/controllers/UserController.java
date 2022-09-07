package spring.app.chitchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.app.chitchat.entities.Conversation;
import spring.app.chitchat.entities.User;
import spring.app.chitchat.repositories.ConversationRepository;
import spring.app.chitchat.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins = {"https://zephyrtmh.github.io", "http://localhost:4200"})
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    @GetMapping(path="/get/{userId}")
    public User getUser(@PathVariable(value="userId") Integer userId) {
        return userRepository.findById(userId).get();
    }
    @GetMapping(path="/get/all")
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping(path="/add")
    public User addUser(@RequestBody User userToAdd) {
        userRepository.save(userToAdd);
        return userToAdd;
    }

    @PutMapping(path="{userId}/addToConversation/{conversationId}")
    public User addUserToConversation(
            @PathVariable(name="userId") int userId,
            @PathVariable(name="conversationId") int conversationId
    ) {
        User user = userRepository.findById(userId).get();
        Conversation conversation = conversationRepository.findById(conversationId).get();
        user.addUserToConversation(conversation);
        return user;
    }
}
