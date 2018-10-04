package com.leju.oauth2additionalclaim.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private boolean enabled;

    @NotNull
    @NotEmpty
    @Column(name = "additional_claim")
    private String additionalClaim;

    public User() {
    }

    public User(String id, String username, String password, boolean enabled, String additionalClaim) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.additionalClaim = additionalClaim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAdditionalClaim() {
        return additionalClaim;
    }

    public void setAdditionalClaim(String additionalClaim) {
        this.additionalClaim = additionalClaim;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", additionalClaim='" + additionalClaim + '\'' +
                '}';
    }
}
