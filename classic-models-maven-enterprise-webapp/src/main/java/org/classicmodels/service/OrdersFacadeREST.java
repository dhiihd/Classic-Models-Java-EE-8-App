/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.OrdersDTO;
import com.classicmodels.statelessejb.remote.OrdersRemote;
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

@Path("com.classicmodels.orders")
public class OrdersFacadeREST  {

   
   @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/OrderdetailsFacade!com.classicmodels.statelessejb.remote.OrderdetailsRemote")
   private OrdersRemote ordersRemote;

    public OrdersRemote getOrdersRemote() {
        return ordersRemote;
    }

    public void setOrdersRemote(OrdersRemote ordersRemote) {
        this.ordersRemote = ordersRemote;
    }
    

    public OrdersFacadeREST() {
        
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void create(OrdersDTO ordersDTO) {
        ordersRemote.create(ordersDTO);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@QueryParam("id") Integer id, OrdersDTO ordersDTO) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        ordersRemote.edit(ordersDTO);
    }

    @DELETE
    public void remove(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        ordersRemote.remove(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        return Response.ok().entity(ordersRemote.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {
        
        Collection<OrdersDTO> ordersCollection = ordersRemote.findAll();
        return Response.ok().entity(ordersCollection).build();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        
        if (from == null || to == null ) throw new PathParamNotFoundException("You need to pass an from and to !");
        Collection<OrdersDTO> ordersCollection = ordersRemote.findRange(from, to);
        return Response.ok().entity(ordersCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok().entity(String.valueOf(ordersRemote.countREST())).build();
    }

  }
