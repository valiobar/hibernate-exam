package com.exam.domain.dto;

import com.exam.annoitationValidations.TagName;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by UserX on 12/11/2016.
 */
public class PhotographerJSONExportDto {
@Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;


    public PhotographerJSONExportDto() {
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
        lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
