package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.service.dto.AttachmentDTO;

import java.util.Collection;

public interface AttachmentService {

    public AttachmentDTO create(AttachmentDTO dto);

    public AttachmentDTO read(long id);

    public Collection<AttachmentDTO> list();

    public AttachmentDTO update(AttachmentDTO dto);

    public void delete(AttachmentDTO dto);

}
