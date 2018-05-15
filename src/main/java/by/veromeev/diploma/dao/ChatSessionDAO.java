package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.ChatSession;
import org.springframework.data.repository.CrudRepository;

public interface ChatSessionDAO extends CrudRepository<ChatSession, Long> {
}
