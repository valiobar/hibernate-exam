package com.exam.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by UserX on 12/11/2016.
 */
public class LensJSONIportDto implements Serializable {

//"make" : "Canon", "focalLength" : 50, "maxAperture" : 1.8,"compatibleWith" : "Canon"
    @Expose
    private String make;

    @Expose
    private int focalLength ;

    @Expose
    private double maxAperture;

    @Expose
    private String compatibleWith;

    public LensJSONIportDto() {
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
}
