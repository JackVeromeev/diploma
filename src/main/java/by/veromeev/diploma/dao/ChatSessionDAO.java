package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.ChatSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatSessionDAO extends CrudRepository<ChatSession, Long> {

    List<ChatSession> findChatSessionByChatWindowId(Long chatWindowId);

}
