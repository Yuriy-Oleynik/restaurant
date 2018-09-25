package model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class User {

    private String name;

    private String email;

    private String password;

    private Set<Role> roles;

    private Date registered = new Date();

    protected List<Vote> votes;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public Set<Role> getRoles() {

        return roles;
    }

    public void setRoles(Set<Role> roles) {

        this.roles = roles;
    }

    public Date getRegistered() {

        return registered;
    }

    public void setRegistered(Date registered) {

        this.registered = registered;
    }

    public List<Vote> getVotes() {

        return votes;
    }

    public void setVotes(List<Vote> votes) {

        this.votes = votes;
    }

}
