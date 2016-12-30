package com.exam.domain.model.inheritance;




import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)

public abstract class BasicCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @NotNull
    private String make;

    @Basic
    @NotNull
    private String model;

    @Basic
    private boolean isFullFrameorNot;


    @Basic
    @Min(100)
    @NotNull
    private int minISO;

    @Basic
    private int maxISO;

    public BasicCamera() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public int getMinISO() {
        return minISO;
    }

    public void setMinISO(int minISO) {
        this.minISO = minISO;
    }

    public int getMaxISO() {
        return maxISO;
    }

    public void setMaxISO(int maxISO) {
        this.maxISO = maxISO;
    }

    public boolean getIsFullFrameorNot(){
        return isFullFrameorNot;
    }
    public void setisFullFrameorNot(boolean isFullFrameorNot){
        this.isFullFrameorNot=isFullFrameorNot;
    }
}
