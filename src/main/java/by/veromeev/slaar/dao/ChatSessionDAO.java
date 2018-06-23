package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.ChatSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatSessionDAO extends CrudRepository<ChatSession, Long> {

    List<ChatSession> findChatSessionByChatWindowId(Long chatWindowId);

    Optional<ChatSession> findByJSessionId(String jSessioId);

}
