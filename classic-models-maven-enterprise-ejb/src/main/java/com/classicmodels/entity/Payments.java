/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dhiihd
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p"),
    @NamedQuery(name = "Payments.findByCustomerNumber", query = "SELECT p FROM Payments p WHERE p.paymentsPK.customerNumber = :customerNumber"),
    @NamedQuery(name = "Payments.findByCheckNumber", query = "SELECT p FROM Payments p WHERE p.paymentsPK.checkNumber = :checkNumber"),
    @NamedQuery(name = "Payments.findByPaymentDate", query = "SELECT p FROM Payments p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payments.findByAmount", query = "SELECT p FROM Payments p WHERE p.amount = :amount")})
public class Payments implements Serializable {

    @EmbeddedId
    protected PaymentsPK paymentsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;

    public Payments(PaymentsPK paymentsPK) {
        this.paymentsPK = paymentsPK;
    }

     public Payments(int customerNumber, String checkNumber) {
        this.paymentsPK = new PaymentsPK(customerNumber, checkNumber);
    }
    
}
