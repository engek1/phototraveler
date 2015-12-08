package ch.bfh.bti7051.phototraveler.service.dto;

import java.util.ArrayList;
import java.util.List;

public class DashboardDTO {

    private Long id;

    private List<ItemDTO> items;

    private List<ItemCollectionDTO> collections;

    public DashboardDTO() {
        this.items = new ArrayList<ItemDTO>();
        this.collections = new ArrayList<ItemCollectionDTO>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void addItem(ItemDTO item) {
        this.items.add(item);
    }

    public void addItems(List<ItemDTO> items) {
        this.items.addAll(items);
    }

    public List<ItemCollectionDTO> getCollections() {
        return collections;
    }

    public void addCollection(ItemCollectionDTO itemCollection) {
        this.collections.add(itemCollection);
    }

    public void addCollections(List<ItemCollectionDTO> collections) {
        this.collections.addAll(collections);
    }
}
