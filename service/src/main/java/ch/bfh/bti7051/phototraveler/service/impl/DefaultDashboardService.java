package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.repository.DashboardRepository;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by webel3 on 08.12.2015.
 */
@Named
public class DefaultDashboardService implements DashboardService {

    @Inject
    private DashboardRepository dashboardRepository;

    public DefaultDashboardService() {
        // default empty constructor, required by spring framework.
    }

    public Dashboard create(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    public Dashboard read(long id) {
        return dashboardRepository.findOne(id);
    }

    public Collection<Dashboard> list() {
        Iterable<Dashboard> dashboards = dashboardRepository.findAll();
        List<Dashboard> list = new ArrayList<Dashboard>();
        for (Dashboard dashboard : dashboards) {
            list.add(dashboard);
        }
        return list;
    }

    public Dashboard update(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    public void delete(Dashboard dashboard) {
        dashboardRepository.delete(dashboard);
    }
}

