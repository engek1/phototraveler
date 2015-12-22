package ch.bfh.bti7051.phototraveler.model;

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
public class ItemCollection implements Serializable {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String name;

    @Temporal(TemporalType.DATE)
    private Date startingTime;

    @Temporal(TemporalType.DATE)
    private Date endingTime;

    @Basic
    private String notes;

    @OneToMany(cascade = CascadeType.ALL)
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
}
