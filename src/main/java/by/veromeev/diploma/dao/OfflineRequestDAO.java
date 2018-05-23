package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.OfflineRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfflineRequestDAO extends CrudRepository<OfflineRequest, Long> {

    List<OfflineRequest> findOfflineRequestsByChatSessionId(Long chatSessionId);

}
