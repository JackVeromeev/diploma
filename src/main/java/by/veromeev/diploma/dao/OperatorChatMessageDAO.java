package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.OperatorChatMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OperatorChatMessageDAO extends PagingAndSortingRepository<OperatorChatMessage, Long> {
}
