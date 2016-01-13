package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.model.Dashboard;

import java.util.Collection;

/**
 * Created by webel3 on 08.12.2015.
 */
public interface DashboardService {

    public Dashboard create(Dashboard dashboard);

    public Dashboard read(long id);

    public Collection<Dashboard> list();

    public Dashboard update(Dashboard dashboard);

    public void delete(long id);
}
