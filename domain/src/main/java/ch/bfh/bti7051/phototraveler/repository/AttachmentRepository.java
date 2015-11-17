package ch.bfh.bti7051.phototraveler.repository;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kaspar on 17.11.2015.
 */
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
}
