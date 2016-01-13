package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.model.ItemCollection;
import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;
import ch.bfh.bti7051.phototraveler.service.services.DashboardService;
import ch.bfh.bti7051.phototraveler.service.services.ItemCollectionService;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

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


    /* ==================================== GET (read) ========================================= */

    @RequestMapping(value = "/dashboards/{dashboardId}", method = RequestMethod.GET)
    public Dashboard getDashboard(@PathVariable long dashboardId) {
        return dashboardService.read(dashboardId);
    }


    /*
     * Those 2 services should not be necessary, because 'dashboard' has all its
     * items and itemCollections and they have their attachments itselves.
     *
     *
    @RequestMapping(value = "/items/{itemId}/attachments", method = RequestMethod.GET)
    public List<Attachment> getItems(@PathVariable long itemId) {
        Item item = itemService.read(itemId);
        if (Objects.isNull(item)) {
            return null;
        }
        return item.getAttachments();
    }

    @RequestMapping(value = "/items/{itemId}/attachments/{attachmentId}", method = RequestMethod.GET)
    public Attachment getItem(@PathVariable long itemId, @PathVariable long attachmentId) {
        return attachmentService.read(attachmentId);
    }
    */

    /* ==================================== POST (create) ====================================== */

    @RequestMapping(value = "/dashboards", method = RequestMethod.POST)
    public Dashboard createDashboard(@RequestBody Dashboard dashboard) {
        return dashboardService.create(dashboard);
    }


    @RequestMapping(value = "/dashboards/{dashboardId}/collections", method = RequestMethod.POST)
    public ItemCollection createItem(@PathVariable long dashboardId, @RequestBody ItemCollection itemCollection) {
        Dashboard board = dashboardService.read(dashboardId);
        board.addCollection(itemCollection);
        dashboardService.update(board);

        // TODO : was zurückgeben? itemCollection ist "nur" das empfangene element
        return itemCollection;
    }


    @RequestMapping(value = "/dashboards/{dashboardId}/items", method = RequestMethod.POST)
    public Item createItemOnDashboard(@PathVariable long dashboardId, @RequestBody Item item) {
        Dashboard board = dashboardService.read(dashboardId);
        board.addItem(item);
        dashboardService.update(board);

        // TODO : was genau zurückgeben? item ist "nur" das empfangene element
        return item;
    }


    @RequestMapping(value = "/collections/{collectionId}/items", method = RequestMethod.POST)
    public Item createItemOnCollection(@PathVariable long collectionId, @RequestBody Item item) {
        ItemCollection collection = itemCollectionService.read(collectionId);
        collection.addItem(item);
        itemCollectionService.update(collection);

        // TODO : was zurückgeben? item ist "nur" das empfangene element
        return item;
    }


    @RequestMapping(value = "/items/{itemId}/attachments", method = RequestMethod.POST)
    public Attachment createAttachment(@PathVariable long itemId, @RequestBody Attachment attachment) {
        Item item = itemService.read(itemId);
        item.addAttachment(attachment);
        itemService.update(item);

        // TODO : was zurückgeben? attachment ist "nur" das empfangene element
        return attachment;
    }

    /* ==================================== PUT (update) ======================================= */

    @RequestMapping(value = "/dashboards/{dashboardId}", method = RequestMethod.PUT)
    public Dashboard updateDashboard(@RequestBody Dashboard dashboard) {
        return dashboardService.update(dashboard);
    }


    @RequestMapping(value = "/collections/{collectionId}", method = RequestMethod.PUT)
    public ItemCollection updateCollection(@RequestBody ItemCollection collection) {
        return itemCollectionService.update(collection);
    }


    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item item) {
        return itemService.update(item);
    }

    @RequestMapping(value = "attachments/{attachmentId}", method = RequestMethod.PUT)
    public Attachment updateAttachment(@RequestBody Attachment attachment) {
        return attachmentService.update(attachment);
    }

    /* ==================================== DELETE (delete) ==================================== */

    @RequestMapping(value = "/dashboards/{dashboardId}", method = RequestMethod.DELETE)
    public void deleteDashboard(@PathVariable long dashboardId) {
        dashboardService.delete(dashboardId);
    }

    @RequestMapping(value = "/collections/{collectionId}", method = RequestMethod.DELETE)
    public void deleteCollection(@PathVariable long collectionId) {
        itemCollectionService.delete(collectionId);
    }

    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable long itemId) {
        itemService.delete(itemId);
    }

    @RequestMapping(value = "/attachments/{attachmentId}", method = RequestMethod.DELETE)
    public void deleteAttachment(@PathVariable long attachmentId) {
        attachmentService.delete(attachmentId);
    }
}
