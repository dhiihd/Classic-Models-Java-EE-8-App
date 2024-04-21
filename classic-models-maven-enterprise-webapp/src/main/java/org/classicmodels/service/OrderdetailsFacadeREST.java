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
@Path("com.classicmodels.orderdetails")
public class OrderdetailsFacadeREST {

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/OrderdetailsFacade!com.classicmodels.statelessejb.remote.OrderdetailsRemote")
    private OrderdetailsRemote orderdetailsRemote;

    private static final org.slf4j.Logger logger
            = LoggerFactory.getLogger(OrderdetailsFacadeREST.class);

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
    public Response create(OrderdetailsDTO orderdetailsDTO) {

        if (orderdetailsDTO != null) {
            orderdetailsRemote.create(orderdetailsDTO);
            return Response.ok().entity("Employee row is created successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, OrderdetailsDTO orderdetailsDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if ((id != null) && (orderdetailsDTO != null)) {
            orderdetailsRemote.edit(id, orderdetailsDTO);
            return Response.ok().entity("Orderdetails row is edited successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    public Response remove(@QueryParam("id") Integer id) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }

        if ((id != null)) {
            orderdetailsRemote.remove(id);
            return Response.ok().entity("Orderdetails row is removed successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {

        logger.info("Inside find @QueryParam --> " + id);

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        OrderdetailsDTO orderdetailsDTO = orderdetailsRemote.find(id);
        if (orderdetailsDTO != null) {
            return Response.ok(orderdetailsDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {

        Collection<OrderdetailsDTO> orderdetailsCollection = orderdetailsRemote.findAll();
        if (orderdetailsCollection != null) {
            return Response.ok(orderdetailsCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {

        if (from == null || to == null) {
            throw new PathParamNotFoundException("You need to pass an from and to !");
        }
        Collection<OrderdetailsDTO> orderdetailsCollection = orderdetailsRemote.findRange(from, to);
        if (orderdetailsCollection != null) {
            return Response.ok(orderdetailsCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        String count = orderdetailsRemote.countREST();
        if (Integer.parseInt(count) >= 0) {
            return Response.ok().entity(count).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
