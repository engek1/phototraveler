package ch.bfh.bti7051.phototraveler.service.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private String password;

    private String email;

    private DashboardDTO dashboard;

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

    public DashboardDTO getDashboard() {
        return dashboard;
    }

    public void setDashboard(DashboardDTO dashboard) {
        this.dashboard = dashboard;
    }
}
