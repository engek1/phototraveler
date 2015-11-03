package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
public class Attachment {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String filename;

    @Basic
    private Boolean filetype;

    @Lob
    private Lob data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getFiletype() {
        return filetype;
    }

    public void setFiletype(Boolean filetype) {
        this.filetype = filetype;
    }

    public Lob getData() {
        return data;
    }

    public void setData(Lob data) {
        this.data = data;
    }
}
