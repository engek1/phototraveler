package ch.bfh.bti7051.phototraveler.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemCollectionDTO {

    private Long id;

    private String name;

    private Date startingTime;

    private Date endingTime;

    private String notes;

    private List<ItemDTO> items;

    public ItemCollectionDTO() {
        this.items = new ArrayList<ItemDTO>();
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

    public List<ItemDTO> getItems() {
        return items;
    }

    public void addItem(ItemDTO item) {
        this.items.add(item);
    }

    public void addItems(List<ItemDTO> items) {
        this.items.addAll(items);
    }
}
