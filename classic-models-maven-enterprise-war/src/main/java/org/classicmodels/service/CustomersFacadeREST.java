/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.statelessejb.remote.CustomersRemote;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.classicmodels.service.exception.PathParamNotFoundException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhiihd
 */
@Path("com.classicmodels.customers")
public class CustomersFacadeREST {
    
     private static final org.slf4j.Logger logger 
      =  LoggerFactory.getLogger(CustomersFacadeREST.class);

    public CustomersRemote getCustomersRemote() {
        return customersRemote;
    }

    public void setCustomersRemote(CustomersRemote customersRemote) {
        this.customersRemote = customersRemote;
    }

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/CustomersFacade!com.classicmodels.statelessejb.remote.CustomersRemote")
    private CustomersRemote customersRemote;

    public CustomersFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response create(CustomersDTO customersDTO) {
        customersRemote.create(customersDTO);
        return Response.ok().entity("Customers row is created successfuly").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, CustomersDTO customersDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        customersRemote.edit(customersDTO);
        return Response.ok().entity("Customers row is edited successfuly").build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_XML})
    public Response remove(@QueryParam("id") Integer id) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        customersRemote.remove(id);
        return Response.ok().entity("Customers row is removed successfuly").build();
    }

    @GET
    @Path("/single")
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {
        logger.info("Inside find @QueryParam --> "+id);
        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        CustomersDTO customersDTO = customersRemote.find(id);
        if (customersDTO != null) {
            return Response.ok(customersDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAll() {

        Collection<CustomersDTO> customersCollection = customersRemote.findAll();
        if (customersCollection != null) {
              return Response.ok().entity(customersCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
      

    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRange(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {

        if (from == null || to == null) {
            throw new PathParamNotFoundException("You need to pass an from and to !");
        }
        Collection<CustomersDTO> customersCollection = customersRemote.findRange(from, to);
        return Response.ok().entity(customersCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        return Response.ok().entity(String.valueOf(customersRemote.countREST())).build();
    }

}
