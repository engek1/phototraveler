package ch.bfh.bti7051.phototraveler.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class ItemCollection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Basic(optional = false)
    @JsonProperty
    private String name;

    @Basic(optional = true)
    @Temporal(TemporalType.DATE)
    @JsonProperty
    private Date startingTime;

    @Basic(optional = true)
    @Temporal(TemporalType.DATE)
    @JsonProperty
    private Date endingTime;

    @Basic(optional = true)
    @JsonProperty
    private String notes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLLECTION_ID", insertable = true)
    @JsonProperty
    private List<Item> items;

    public ItemCollection() {
        this.items = new ArrayList<Item>();
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

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @JsonIgnore
    public Item getLastInsertedItem() {
        if (this.items.size() > 0) {
            return this.items.get(this.items.size() - 1);
        }
        return null;
    }
}
