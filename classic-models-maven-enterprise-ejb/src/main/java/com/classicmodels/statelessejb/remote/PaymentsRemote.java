/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.PaymentsDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface PaymentsRemote {
    

    public void create(PaymentsDTO paymentsDTO) ;

    public void edit(Integer id, PaymentsDTO paymentsDTO);

    public void edit(PaymentsDTO paymentsDTO) ;

    public void remove(Integer id);

    public PaymentsDTO find(Integer id);

    public Collection<PaymentsDTO> findRange(Integer from, Integer to);

    public Collection<PaymentsDTO> findAll();
    
    public String countREST();

}
