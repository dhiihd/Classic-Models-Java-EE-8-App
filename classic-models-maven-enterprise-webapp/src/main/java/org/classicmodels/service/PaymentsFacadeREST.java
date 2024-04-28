/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.PaymentsDTO;
import com.classicmodels.statelessejb.remote.PaymentsRemote;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhiihd
 */
@Path("com.classicmodels.payments")
public class PaymentsFacadeREST {

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/PaymentsFacade!com.classicmodels.statelessejb.remote.PaymentsRemote")
    private PaymentsRemote paymentsRemote;

    private static final Logger logger
            = LoggerFactory.getLogger(PaymentsFacadeREST.class);

    public PaymentsRemote getPaymentsRemote() {
        return paymentsRemote;
    }

    public void setPaymentsRemote(PaymentsRemote paymentsRemote) {
        this.paymentsRemote = paymentsRemote;
    }

    public PaymentsFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public Response create(PaymentsDTO paymentsDTO) {

        if (paymentsDTO != null) {
            paymentsRemote.create(paymentsDTO);
            return Response.ok().entity("Employee row is created successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, PaymentsDTO paymentsDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if ((id != null) && (paymentsDTO != null)) {
            paymentsRemote.edit(id, paymentsDTO);
            return Response.ok().entity("Payments row is edited successfuly").build();
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
            paymentsRemote.remove(id);
            return Response.ok().entity("Payments row is removed successfuly").build();
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
        PaymentsDTO paymentsDTO = paymentsRemote.find(id);
        if (paymentsDTO != null) {
            return Response.ok(paymentsDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {

        Collection<PaymentsDTO> paymentsCollection = paymentsRemote.findAll();
        if (paymentsCollection != null) {
            return Response.ok(paymentsCollection).build();
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
        Collection<PaymentsDTO> paymentsCollection = paymentsRemote.findRange(from, to);
        if (paymentsCollection != null) {
            return Response.ok(paymentsCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        String count = paymentsRemote.countREST();
        if (Integer.parseInt(count) >= 0) {
            return Response.ok().entity(count).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
