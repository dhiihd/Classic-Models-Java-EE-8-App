/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.OrdersDTO;
import com.classicmodels.entity.Orders;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.mapstruct.dto.mapper.OrdersMapper;
import com.classicmodels.statelessejb.remote.OrdersRemote;
import java.util.Collection;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhiihd
 */
@Stateless
@Remote(OrdersRemote.class)
public class OrdersFacade extends AbstractFacade implements OrdersRemote {

    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;

    public void create(OrdersDTO ordersDTO) {
        super.createEntity(OrdersMapper.INSTANCE.toEntity(ordersDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(Integer id, OrdersDTO ordersDTO) {
        super.editEntity(OrdersMapper.INSTANCE.toEntity(ordersDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(OrdersDTO ordersDTO) {
        super.editEntity(OrdersMapper.INSTANCE.toEntity(ordersDTO, new CycleAvoidingMappingContext()));
    }

    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id, Orders.class));
    }

    public OrdersDTO find(Integer id) {
        return OrdersMapper.INSTANCE.toDataObject((Orders) super.findEntity(id, Orders.class), new CycleAvoidingMappingContext());
    }

    public Collection<OrdersDTO> findRange(Integer from, Integer to) {
        return OrdersMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()}, Orders.class), new CycleAvoidingMappingContext());
    }

    public Collection<OrdersDTO> findAll() {
        return OrdersMapper.INSTANCE.toDataObject(super.findAllEntities(Orders.class), new CycleAvoidingMappingContext());
    }

    public String countREST() {
        return String.valueOf(super.countEntity(Orders.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
