package com.exam.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by UserX on 12/11/2016.
 */
@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesXMLImportDto {

    @XmlElement(name = "accessory")
    private List<AccessoryXMLImportDto> accessoryXMLImportDtos;

    public List<AccessoryXMLImportDto> getAccessoryXMLImportDtos() {
        return accessoryXMLImportDtos;
    }

    public void setAccessoryXMLImportDtos(List<AccessoryXMLImportDto> accessoryXMLImportDtos) {
        this.accessoryXMLImportDtos = accessoryXMLImportDtos;
    }
}
