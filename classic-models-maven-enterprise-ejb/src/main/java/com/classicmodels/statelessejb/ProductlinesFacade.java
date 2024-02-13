/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.ProductlinesDTO;
import com.classicmodels.entity.Productlines;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.mapstruct.dto.mapper.ProductlinesMapper;
import com.classicmodels.statelessejb.remote.ProductlinesRemote;
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
@Remote(ProductlinesRemote.class)
public class ProductlinesFacade extends AbstractFacade implements ProductlinesRemote {
    
    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;


    public void create(ProductlinesDTO productlinesDTO) {
        super.createEntity(ProductlinesMapper.INSTANCE.toEntity(productlinesDTO,new CycleAvoidingMappingContext()));
    }

    public void edit(Integer id, ProductlinesDTO productlinesDTO) {
        super.editEntity(ProductlinesMapper.INSTANCE.toEntity(productlinesDTO,new CycleAvoidingMappingContext()));
    }

    public void edit(ProductlinesDTO productlinesDTO) {
        super.editEntity(ProductlinesMapper.INSTANCE.toEntity(productlinesDTO,new CycleAvoidingMappingContext()));
    }

    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id,Productlines.class));
    }

    public ProductlinesDTO find(Integer id) {
        return ProductlinesMapper.INSTANCE.toDataObject((Productlines)super.findEntity(id,Productlines.class),new CycleAvoidingMappingContext());
    }


    public Collection<ProductlinesDTO> findRange(Integer from, Integer to) {
        return ProductlinesMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()},Productlines.class),new CycleAvoidingMappingContext());
    }

    public Collection<ProductlinesDTO> findAll() {
    return ProductlinesMapper.INSTANCE.toDataObject(super.findAllEntities(Productlines.class),new CycleAvoidingMappingContext());
    }
    public String countREST() {
        return String.valueOf(super.countEntity(Productlines.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
