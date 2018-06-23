package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.OperatorChatSessionBlock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorChatSessionBlockDAO extends PagingAndSortingRepository<OperatorChatSessionBlock, Long> {
}
