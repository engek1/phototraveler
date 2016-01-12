package ch.bfh.bti7051.phototraveler.rest.controller;

import ch.bfh.bti7051.phototraveler.service.dto.ItemDTO;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Kaspar
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Inject
    private ItemService itemService;

    /**
     * Create
     */
    @RequestMapping(method = RequestMethod.POST)
    public ItemDTO createItem(@RequestBody ItemDTO item) {
        ItemDTO createdItem = this.itemService.create(item);
        System.out.println("Item created with id = " + createdItem.getId());
        return createdItem;
    }

    /**
     * Read
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ItemDTO getItem(@PathVariable long id) {
        System.out.println("Item requested with id = " + id);
        return itemService.read(id);
    }

    /**
     * ReadAll
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<ItemDTO> getItems() {
        return itemService.list();
    }

    /**
     * Update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ItemDTO updateItem(@RequestBody ItemDTO item) {
        ItemDTO updatedItem = itemService.update(item);
        System.out.println("Item updated with id = " + updatedItem.getId());
        return updatedItem;
    }

    /**
     * Delete
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable long id) {
        ItemDTO item = itemService.read(id);
        itemService.delete(item);
        System.out.println("Delete Item with id = " + id);
    }

}
