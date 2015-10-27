package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lukas on 27.10.2015.
 */
@Entity
public class Author {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String firstname;

    @Basic
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
