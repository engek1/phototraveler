package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.repository.DashboardRepository;
import ch.bfh.bti7051.phototraveler.service.dto.DashboardDTO;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lukas on 08.12.2015.
 */
@Named
public class DefaultDashboardService implements DashboardService {

    private final ModelMapper mapper = new ModelMapper();

    @Inject
    private DashboardRepository dashboardRepository;

    public DefaultDashboardService() {
        // default empty constructor, required by spring framework.
    }

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

    public Collection<DashboardDTO> list() {
        Iterable<Dashboard> dashboards = dashboardRepository.findAll();
        Type listType = new TypeToken<Collection<DashboardDTO>>() {
        }.getType();
        return mapper.map(dashboards, listType);
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

