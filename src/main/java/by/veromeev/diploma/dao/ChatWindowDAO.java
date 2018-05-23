package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.ChatWindow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatWindowDAO extends CrudRepository<ChatWindow, Long> {

}
