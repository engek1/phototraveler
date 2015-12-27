package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.service.dto.DashboardDTO;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by Lukas on 22.12.2015.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Inject
    private DashboardService dashboardService;

    /**
     * Create
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public DashboardDTO createDashboard(@RequestBody DashboardDTO dashboard) {
        DashboardDTO createdDashboard = this.dashboardService.create(dashboard);
        System.out.println("Dashboard created with id = " + createdDashboard.getId());
        return createdDashboard;
    }

    /**
     * Read
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public DashboardDTO getDashboard(@PathVariable long id) {
        System.out.println("Dashboard requested with id = " + id);
        return dashboardService.read(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getDashboards() {
        return "hallihallo";
    }

    /**
     * Update
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public DashboardDTO updateDashboard(@RequestBody DashboardDTO dashboard) {
        DashboardDTO updatedDashboard = dashboardService.update(dashboard);
        System.out.println("Dashboard updated with id = " + updatedDashboard.getId());
        return updatedDashboard;
    }

    /**
     * Delete
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteDashboard(@PathVariable long id) {
        DashboardDTO dashboard = dashboardService.read(id);
        dashboardService.delete(dashboard);
        System.out.println("Delete Dashboard with id = " + id);
    }

}
