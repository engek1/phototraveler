package ch.bfh.bti7051.phototraveler.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemDTO implements Serializable {

    private Long id;

    private String name;

    private Boolean visited;

    private String notes;

    private List<AttachmentDTO> attachments;

    public ItemDTO() {
        this("");
    }

    public ItemDTO(String name) {
        this.name = name;
        this.attachments = new ArrayList<AttachmentDTO>();
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

    public List<AttachmentDTO> getAttachments() {
        return attachments;
    }

    public void addAttachment(AttachmentDTO attachment) {
        this.attachments.add(attachment);
    }

    public void addAttachments(List<AttachmentDTO> attachments) {
        this.attachments.addAll(attachments);
    }

}
