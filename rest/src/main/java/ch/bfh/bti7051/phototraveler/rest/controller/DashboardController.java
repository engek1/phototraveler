package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.service.dto.DashboardDTO;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Lukas on 22.12.2015.
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Inject
    private DashboardService dashboardService;

    /**
     * Create
     */
    @RequestMapping(method = RequestMethod.POST)
    public DashboardDTO createDashboard(@RequestBody DashboardDTO dashboard) {
        DashboardDTO createdDashboard = this.dashboardService.create(dashboard);
        System.out.println("Dashboard created with id = " + createdDashboard.getId());
        return createdDashboard;
    }

    /**
     * Read
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DashboardDTO getDashboard(@PathVariable long id) {
        System.out.println("Dashboard requested with id = " + id);
        return dashboardService.read(id);
    }

    /**
     * ReadAll
     */
    @RequestMapping(method = RequestMethod.GET)
//    public Collection<DashboardDTO> getDashboards() {
//        return dashboardService.list();
//    }
    public String getDashboards() {
        return "those are all dashboards ;-)";
    }

    /**
     * Update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public DashboardDTO updateDashboard(@RequestBody DashboardDTO dashboard) {
        DashboardDTO updatedDashboard = dashboardService.update(dashboard);
        System.out.println("Dashboard updated with id = " + updatedDashboard.getId());
        return updatedDashboard;
    }

    /**
     * Delete
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteDashboard(@PathVariable long id) {
        DashboardDTO dashboard = dashboardService.read(id);
        dashboardService.delete(dashboard);
        System.out.println("Delete Dashboard with id = " + id);
    }

}
