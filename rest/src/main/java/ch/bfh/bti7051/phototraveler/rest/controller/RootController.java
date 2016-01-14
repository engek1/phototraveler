package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.model.Attachment;
import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.model.ItemCollection;
import ch.bfh.bti7051.phototraveler.model.User;
import ch.bfh.bti7051.phototraveler.service.services.AttachmentService;
import ch.bfh.bti7051.phototraveler.service.services.ItemCollectionService;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import ch.bfh.bti7051.phototraveler.service.services.UserService;
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
    private UserService userService;

    /* ==================================== GET (read) ========================================= */

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable long userId) {
        return userService.read(userId);
    }

    /* ==================================== POST (create) ====================================== */

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }


    @RequestMapping(value = "/users/{userId}/collections", method = RequestMethod.POST)
    public ItemCollection createCollection(@PathVariable long userId, @RequestBody ItemCollection collection) {
        User user = userService.read(userId);
        user.addCollection(collection);
        user = userService.update(user);

        // the last inserted collection is the one we added
        return user.getLastInsertedItemCollection();
    }


    @RequestMapping(value = "/users/{userId}/items", method = RequestMethod.POST)
    public Item createItem(@PathVariable long userId, @RequestBody Item item) {
        User user = userService.read(userId);
        user.addItem(item);
        user = userService.update(user);

        // the last inserted item is the one we added
        return user.getLastInsertedItem();
    }


    @RequestMapping(value = "/collections/{collectionId}/items", method = RequestMethod.POST)
    public Item createItemOnCollection(@PathVariable long collectionId, @RequestBody Item item) {
        ItemCollection collection = itemCollectionService.read(collectionId);
        collection.addItem(item);
        collection = itemCollectionService.update(collection);

        // the last inserted item is the one we added
        return collection.getLastInsertedItem();
    }


    @RequestMapping(value = "/items/{itemId}/attachments", method = RequestMethod.POST)
    public Attachment createAttachment(@PathVariable long itemId, @RequestBody Attachment attachment) {
        Item item = itemService.read(itemId);
        item.addAttachment(attachment);
        item = itemService.update(item);

        // the last inserted attachment is the one we added
        return item.getLastInsertedAttachment();
    }

    /* ==================================== PUT (update) ======================================= */

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
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

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
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
