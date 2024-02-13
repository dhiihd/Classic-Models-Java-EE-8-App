/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;


import java.io.Serializable;
import java.math.BigDecimal;
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
public class OrderdetailsDTO implements Serializable {

    protected OrderdetailsKeyDTO orderdetailsKeyDTO;
    private int quantityOrdered;
    @NonNull
    private BigDecimal priceEach;
    private short orderLineNumber;
    private OrdersDTO orders;
    private ProductsDTO products;

 
    public OrderdetailsDTO(OrderdetailsKeyDTO orderdetailsKeyDTO) {
        this.orderdetailsKeyDTO = orderdetailsKeyDTO;
    }


    public OrderdetailsDTO(int orderNumber, String productCode) {
        this.orderdetailsKeyDTO = new OrderdetailsKeyDTO(orderNumber, productCode);
    }

    
}
