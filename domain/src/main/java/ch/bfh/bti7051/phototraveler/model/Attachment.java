package ch.bfh.bti7051.phototraveler.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Basic
    @JsonProperty
    private String name;

    @Basic
    @JsonProperty
    private String type;

    @Lob
    @JsonIgnore
    private Byte[] data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String filename) {
        this.name = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String filetype) {
        this.type = filetype;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }
}
