package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
public class Item implements Serializable {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String name;

    @Basic
    private Boolean visited;

    @Basic
    private String notes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Attachment> attachments;

    public Item() {
        this.attachments = new ArrayList<Attachment>();
    }

    public Item(String name) {
        this.name = name;
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

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
    }

    public void addAttachments(List<Attachment> attachments) {
        this.attachments.addAll(attachments);
    }

}
