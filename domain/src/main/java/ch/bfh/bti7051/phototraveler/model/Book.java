package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Lukas on 27.10.2015.
 */
@Entity
public class Book {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String title;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToOne
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
