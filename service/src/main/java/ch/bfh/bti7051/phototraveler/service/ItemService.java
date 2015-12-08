package ch.bfh.bti7051.phototraveler.service;

import ch.bfh.bti7051.phototraveler.service.dto.ItemDTO;

import java.util.Collection;

/**
 * Created by Lukas on 08.12.2015.
 */
public interface ItemService {

    public ItemDTO create(ItemDTO dto);

    public ItemDTO read(long id);

    public Collection<ItemDTO> list();

    public ItemDTO update(ItemDTO dto);

    public void delete(ItemDTO dto);
}
