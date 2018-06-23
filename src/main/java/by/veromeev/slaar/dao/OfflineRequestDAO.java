package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.OfflineRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfflineRequestDAO extends CrudRepository<OfflineRequest, Long> {

    List<OfflineRequest> findOfflineRequestsByChatSessionId(Long chatSessionId);

}
