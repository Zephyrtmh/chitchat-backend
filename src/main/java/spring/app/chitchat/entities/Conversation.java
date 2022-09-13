package spring.app.chitchat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONVERSATION_ID")
    private int conversationId;
    @Column(name="CONVERSATION_NAME")
    private String conversationName;

    @OneToMany(mappedBy = "conversation")
    private List<Message> messages;

    @ManyToMany(mappedBy = "conversations")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Conversation() {

    }

    public Conversation(int conversationId, String conversationName, List<Message> messages, Set<User> users) {
        this.conversationId = conversationId;
        this.conversationName = conversationName;
        this.messages = messages;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Messages : " + this.getMessages()+", Users: " + this.getUsers();
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationName() {
        return conversationName;
    }

    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUserToConversation(User user) {
        this.users.add(user);
    }
}
