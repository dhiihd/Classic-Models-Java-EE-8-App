/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author dhiihd
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(exclude = "salesRepEmployeeNumber")
//@ToString(exclude = "salesRepEmployeeNumber")
//@EqualsAndHashCode
//@ToString
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersDTO implements Serializable {

    @NonNull
    private Integer customerNumber;

    /**
     * @XmlTransient public EmployeesDTO getSalesRepEmployeeNumber() { return
     * salesRepEmployeeNumber; }
     *
     * public void setSalesRepEmployeeNumber(EmployeesDTO
     * salesRepEmployeeNumber) { this.salesRepEmployeeNumber =
     * salesRepEmployeeNumber; }
     */
    @NonNull
    private String customerName;
    @NonNull
    private String contactLastName;
    @NonNull
    private String contactFirstName;
    @NonNull
    private String phone;
    @NonNull
    private String addressLine1;
    private String addressLine2;
    @NonNull
    private String city;
    private String state;
    private String postalCode;
    @NonNull
    private String country;
    private BigDecimal creditLimit;
    //   private Collection<PaymentsDTO> paymentsCollection;
    //  private Collection<OrdersDTO> ordersCollection;

    private EmployeesDTO salesRepEmployeeNumber;

    @XmlTransient
    public EmployeesDTO getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(EmployeesDTO salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }
    /**
     * public CustomersDTO(Integer customerNumber) { this.customerNumber =
     * customerNumber; }
     */
}
