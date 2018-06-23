package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentDAO extends CrudRepository<Attachment, Long> {

    List<Attachment> findByBotChatMessagePairId(Long botChatMessagePairId);

    List<Attachment> findAttachmentsByOperatorChatMessageId(Long operatorChatMessagePairId);

    List<Attachment> findAttachmentsByOfflineRequestId(Long offlineRequestId);

}
