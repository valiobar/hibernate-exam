package com.exam.domain.model;

import com.exam.domain.model.inheritance.BasicCamera;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "photographers")
public class Photographer implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @NotNull
    private String firstName;

    @Basic
    @NotNull
    @Size(min = 2,max = 50)
    private String lastName;

    @Basic
    private String phone;



    @ManyToOne
    @JoinColumn(name = "primary_camera_id")
    private BasicCamera primaryCamera;


    @ManyToOne
    @JoinColumn(name = "secondary_camera_id")
    private BasicCamera secondaryCamera;

    @OneToMany(mappedBy = "photographer")
    private List<Lens> lenses;


    @OneToMany(mappedBy = "owner")
     private List<Accessorie>Accessories;


    public Photographer() {
        this.setLenses(new ArrayList<>());
        this.setAccessories(new ArrayList<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BasicCamera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(BasicCamera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public BasicCamera getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(BasicCamera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public List<Lens> getLenses() {
        return lenses;
    }

    public void setLenses(List<Lens> lenses) {
        this.lenses = lenses;
    }

    public List<Accessorie> getAccessories() {
        return Accessories;
    }

    public void setAccessories(List<Accessorie> accessories) {
        Accessories = accessories;
    }

    public void addLens(Lens lens){
        this.getLenses().add(lens);
    }
}
