/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.statelessejb;

import java.util.Collection;
import javax.persistence.EntityManager;

/**
 *
 * @author dhiihd
 */
public abstract class AbstractFacade {

    protected abstract EntityManager getEntityManager();

    public void createEntity(Object entity) {
        getEntityManager().persist(entity);
    }

    public void editEntity(Object entity) {
        getEntityManager().merge(entity);
    }

    public void removeEntity(Object entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Object findEntity(Object id, Class entityClass) {
        return getEntityManager().find(entityClass, id);
    }

    public Collection findAllEntities(Class entityClass) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public Collection findRangeEntities(int[] range, Class entityClass) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int countEntity(Class entityClass) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
