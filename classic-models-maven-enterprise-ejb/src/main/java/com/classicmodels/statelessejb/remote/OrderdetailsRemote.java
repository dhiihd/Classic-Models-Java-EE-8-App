/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.OrderdetailsDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface OrderdetailsRemote {
    

    public void create(OrderdetailsDTO orderdetailsDTO) ;

    public void edit(Integer id, OrderdetailsDTO orderdetailsDTO);

    public void edit(OrderdetailsDTO orderdetailsDTO) ;

    public void remove(Integer id);

    public OrderdetailsDTO find(Integer id);

    public Collection<OrderdetailsDTO> findRange(Integer from, Integer to);

    public Collection<OrderdetailsDTO> findAll();
    
    public String countREST();

}
