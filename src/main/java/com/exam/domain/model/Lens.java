package com.exam.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lenses")
public class Lens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

  @Basic
  private String make;

   @Basic
    private int focalLength ;

    @Column( columnDefinition="Decimal(10,1)")
    private double maxAperture;

    @Basic
   private String compatibleWith;

    @ManyToOne()
    @JoinColumn(name = "photographer_id", referencedColumnName = "id")
    private Photographer photographer;


    public Lens() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }
}
