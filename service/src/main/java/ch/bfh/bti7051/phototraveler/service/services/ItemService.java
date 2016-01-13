package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.model.Item;

import java.util.Collection;

/**
 * Created by webel3 on 08.12.2015.
 */
public interface ItemService {

    public Item create(Item item);

    public Item read(long id);

    public Collection<Item> list();

    public Item update(Item item);

    public void delete(Item item);
}
