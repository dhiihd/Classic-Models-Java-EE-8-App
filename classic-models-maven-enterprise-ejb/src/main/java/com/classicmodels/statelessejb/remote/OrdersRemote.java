/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.classicmodels.statelessejb.remote;

import com.classicmodels.dto.OrdersDTO;
import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author dhiihd
 */
@Remote
public interface OrdersRemote {

    public void create(OrdersDTO ordersDTO);

    public void edit(Integer id, OrdersDTO ordersDTO);

    public void edit(OrdersDTO ordersDTO);

    public void remove(Integer id);

    public OrdersDTO find(Integer id);

    public Collection<OrdersDTO> findRange(Integer from, Integer to);

    public Collection<OrdersDTO> findAll();

    public String countREST();

}
