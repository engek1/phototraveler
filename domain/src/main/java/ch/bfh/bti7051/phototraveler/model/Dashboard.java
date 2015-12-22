package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
public class Dashboard implements Serializable {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemCollection> collections;

    public Dashboard() {
        this.items = new ArrayList<Item>();
        this.collections = new ArrayList<ItemCollection>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    public List<ItemCollection> getCollections() {
        return collections;
    }

    public void addCollection(ItemCollection itemCollection) {
        this.collections.add(itemCollection);
    }

    public void addCollections(List<ItemCollection> collections) {
        this.collections.addAll(collections);
    }
}
