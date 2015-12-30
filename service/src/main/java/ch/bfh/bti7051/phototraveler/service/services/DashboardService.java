package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.service.dto.AttachmentDTO;
import ch.bfh.bti7051.phototraveler.service.dto.DashboardDTO;

import java.util.Collection;

/**
 * Created by Lukas on 08.12.2015.
 */
public interface DashboardService {

    public DashboardDTO create(DashboardDTO dto);

    public DashboardDTO read(long id);

    public Collection<DashboardDTO> list();

    public DashboardDTO update(DashboardDTO dto);

    public void delete(DashboardDTO dto);
}
