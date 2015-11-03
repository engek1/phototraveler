package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Created by webel3 on 03.11.2015.
 */
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
}
