package com.exam.domain.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by UserX on 12/11/2016.
 */
public class CamerasJSONIportDto {

    @Expose
    private String type;
    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private boolean isFullFrameorNot;


    @Expose
    private int minISO;

    @Expose
    private int maxISO;
    @Expose
    private int maxShutterSpeed;
    @Expose
    private String maxVideoResolution;

    @Expose
    private int maxframerate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isFullFrameorNot() {
        return isFullFrameorNot;
    }

    public void setFullFrameorNot(boolean fullFrameorNot) {
        isFullFrameorNot = fullFrameorNot;
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

    public int getMaxShutterSpeed() {
        return maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
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

    public CamerasJSONIportDto() {

    }

}
