package com.exam.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "workshops")
public class Workshop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToMany(cascade = javax.persistence.CascadeType.ALL)
//  //  @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinTable(name = "firstItems_fourthItems",
//            joinColumns = @JoinColumn(name = "firstItem_id"),
//            inverseJoinColumns = @JoinColumn(name = "fourthItems"))
//    private Set<Star> fourthItems;


    @Column(name = "name")
    @NotNull
    private String name;

    @Basic
    private Date startDate;


    @Basic
    private Date endDate;

    @Basic
    private String location;

    @Column(name = "price_per_participant")
    private BigDecimal pricePerParticipant;

    @ManyToOne()
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Photographer photographers;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "workshops_participants",
            joinColumns = @JoinColumn(name = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private List<Photographer> participants;



    public Workshop() {
        this.setParticipants(new ArrayList<>());
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public Photographer getPhotographers() {
        return photographers;
    }

    public void setPhotographers(Photographer photographers) {
        this.photographers = photographers;
    }

    public List<Photographer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Photographer> participants) {
        this.participants = participants;
    }
}
