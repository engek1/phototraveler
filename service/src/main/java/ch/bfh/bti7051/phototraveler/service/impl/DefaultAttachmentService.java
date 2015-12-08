package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.repository.AttachmentRepository;
import ch.bfh.bti7051.phototraveler.service.AttachmentService;
import ch.bfh.bti7051.phototraveler.service.dto.AttachmentDTO;
import org.modelmapper.ModelMapper;

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

    private final ModelMapper mapper = new ModelMapper();
    @Inject
    private AttachmentRepository attachmentRepository;

    public AttachmentDTO create(AttachmentDTO dto) {
        Attachment attachment = mapper.map(dto, Attachment.class);
        Attachment created = attachmentRepository.save(attachment);
        return mapper.map(created, AttachmentDTO.class);
    }

    public AttachmentDTO read(long id) {
        Attachment attachment = attachmentRepository.findOne(id);
        if (attachment == null) {
            return null;
        }
        return mapper.map(attachment, AttachmentDTO.class);
    }

    public Collection<AttachmentDTO> list() {
        Iterable<Attachment> attachments = attachmentRepository.findAll();
        List<AttachmentDTO> dtoList = new ArrayList<AttachmentDTO>();
        for (Attachment entity : attachments) {
            dtoList.add(mapper.map(entity, AttachmentDTO.class));
        }
        return dtoList;
    }

    public AttachmentDTO update(AttachmentDTO attachment) {
        Attachment entity = attachmentRepository.findOne(attachment.getId());
        mapper.map(attachment, entity);
        Attachment updated = attachmentRepository.save(entity);
        return mapper.map(updated, AttachmentDTO.class);
    }

    public void delete(AttachmentDTO dto) {
        attachmentRepository.delete(dto.getId());
    }
}
