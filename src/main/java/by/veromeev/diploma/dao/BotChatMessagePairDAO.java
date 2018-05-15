package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.BotChatMessagePair;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BotChatMessagePairDAO extends PagingAndSortingRepository<BotChatMessagePair, Long> {
}
