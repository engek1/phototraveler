package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.ItemCollection;
import ch.bfh.bti7051.phototraveler.repository.ItemCollectionRepository;
import ch.bfh.bti7051.phototraveler.service.dto.ItemCollectionDTO;
import ch.bfh.bti7051.phototraveler.service.services.ItemCollectionService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Lukas on 22.12.2015.
 */
@Named
public class DefaultItemCollectionService implements ItemCollectionService {

    private final ModelMapper mapper = new ModelMapper();

    @Inject
    private ItemCollectionRepository itemRepository;

    public ItemCollectionDTO create(ItemCollectionDTO dto) {
        ItemCollection collection = mapper.map(dto, ItemCollection.class);
        ItemCollection created = itemRepository.save(collection);
        return mapper.map(created, ItemCollectionDTO.class);
    }

    public ItemCollectionDTO read(long id) {
        ItemCollection collection = itemRepository.findOne(id);
        if (collection == null) {
            return null;
        }
        return mapper.map(collection, ItemCollectionDTO.class);
    }

    public Collection<ItemCollectionDTO> list() {
        Iterable<ItemCollection> items = itemRepository.findAll();
        List<ItemCollectionDTO> dtoList = new ArrayList<ItemCollectionDTO>();
        for (ItemCollection entity : items) {
            dtoList.add(mapper.map(entity, ItemCollectionDTO.class));
        }
        return dtoList;
    }

    public ItemCollectionDTO update(ItemCollectionDTO item) {
        ItemCollection entity = itemRepository.findOne(item.getId());
        mapper.map(item, entity);
        ItemCollection updated = itemRepository.save(entity);
        return mapper.map(updated, ItemCollectionDTO.class);
    }

    public void delete(ItemCollectionDTO dto) {
        itemRepository.delete(dto.getId());
    }
}
