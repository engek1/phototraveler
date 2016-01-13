package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;
import ch.bfh.bti7051.phototraveler.service.services.ItemCollectionService;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Objects;

/**
 * Created by webel3 on 13.01.2016.
 */
@RestController
@RequestMapping
@Consumes("application/json")
@Produces("application/json")
public class RootController {

    @Inject
    private AttachmentService attachmentService;

    @Inject
    private ItemService itemService;

    @Inject
    private ItemCollectionService itemCollectionService;

    @Inject
    private DashboardService dashboardService;


    /**
     * Return the wanted dashboard.
     *
     * The following elements are included in the dashboard:<br>
     *   - List of items<br>
     *   - List of itemCollections<br>
     *
     * @param dashboardId ID of the wanted dashboard
     * @return dashboard JSON representation
     */
    @RequestMapping(value = "/dashboard/{dashboardId}", method = RequestMethod.GET)
    public Dashboard getDashboard(@PathVariable long dashboardId) {
        return dashboardService.read(dashboardId);
    }


    /**
     * Return a list of attachments for the wanted item.
     *
     * @param itemId ID of an item (which is used as context for an attachment)
     * @return list of attachments for the wanted item
     */
    @RequestMapping(value = "/item/{dashboardId}/attachment", method = RequestMethod.GET)
    public List<Attachment> getItems(@PathVariable long itemId) {
        Item item = itemService.read(itemId);
        if (Objects.isNull(item)) {
            return null;
        }
        return item.getAttachments();
    }



}
