package com.exam.domain.dto;

import com.exam.annoitationValidations.TagName;
import com.exam.domain.model.Lens;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by UserX on 12/11/2016.
 */
public class PhotographerJSONImportDto {
@Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    @TagName()
    private String phone;
    @Expose
    private List<Long>lenses;

    public PhotographerJSONImportDto() {
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

    public List<Long> getLenses() {
        return lenses;
    }

    public void setLenses(List<Long> lenses) {
        this.lenses = lenses;
    }
}
