/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import com.classicmodels.dto.PaymentsDTO;
import com.classicmodels.entity.Payments;
import com.classicmodels.mapstruct.dto.mapper.CycleAvoidingMappingContext;
import com.classicmodels.statelessejb.remote.PaymentsRemote;
import java.util.Collection;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.classicmodels.mapstruct.dto.mapper.PaymentsMapper;

/**
 *
 * @author dhiihd
 */
@Stateless
@Remote(PaymentsRemote.class)
public class PaymentsFacade extends AbstractFacade implements PaymentsRemote {

    @PersistenceContext(unitName = "classic-models-maven-enterprise-PU")
    private EntityManager em;

    public void create(PaymentsDTO paymentsDTO) {
        super.createEntity(PaymentsMapper.INSTANCE.toEntity(paymentsDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(Integer id, PaymentsDTO paymentsDTO) {
        super.editEntity(PaymentsMapper.INSTANCE.toEntity(paymentsDTO, new CycleAvoidingMappingContext()));
    }

    public void edit(PaymentsDTO paymentsDTO) {
        super.editEntity(PaymentsMapper.INSTANCE.toEntity(paymentsDTO, new CycleAvoidingMappingContext()));
    }

    public void remove(Integer id) {
        super.removeEntity(super.findEntity(id, Payments.class));
    }

    public PaymentsDTO find(Integer id) {
        return PaymentsMapper.INSTANCE.toDataObject((Payments) super.findEntity(id, Payments.class), new CycleAvoidingMappingContext());
    }

    public Collection<PaymentsDTO> findRange(Integer from, Integer to) {
        return PaymentsMapper.INSTANCE.toDataObject(super.findRangeEntities(new int[]{from.intValue(), to.intValue()}, Payments.class), new CycleAvoidingMappingContext());
    }

    public Collection<PaymentsDTO> findAll() {
        return PaymentsMapper.INSTANCE.toDataObject(super.findAllEntities(Payments.class), new CycleAvoidingMappingContext());
    }

    public String countREST() {
        return String.valueOf(super.countEntity(Payments.class));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
