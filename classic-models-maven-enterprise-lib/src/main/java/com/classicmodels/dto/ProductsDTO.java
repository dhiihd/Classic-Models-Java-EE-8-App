/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 * @author dhiihd
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO implements Serializable {

   @NonNull
    private String productCode;
   @NonNull
    private String productName;
   @NonNull
    private String productScale;
   @NonNull
    private String productVendor;
   @NonNull
    private String productDescription;
   private short quantityInStock;
   @NonNull
    private BigDecimal buyPrice;
   @NonNull
    private BigDecimal msrp;
    private Collection<OrderdetailsDTO> orderdetailsDTOCollection;
    private ProductlinesDTO productLineDTO;

 
    public ProductsDTO(String productCode) {
        this.productCode = productCode;
    }

 }
