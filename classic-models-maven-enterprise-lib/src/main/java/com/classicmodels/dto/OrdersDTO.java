/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
public class OrdersDTO implements Serializable {

    @NonNull
    private Integer orderNumber;
    @NonNull
    private Date orderDate;
    @NonNull
    private Date requiredDate;
    private Date shippedDate;
    @NonNull
    private String status;
    private String comments;
    private Collection<OrderdetailsDTO> orderdetailsDTOCollection;
    private CustomersDTO customerNumber;

    public OrdersDTO(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

}
