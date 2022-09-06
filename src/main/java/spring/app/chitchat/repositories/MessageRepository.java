package spring.app.chitchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.chitchat.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
