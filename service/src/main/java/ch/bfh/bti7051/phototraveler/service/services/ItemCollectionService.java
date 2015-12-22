package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.service.dto.ItemCollectionDTO;

import java.util.Collection;

/**
 * Created by Lukas on 22.12.2015.
 */
public interface ItemCollectionService {

    public ItemCollectionDTO create(ItemCollectionDTO dto);

    public ItemCollectionDTO read(long id);

    public Collection<ItemCollectionDTO> list();

    public ItemCollectionDTO update(ItemCollectionDTO dto);

    public void delete(ItemCollectionDTO dto);

}
