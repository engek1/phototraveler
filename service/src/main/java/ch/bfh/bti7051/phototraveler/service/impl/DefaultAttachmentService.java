package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.repository.AttachmentRepository;
import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kaspar on 08.12.2015.
 */
@Named
public class DefaultAttachmentService implements AttachmentService {
    
    @Inject
    private AttachmentRepository attachmentRepository;

    public DefaultAttachmentService() {
        // default empty constructor, required by spring framework.
    }

    public Attachment create(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public Attachment read(long id) {
        return attachmentRepository.findOne(id);
    }

    public Collection<Attachment> list() {
        Iterable<Attachment> attachments = attachmentRepository.findAll();
        List<Attachment> list = new ArrayList<Attachment>();
        for (Attachment entity : attachments) {
            list.add(entity);
        }
        return list;
    }

    public Attachment update(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public void delete(long id) {
        attachmentRepository.delete(id);
    }
}
