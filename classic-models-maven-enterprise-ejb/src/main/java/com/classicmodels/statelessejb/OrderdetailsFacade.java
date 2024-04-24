/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.OrderdetailsDTO;
import com.classicmodels.entity.Orderdetails;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.mapstruct.dto.mapper.OrderdetailsMapper;
import com.classicmodels.statelessejb.remote.OrderdetailsRemote;
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
@Remote(OrderdetailsRemote.class)
public class OrderdetailsFacade extends AbstractFacade implements OrderdetailsRemote {

    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;

    public void create(OrderdetailsDTO orderdetailsDTO) {
        super.createEntity(OrderdetailsMapper.INSTANCE.toEntity(orderdetailsDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(Integer id, OrderdetailsDTO orderdetailsDTO) {
        super.editEntity(OrderdetailsMapper.INSTANCE.toEntity(orderdetailsDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(OrderdetailsDTO orderdetailsDTO) {
        super.editEntity(OrderdetailsMapper.INSTANCE.toEntity(orderdetailsDTO, new CycleAvoidingMappingContext()));
    }

    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id, Orderdetails.class));
    }

    public OrderdetailsDTO find(Integer id) {
        return OrderdetailsMapper.INSTANCE.toDataObject((Orderdetails) super.findEntity(id, Orderdetails.class), new CycleAvoidingMappingContext());
    }

    public Collection<OrderdetailsDTO> findRange(Integer from, Integer to) {
        return OrderdetailsMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()}, Orderdetails.class), new CycleAvoidingMappingContext());
    }

    public Collection<OrderdetailsDTO> findAll() {
        return OrderdetailsMapper.INSTANCE.toDataObject(super.findAllEntities(Orderdetails.class), new CycleAvoidingMappingContext());
    }

    public String countREST() {
        return String.valueOf(super.countEntity(Orderdetails.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
