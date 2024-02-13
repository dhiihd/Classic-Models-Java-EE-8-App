/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.OrderdetailsDTO;
import com.classicmodels.statelessejb.remote.OrderdetailsRemote;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.classicmodels.service.exception.PathParamNotFoundException;

/**
 *
 * @author dhiihd
 */

@Path("com.classicmodels.orderdetails")
public class OrderdetailsFacadeREST  {

   
   @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/OrderdetailsFacade!com.classicmodels.statelessejb.remote.OrderdetailsRemote")
   private OrderdetailsRemote orderdetailsRemote;

    public OrderdetailsRemote getOrderdetailsRemote() {
        return orderdetailsRemote;
    }

    public void setOrderdetailsRemote(OrderdetailsRemote orderdetailsRemote) {
        this.orderdetailsRemote = orderdetailsRemote;
    }
    

    public OrderdetailsFacadeREST() {
        
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void create(OrderdetailsDTO orderdetailsDTO) {
        orderdetailsRemote.create(orderdetailsDTO);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@QueryParam("id") Integer id, OrderdetailsDTO orderdetailsDTO) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        orderdetailsRemote.edit(orderdetailsDTO);
    }

    @DELETE
    public void remove(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        orderdetailsRemote.remove(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        return Response.ok().entity(orderdetailsRemote.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {
        
        Collection<OrderdetailsDTO> orderdetailsCollection = orderdetailsRemote.findAll();
        return Response.ok().entity(orderdetailsCollection).build();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        
        if (from == null || to == null ) throw new PathParamNotFoundException("You need to pass an from and to !");
        Collection<OrderdetailsDTO> orderdetailsCollection = orderdetailsRemote.findRange(from, to);
        return Response.ok().entity(orderdetailsCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok().entity(String.valueOf(orderdetailsRemote.countREST())).build();
    }

  }
