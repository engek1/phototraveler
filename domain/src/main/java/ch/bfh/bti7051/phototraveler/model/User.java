package ch.bfh.bti7051.phototraveler.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Basic(optional = false)
    @JsonProperty
    private String name;

    @Basic(optional = false)
    private String password;

    @Basic(optional = true)
    @JsonProperty
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", insertable = true)
    @JsonProperty
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", insertable = true)
    @JsonProperty
    private List<ItemCollection> collections;

    public User() {
        this.items = new ArrayList<Item>();
        this.collections = new ArrayList<ItemCollection>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @JsonIgnore
    public Item getLastInsertedItem() {
        if (this.items.size() > 0) {
            return this.items.get(this.items.size() -1);
        }
        return null;
    }

    @JsonIgnore
    public ItemCollection getLastInsertedItemCollection() {
        if (this.collections.size() > 0) {
            return this.collections.get(this.collections.size() -1);
        }
        return null;
    }
}
