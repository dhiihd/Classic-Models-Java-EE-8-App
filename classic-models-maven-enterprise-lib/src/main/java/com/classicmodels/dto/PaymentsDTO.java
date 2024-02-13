/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class PaymentsDTO implements Serializable {

    protected PaymentsKeyDTO paymentsKeyDTO;
    @NonNull
    private Date paymentDate;
    @NonNull
    private BigDecimal amount;
    private CustomersDTO customers;

    public PaymentsDTO(PaymentsKeyDTO paymentsKeyDTO) {
        this.paymentsKeyDTO = paymentsKeyDTO;
    }

    public PaymentsDTO(int customerNumber, String checkNumber) {
        this.paymentsKeyDTO = new PaymentsKeyDTO(customerNumber, checkNumber);
    }

}
