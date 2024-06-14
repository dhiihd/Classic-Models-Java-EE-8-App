/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

/**
 *
 * @author dhiihd
 */
@ApplicationPath("/webresources")
//@ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.classicmodels.service.CustomersFacadeREST.class);
        resources.add(org.classicmodels.service.EmployeesFacadeREST.class);
        resources.add(org.classicmodels.service.OfficesFacadeREST.class);
        resources.add(org.classicmodels.service.OrderdetailsFacadeREST.class);
        resources.add(org.classicmodels.service.OrdersFacadeREST.class);
        resources.add(org.classicmodels.service.PaymentsFacadeREST.class);
        resources.add(org.classicmodels.service.ProductlinesFacadeREST.class);
        resources.add(org.classicmodels.service.ProductsFacadeREST.class);
    }

}
