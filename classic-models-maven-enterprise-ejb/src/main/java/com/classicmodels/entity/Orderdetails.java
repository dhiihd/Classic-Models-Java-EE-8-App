/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "Orderdetails")
//@IdClass(OrderdetailsPK.class)
@NamedQueries({
    @NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o"),
    @NamedQuery(name = "Orderdetails.findByOrderNumber", query = "SELECT o FROM Orderdetails o WHERE o.orderdetailsPK.orderNumber = :orderNumber"),
    @NamedQuery(name = "Orderdetails.findByProductCode", query = "SELECT o FROM Orderdetails o WHERE o.orderdetailsPK.productCode = :productCode"),
    @NamedQuery(name = "Orderdetails.findByQuantityOrdered", query = "SELECT o FROM Orderdetails o WHERE o.quantityOrdered = :quantityOrdered"),
    @NamedQuery(name = "Orderdetails.findByPriceEach", query = "SELECT o FROM Orderdetails o WHERE o.priceEach = :priceEach"),
    @NamedQuery(name = "Orderdetails.findByOrderLineNumber", query = "SELECT o FROM Orderdetails o WHERE o.orderLineNumber = :orderLineNumber")})
public class Orderdetails implements Serializable {

    @EmbeddedId
    protected OrderdetailsPK orderdetailsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantityOrdered")
    private int quantityOrdered;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceEach")
    private BigDecimal priceEach;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderLineNumber")
    private short orderLineNumber;
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "productCode", referencedColumnName = "productCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public Orderdetails(OrderdetailsPK orderdetailsPK) {
        this.orderdetailsPK = orderdetailsPK;
    }

    public Orderdetails(int orderNumber, String productCode) {
        this.orderdetailsPK = new OrderdetailsPK(orderNumber, productCode);
    }

}
