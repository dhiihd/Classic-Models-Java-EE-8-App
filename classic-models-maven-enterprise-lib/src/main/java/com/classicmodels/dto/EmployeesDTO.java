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
//import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
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
//@EqualsAndHashCode(exclude={"customersCollection","employeesCollection","officeCode","reportsTo"})
//@ToString(exclude={"customersCollection","employeesCollection","officeCode","reportsTo"})
//@EqualsAndHashCode
//@ToString
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesDTO implements Serializable {

    @NonNull
    private Integer employeeNumber;
    @NonNull
    private String lastName;
    @NonNull
    private String firstName;
    @NonNull
    private String extension;
    @NonNull
    private String email;
    @NonNull
    private String jobTitle;
    @XmlElement(name = "customers")
    // @XmlTransient
    private Collection<CustomersDTO> customersCollection;

    /*
    @XmlTransient
    public Collection<CustomersDTO> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<CustomersDTO> customersCollection) {
        this.customersCollection = customersCollection;
    }
   
    @XmlTransient
    public Collection<EmployeesDTO> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<EmployeesDTO> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }
  
      
    @XmlTransient
    public OfficesDTO getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(OfficesDTO officeCode) {
        this.officeCode = officeCode;
    }
    
   
    @XmlTransient
    public EmployeesDTO getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(EmployeesDTO reportsTo) {
        this.reportsTo = reportsTo;
    }
     */
    @XmlElement(name = "employees")
    //@XmlTransient
    private Collection<EmployeesDTO> employeesCollection;
    //@XmlTransient
    private EmployeesDTO reportsTo;
    private OfficesDTO officeCode;

    /**
     * public EmployeesDTO(Integer employeeNumber) { this.employeeNumber =
     * employeeNumber; }
     */
}
