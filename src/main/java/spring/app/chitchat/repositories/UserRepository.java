package spring.app.chitchat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.app.chitchat.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
