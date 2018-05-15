package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.Attachment;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentDAO extends CrudRepository<Attachment, Long> {
}
