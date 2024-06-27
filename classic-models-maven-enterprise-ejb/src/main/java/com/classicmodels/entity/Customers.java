/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dhiihd
 */
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = "salesRepEmployeeNumber")
//@ToString(exclude = "salesRepEmployeeNumber")
//@EqualsAndHashCode
//@ToString
@Entity
@Table(name = "Customers")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustomerNumber", query = "SELECT c FROM Customers c WHERE c.customerNumber = :customerNumber"),
    @NamedQuery(name = "Customers.findByCustomerName", query = "SELECT c FROM Customers c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "Customers.findByContactLastName", query = "SELECT c FROM Customers c WHERE c.contactLastName = :contactLastName"),
    @NamedQuery(name = "Customers.findByContactFirstName", query = "SELECT c FROM Customers c WHERE c.contactFirstName = :contactFirstName"),
    @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customers.findByAddressLine1", query = "SELECT c FROM Customers c WHERE c.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Customers.findByAddressLine2", query = "SELECT c FROM Customers c WHERE c.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city"),
    @NamedQuery(name = "Customers.findByState", query = "SELECT c FROM Customers c WHERE c.state = :state"),
    @NamedQuery(name = "Customers.findByPostalCode", query = "SELECT c FROM Customers c WHERE c.postalCode = :postalCode"),
    @NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country"),
    @NamedQuery(name = "Customers.findByCreditLimit", query = "SELECT c FROM Customers c WHERE c.creditLimit = :creditLimit"),
    @NamedQuery(name = "Customers.findCustomerCreditLimits", query = "SELECT DISTINCT(c.creditLimit) FROM Customers c WHERE c.country = :country"),
    @NamedQuery(name = "Customers.findCountries", query = "SELECT DISTINCT(c.country) FROM Customers c")
})

public class Customers implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "customerNumber")
    //  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer customerNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "customerName")
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contactLastName")
    private String contactLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contactFirstName")
    private String contactFirstName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "addressLine1")
    private String addressLine1;
    @Size(max = 50)
    @Column(name = "addressLine2")
    private String addressLine2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "state")
    private String state;
    @Size(max = 15)
    @Column(name = "postalCode")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "country")
    private String country;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "creditLimit")
    private BigDecimal creditLimit;
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
    @ManyToOne
    private Employees salesRepEmployeeNumber;

    /**
     * public Customers(Integer customerNumber) { this.customerNumber =
     * customerNumber; }
     */
}
