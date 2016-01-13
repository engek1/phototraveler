package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.repository.ItemRepository;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by webel3 on 08.12.2015.
 */
@Named
public class DefaultItemService implements ItemService {
    
    @Inject
    private ItemRepository itemRepository;

    public DefaultItemService() {
        // default empty constructor, required by spring framework.
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Item read(long id) {
        return itemRepository.findOne(id);
    }

    public Collection<Item> list() {
        Iterable<Item> items = itemRepository.findAll();
        List<Item> list = new ArrayList<Item>();
        for (Item entity : items) {
            list.add(entity);
        }
        return list;
    }

    public Item update(Item item) {
        return itemRepository.save(item);
    }

    public void delete(long id) {
        itemRepository.delete(id);
    }
}
