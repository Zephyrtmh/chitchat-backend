package spring.app.chitchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.app.chitchat.entities.Conversation;
import spring.app.chitchat.entities.User;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    @Query(value="SELECT * FROM user_conversation WHERE conversation_id=:conversationId", nativeQuery = true)
    public List<Integer> getUsersByConversationId(@Param(value="conversationId") int conversationId);
}
