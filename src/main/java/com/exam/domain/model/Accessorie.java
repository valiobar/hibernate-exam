package com.exam.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "accessories")
public class Accessorie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Photographer owner;

    public Accessorie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Photographer getOwner() {
        return owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}
