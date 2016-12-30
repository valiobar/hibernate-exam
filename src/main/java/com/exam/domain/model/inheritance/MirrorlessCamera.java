package com.exam.domain.model.inheritance;




import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mirrorless")
public class MirrorlessCamera extends BasicCamera {


    @Basic
    private String maxVideoResolution;

    @Basic
    private int maxframerate;

    public MirrorlessCamera() {
    }

    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public int getMaxframerate() {
        return maxframerate;
    }

    public void setMaxframerate(int maxframerate) {
        this.maxframerate = maxframerate;
    }
}
