/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductCode", query = "SELECT p FROM Products p WHERE p.productCode = :productCode"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByProductScale", query = "SELECT p FROM Products p WHERE p.productScale = :productScale"),
    @NamedQuery(name = "Products.findByProductVendor", query = "SELECT p FROM Products p WHERE p.productVendor = :productVendor"),
    @NamedQuery(name = "Products.findByQuantityInStock", query = "SELECT p FROM Products p WHERE p.quantityInStock = :quantityInStock"),
    @NamedQuery(name = "Products.findByBuyPrice", query = "SELECT p FROM Products p WHERE p.buyPrice = :buyPrice"),
    @NamedQuery(name = "Products.findByMsrp", query = "SELECT p FROM Products p WHERE p.msrp = :msrp")})
public class Products implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "productCode")
    private String productCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "productName")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "productScale")
    private String productScale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "productVendor")
    private String productVendor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "productDescription")
    private String productDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantityInStock")
    private short quantityInStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyPrice")
    private BigDecimal buyPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MSRP")
    private BigDecimal msrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Collection<Orderdetails> orderdetailsCollection;
    @JoinColumn(name = "productLine", referencedColumnName = "productLine")
    @ManyToOne(optional = false)
    private Productlines productLine;

    public Products(String productCode) {
        this.productCode = productCode;
    }

}
