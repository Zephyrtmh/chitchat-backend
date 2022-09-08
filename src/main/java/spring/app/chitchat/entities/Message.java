package spring.app.chitchat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MESSAGE_ID")
    private int messageId;
    @Column(name="FROM_USER_ID")
    private int fromUserId;
    @Column(name="SENT_DATE_TIME")
    private LocalDateTime sentDateTime;
    @Column(name="TEXT_CONTENT")
    private String textContent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="CONVERSATION_ID", referencedColumnName = "CONVERSATION_ID")
    @JsonIgnore
    private Conversation conversation;

    public Message() {

    }

    public Message(int messageId, int fromUserId, LocalDateTime sentDateTime, String textContent, Conversation conversation) {
        this.messageId = messageId;
        this.fromUserId = fromUserId;
        this.sentDateTime = sentDateTime;
        this.textContent = textContent;
        this.conversation = conversation;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public LocalDateTime getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(LocalDateTime sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
