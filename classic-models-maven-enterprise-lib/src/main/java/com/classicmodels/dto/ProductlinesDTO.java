/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.io.Serializable;
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
public class ProductlinesDTO implements Serializable {

    @NonNull
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private byte[] image;
  
    private Collection<ProductsDTO> productsCollection;

    public ProductlinesDTO(String productLine) {
        this.productLine = productLine;
    }
    
}
