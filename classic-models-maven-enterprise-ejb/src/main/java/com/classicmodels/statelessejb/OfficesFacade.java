/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.entity.Customers;
import com.classicmodels.entity.Offices;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.mapstruct.dto.mapper.OfficesMapper;
import com.classicmodels.statelessejb.remote.OfficesRemote;
import java.util.Collection;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhiihd
 */
@Stateless
@Remote(OfficesRemote.class)
public class OfficesFacade extends AbstractFacade implements OfficesRemote {

    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;

    public void create(OfficesDTO officesDTO) {
        super.createEntity(OfficesMapper.INSTANCE.toEntity(officesDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(String id, OfficesDTO officesDTO) {
        super.editEntity(OfficesMapper.INSTANCE.toEntity(officesDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(OfficesDTO officesDTO) {
        super.editEntity(OfficesMapper.INSTANCE.toEntity(officesDTO, new CycleAvoidingMappingContext()));
    }

    public void remove(String id) {
        super.removeEntity(super.findEntity(id, Offices.class));
    }

    public OfficesDTO find(String id) {

        System.out.println("Inside Offices.findByOfficeCode");
        List<Offices> officesList = em.createNamedQuery("Offices.findByOfficeCode")
                .setParameter("officeCode", id)
                .getResultList();
        Offices offices = officesList.get(0);
        System.out.println("Office Code --> " + offices.getOfficeCode());
        System.out.println("Offices details --> " + offices);
        OfficesDTO officesDTO = OfficesMapper.INSTANCE.toDataObject(offices, new CycleAvoidingMappingContext());
        System.out.println("Inside Offices.findByOfficeCode + " + officesDTO);
        return officesDTO;
    }

    public Collection<OfficesDTO> findRange(Integer from, Integer to) {
        return OfficesMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()}, Offices.class), new CycleAvoidingMappingContext());
    }

    public Collection<OfficesDTO> findAll() {
        return OfficesMapper.INSTANCE.toDataObject(super.findAllEntities(Offices.class), new CycleAvoidingMappingContext());
    }

    public String countREST() {
        return String.valueOf(super.countEntity(Offices.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
