package com.exam.domain.model.inheritance;





import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DSLR")
public class DSLRCamera extends BasicCamera {

@Basic
private int maxShutterSpeed;


    public DSLRCamera() {
    }

    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}
