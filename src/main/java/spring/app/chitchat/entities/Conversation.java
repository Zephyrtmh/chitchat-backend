package spring.app.chitchat.entities;

import javax.persistence.*;
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
    private Set<Message> messages;

    public Conversation(int conversationId, String conversationName, Set<Message> messages) {
        this.conversationId = conversationId;
        this.conversationName = conversationName;
        this.messages = messages;
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

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
