package com.nisum.users.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "profile")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    @ElementCollection
    private List<Phone> phone = new ArrayList<Phone>();

    @NotNull
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created;

    @NotNull
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modified;

    @NotNull
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @NotNull
    @Column
    private String token;

    @NotNull
    @Column
    private Boolean isActive;


    public User() {
    }

    public User(String name, String email, String password, List<Phone> phone, Date created,
                Date modified, Date lastLogin, String token, Boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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


    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhones(List<Phone> phone) {
        this.phone = phone;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}