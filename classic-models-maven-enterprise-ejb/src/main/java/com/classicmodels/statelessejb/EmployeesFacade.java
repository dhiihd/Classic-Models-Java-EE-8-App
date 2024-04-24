/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.entity.Employees;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.mapstruct.dto.mapper.EmployeesMapper;
import com.classicmodels.statelessejb.remote.EmployeesRemote;
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
@Remote(EmployeesRemote.class)
public class EmployeesFacade extends AbstractFacade implements EmployeesRemote {

    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;

    public void create(EmployeesDTO employeesDTO) {
        super.createEntity(EmployeesMapper.INSTANCE.toEntity(employeesDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(Integer id, EmployeesDTO employeesDTO) {
        super.editEntity(EmployeesMapper.INSTANCE.toEntity(employeesDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(EmployeesDTO employeesDTO) {
        super.editEntity(EmployeesMapper.INSTANCE.toEntity(employeesDTO, new CycleAvoidingMappingContext()));
    }

    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id, Employees.class));
    }

    public EmployeesDTO find(Integer id) {
        return EmployeesMapper.INSTANCE.toDataObject((Employees) super.findEntity(id, Employees.class), new CycleAvoidingMappingContext());
    }

    public Collection<EmployeesDTO> findRange(Integer from, Integer to) {
        return EmployeesMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()}, Employees.class), new CycleAvoidingMappingContext());
    }

    public Collection<EmployeesDTO> findAll() {
        return EmployeesMapper.INSTANCE.toDataObject(super.findAllEntities(Employees.class), new CycleAvoidingMappingContext());
    }

    public String countREST() {
        return String.valueOf(super.countEntity(Employees.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
