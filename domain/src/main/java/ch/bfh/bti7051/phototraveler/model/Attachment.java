package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
public class Attachment implements Serializable {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String filename;

    @Basic
    private String filetype;

    @Lob
    private Byte[] data;

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

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }
}
