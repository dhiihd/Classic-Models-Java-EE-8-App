/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.entity.Customers;
import com.classicmodels.mapstruct.dto.mapper.CustomersMapper;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.statelessejb.remote.CustomersRemote;
import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;


/**
 *
 * @author dhiihd
 */
@Stateless
@Remote(CustomersRemote.class)
public class CustomersFacade extends AbstractFacade implements CustomersRemote {
    
     private static final org.slf4j.Logger logger 
      =  LoggerFactory.getLogger(CustomersFacade.class);

    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;


    @Override
    @Transactional
    public void create(CustomersDTO customersDTO) {
        
        Customers customers = CustomersMapper.INSTANCE.toEntity(customersDTO,new CycleAvoidingMappingContext());
   //     customers.setCustomerNumber(customersDTO.getCustomerNumber());
        super.createEntity(customers);
    }

    @Override
    public void edit(Integer id, CustomersDTO customersDTO) {
        super.editEntity(CustomersMapper.INSTANCE.toEntity(customersDTO,new CycleAvoidingMappingContext()));
    }

    @Override
    public void edit(CustomersDTO customersDTO) {
        super.editEntity(CustomersMapper.INSTANCE.toEntity(customersDTO,new CycleAvoidingMappingContext()));
    }

    @Override
    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id,Customers.class));
    }

    public CustomersDTO find(Integer id) {
        return CustomersMapper.INSTANCE.toDataObject((Customers)super.findEntity(id,Customers.class),new CycleAvoidingMappingContext());
    }
    
    public CustomersDTO findByCustomerNumber(Integer id) 
    { 
        logger.info("Inside findByCustomerNumber");
        List<Customers> customersList = em.createNamedQuery("Customers.findByCustomerNumber")
                .setParameter("customerNumber", id)
                .getResultList();
        Customers customer = customersList.get(0);
        logger.info("Customer details name --> "+customer.getCustomerName());
        logger.info("Customer details salesRepEmployeeNumber() --> "+customer.getSalesRepEmployeeNumber());
        return CustomersMapper.INSTANCE.toDataObject(customer,new CycleAvoidingMappingContext());
    }
 

    public Collection<CustomersDTO> findRange(Integer from, Integer to) {
        return CustomersMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()},Customers.class),new CycleAvoidingMappingContext());
    }

    public Collection<CustomersDTO> findAll() {
    return CustomersMapper.INSTANCE.toDataObject(super.findAllEntities(Customers.class),new CycleAvoidingMappingContext());
    }
    public String countREST() {
        return String.valueOf(super.countEntity(Customers.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
