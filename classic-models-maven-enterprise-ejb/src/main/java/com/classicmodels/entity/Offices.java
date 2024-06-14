/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author dhiihd
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = "employeesCollection")
//@ToString(exclude = "employeesCollection")
//@EqualsAndHashCode
//@ToString
@Entity
@Table(name = "Offices")
@NamedQueries({
    @NamedQuery(name = "Offices.findAll", query = "SELECT o FROM Offices o"),
    @NamedQuery(name = "Offices.findByOfficeCode", query = "SELECT o FROM Offices o WHERE o.officeCode = :officeCode"),
    @NamedQuery(name = "Offices.findByCity", query = "SELECT o FROM Offices o WHERE o.city = :city"),
    @NamedQuery(name = "Offices.findByPhone", query = "SELECT o FROM Offices o WHERE o.phone = :phone"),
    @NamedQuery(name = "Offices.findByAddressLine1", query = "SELECT o FROM Offices o WHERE o.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Offices.findByAddressLine2", query = "SELECT o FROM Offices o WHERE o.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Offices.findByState", query = "SELECT o FROM Offices o WHERE o.state = :state"),
    @NamedQuery(name = "Offices.findByCountry", query = "SELECT o FROM Offices o WHERE o.country = :country"),
    @NamedQuery(name = "Offices.findByPostalCode", query = "SELECT o FROM Offices o WHERE o.postalCode = :postalCode"),
    @NamedQuery(name = "Offices.findByTerritory", query = "SELECT o FROM Offices o WHERE o.territory = :territory")})
public class Offices implements Serializable {

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "addressLine1")
    private String addressLine1;
    @Size(max = 50)
    @Column(name = "addressLine2")
    private String addressLine2;
    @Size(max = 50)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 50)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "postalCode")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "territory")
    private String territory;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "officeCode")
    private String officeCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "officeCode")
    private Collection<Employees> employeesCollection;

}
