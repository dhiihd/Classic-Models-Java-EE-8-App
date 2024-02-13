/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeNumber", query = "SELECT e FROM Employees e WHERE e.employeeNumber = :employeeNumber"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employees.findByExtension", query = "SELECT e FROM Employees e WHERE e.extension = :extension"),
    @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
    @NamedQuery(name = "Employees.findByJobTitle", query = "SELECT e FROM Employees e WHERE e.jobTitle = :jobTitle")})
public class Employees implements Serializable {

    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 50)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "extension")
    private String extension;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "jobTitle")
    private String jobTitle;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "employeeNumber")
    private Integer employeeNumber;
    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    private Collection<Customers> customersCollection;
    @OneToMany(mappedBy = "reportsTo")
    private Collection<Employees> employeesCollection;
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
    @ManyToOne
    private Employees reportsTo;
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
    @ManyToOne(optional = false)
    private Offices officeCode;
/**
    public Employees(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
*/
   

    
}
