package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.ChatWindow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatWindowDAO extends CrudRepository<ChatWindow, Long> {

}
