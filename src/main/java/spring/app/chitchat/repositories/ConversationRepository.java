package spring.app.chitchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.chitchat.entities.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
}
