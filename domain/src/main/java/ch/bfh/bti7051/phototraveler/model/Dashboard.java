package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
public class Dashboard {

    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemCollection> collections;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<ItemCollection> getCollections() {
        return collections;
    }

    public void setCollections(List<ItemCollection> collections) {
        this.collections = collections;
    }
}
