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
import javax.persistence.Lob;
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
@Table(name = "productlines")
@NamedQueries({
    @NamedQuery(name = "Productlines.findAll", query = "SELECT p FROM Productlines p"),
    @NamedQuery(name = "Productlines.findByProductLine", query = "SELECT p FROM Productlines p WHERE p.productLine = :productLine"),
    @NamedQuery(name = "Productlines.findByTextDescription", query = "SELECT p FROM Productlines p WHERE p.textDescription = :textDescription")})
public class Productlines implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "productLine")
    private String productLine;
    @Size(max = 4000)
    @Column(name = "textDescription")
    private String textDescription;
    @Lob
    @Size(max = 16777215)
    @Column(name = "htmlDescription")
    private String htmlDescription;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productLine")
    private Collection<Products> productsCollection;

    public Productlines(String productLine) {
        this.productLine = productLine;
    }
    
}
