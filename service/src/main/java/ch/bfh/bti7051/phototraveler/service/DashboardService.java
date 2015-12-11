package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.service.dto.DashboardDTO;

/**
 * Created by Lukas on 08.12.2015.
 */
public interface DashboardService {

    public DashboardDTO create(DashboardDTO dto);

    public DashboardDTO read(long id);

    public DashboardDTO update(DashboardDTO dto);

    public void delete(DashboardDTO dto);
}
