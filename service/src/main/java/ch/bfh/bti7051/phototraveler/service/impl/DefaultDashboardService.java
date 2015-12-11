package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.repository.DashboardRepository;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;
import ch.bfh.bti7051.phototraveler.service.dto.DashboardDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Lukas on 08.12.2015.
 */
@Named
public class DefaultDashboardService implements DashboardService {

    private final ModelMapper mapper = new ModelMapper();

    @Inject
    private DashboardRepository dashboardRepository;

    public DashboardDTO create(DashboardDTO dto) {
        Dashboard dashboard = mapper.map(dto, Dashboard.class);
        Dashboard created = dashboardRepository.save(dashboard);
        return mapper.map(created, DashboardDTO.class);
    }

    public DashboardDTO read(long id) {
        Dashboard dashboard = dashboardRepository.findOne(id);
        if (dashboard == null) {
            return null;
        }
        return mapper.map(dashboard, DashboardDTO.class);
    }

    public DashboardDTO update(DashboardDTO dashboard) {
        Dashboard entity = dashboardRepository.findOne(dashboard.getId());
        mapper.map(dashboard, entity);
        Dashboard updated = dashboardRepository.save(entity);
        return mapper.map(updated, DashboardDTO.class);
    }

    public void delete(DashboardDTO dto) {
        dashboardRepository.delete(dto.getId());
    }
}
