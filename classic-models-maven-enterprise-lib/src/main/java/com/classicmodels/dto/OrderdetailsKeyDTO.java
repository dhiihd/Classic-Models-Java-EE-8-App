/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;



import java.io.Serializable;
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
public class OrderdetailsKeyDTO implements Serializable {

    private int orderNumber;
    @NonNull
    private String productCode;

}
