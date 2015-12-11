package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.Item;
import ch.bfh.bti7051.phototraveler.repository.ItemRepository;
import ch.bfh.bti7051.phototraveler.service.services.ItemService;
import ch.bfh.bti7051.phototraveler.service.dto.ItemDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lukas on 08.12.2015.
 */
@Named
public class DefaultItemService implements ItemService {

    private final ModelMapper mapper = new ModelMapper();

    @Inject
    private ItemRepository itemRepository;

    public ItemDTO create(ItemDTO dto) {
        Item item = mapper.map(dto, Item.class);
        Item created = itemRepository.save(item);
        return mapper.map(created, ItemDTO.class);
    }

    public ItemDTO read(long id) {
        Item item = itemRepository.findOne(id);
        if (item == null) {
            return null;
        }
        return mapper.map(item, ItemDTO.class);
    }

    public Collection<ItemDTO> list() {
        Iterable<Item> items = itemRepository.findAll();
        List<ItemDTO> dtoList = new ArrayList<ItemDTO>();
        for (Item entity : items) {
            dtoList.add(mapper.map(entity, ItemDTO.class));
        }
        return dtoList;
    }

    public ItemDTO update(ItemDTO item) {
        Item entity = itemRepository.findOne(item.getId());
        mapper.map(item, entity);
        Item updated = itemRepository.save(entity);
        return mapper.map(updated, ItemDTO.class);
    }

    public void delete(ItemDTO dto) {
        itemRepository.delete(dto.getId());
    }
}
