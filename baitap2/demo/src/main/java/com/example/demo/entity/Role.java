package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    Set<User> users;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
        this.users = new HashSet<>();

    }
    public Role(){

    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
