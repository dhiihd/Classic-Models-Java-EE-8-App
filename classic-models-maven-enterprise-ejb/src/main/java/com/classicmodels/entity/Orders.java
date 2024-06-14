/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name = "Orders")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderNumber", query = "SELECT o FROM Orders o WHERE o.orderNumber = :orderNumber"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByRequiredDate", query = "SELECT o FROM Orders o WHERE o.requiredDate = :requiredDate"),
    @NamedQuery(name = "Orders.findByShippedDate", query = "SELECT o FROM Orders o WHERE o.shippedDate = :shippedDate"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status")})
public class Orders implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderNumber")
    private Integer orderNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requiredDate")
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column(name = "shippedDate")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "status")
    private String status;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Collection<Orderdetails> orderdetailsCollection;
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
    @ManyToOne(optional = false)
    private Customers customerNumber;

    public Orders(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

}
