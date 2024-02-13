/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.ProductsDTO;
import com.classicmodels.entity.Products;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.mapstruct.dto.mapper.ProductsMapper;
import com.classicmodels.statelessejb.remote.ProductsRemote;
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
@Remote(ProductsRemote.class)
public class ProductsFacade extends AbstractFacade implements ProductsRemote {
    
    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;


    public void create(ProductsDTO productsDTO) {
        super.createEntity(ProductsMapper.INSTANCE.toEntity(productsDTO,new CycleAvoidingMappingContext()));
    }

    public void edit(Integer id, ProductsDTO productsDTO) {
        super.editEntity(ProductsMapper.INSTANCE.toEntity(productsDTO,new CycleAvoidingMappingContext()));
    }

    public void edit(ProductsDTO productsDTO) {
        super.editEntity(ProductsMapper.INSTANCE.toEntity(productsDTO,new CycleAvoidingMappingContext()));
    }

    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id,Products.class));
    }

    public ProductsDTO find(Integer id) {
        return ProductsMapper.INSTANCE.toDataObject((Products)super.findEntity(id,Products.class),new CycleAvoidingMappingContext());
    }


    public Collection<ProductsDTO> findRange(Integer from, Integer to) {
        return ProductsMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()},Products.class),new CycleAvoidingMappingContext());
    }

    public Collection<ProductsDTO> findAll() {
    return ProductsMapper.INSTANCE.toDataObject(super.findAllEntities(Products.class),new CycleAvoidingMappingContext());
    }
    public String countREST() {
        return String.valueOf(super.countEntity(Products.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
