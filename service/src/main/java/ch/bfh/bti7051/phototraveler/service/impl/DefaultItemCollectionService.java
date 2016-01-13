package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.ItemCollection;
import ch.bfh.bti7051.phototraveler.repository.ItemCollectionRepository;
import ch.bfh.bti7051.phototraveler.service.services.ItemCollectionService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by webel3 on 22.12.2015.
 */
@Named
public class DefaultItemCollectionService implements ItemCollectionService {

    @Inject
    private ItemCollectionRepository itemRepository;

    public DefaultItemCollectionService() {
        // default empty constructor, required by spring framework.
    }

    public ItemCollection create(ItemCollection itemCollection) {
        return itemRepository.save(itemCollection);
    }

    public ItemCollection read(long id) {
        return itemRepository.findOne(id);
    }

    public Collection<ItemCollection> list() {
        Iterable<ItemCollection> items = itemRepository.findAll();
        List<ItemCollection> list = new ArrayList<ItemCollection>();
        for (ItemCollection entity : items) {
            list.add(entity);
        }
        return list;
    }

    public ItemCollection update(ItemCollection itemCollection) {
        return itemRepository.save(itemCollection);
    }

    public void delete(long id) {
        itemRepository.delete(id);
    }
}
