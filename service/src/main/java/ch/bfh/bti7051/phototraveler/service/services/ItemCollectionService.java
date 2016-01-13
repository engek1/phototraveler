package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.model.ItemCollection;

import java.util.Collection;

/**
 * Created by webel3 on 22.12.2015.
 */
public interface ItemCollectionService {

    public ItemCollection create(ItemCollection itemCollection);

    public ItemCollection read(long id);

    public Collection<ItemCollection> list();

    public ItemCollection update(ItemCollection itemCollection);

    public void delete(ItemCollection itemCollection);

}
