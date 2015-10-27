package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lukas on 27.10.2015.
 */
@Entity
public class Author {

    private Long id;
    private String firstname;
    private String lastname;
    private List<Book> books;

    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @OneToMany
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
