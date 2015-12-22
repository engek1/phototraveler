package ch.bfh.bti7051.phototraveler.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by webel3 on 03.11.2015.
 */
@Entity
public class User implements Serializable {

    @GeneratedValue
    @Id
    private Long id;

    @Basic
    private String name;

    @Basic
    private String password;

    @Basic
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Dashboard dashboard;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }
}
