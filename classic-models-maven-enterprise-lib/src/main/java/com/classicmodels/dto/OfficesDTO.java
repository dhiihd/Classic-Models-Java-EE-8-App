/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
//import lombok.ToString;

/**
 *
 * @author dhiihd
 */
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude="employeesCollection")
//@ToString(exclude="employeesCollection")
//@EqualsAndHashCode
//@ToString
@XmlRootElement(name = "office")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfficesDTO implements Serializable {

    @NonNull
    private String officeCode;
    @NonNull
    private String city;
    @NonNull
    private String phone;
    @NonNull
    private String addressLine1;
    private String addressLine2;
    private String state;
    @NonNull
    private String country;
    @NonNull
    private String postalCode;
    @NonNull
    private String territory;
    @XmlElement(name = "employees")
    private Collection<EmployeesDTO> employeesCollection;

    /*
    @XmlTransient
    public Collection<EmployeesDTO> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<EmployeesDTO> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

     */
    /**
     * public OfficesDTO(String officeCode) { this.officeCode = officeCode; }
     */
}
