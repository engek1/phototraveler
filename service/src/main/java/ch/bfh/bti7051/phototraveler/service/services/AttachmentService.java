package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.model.Attachment;

import java.util.Collection;

/**
 * Created by webel3 on 08.12.2015.
 */
public interface AttachmentService {

    public Attachment create(Attachment attachment);

    public Attachment read(long id);

    public Collection<Attachment> list();
    
    public Attachment update(Attachment attachment);

    public void delete(long id);

}
