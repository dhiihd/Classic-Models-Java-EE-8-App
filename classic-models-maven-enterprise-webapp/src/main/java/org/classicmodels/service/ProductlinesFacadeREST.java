/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.ProductlinesDTO;
import com.classicmodels.statelessejb.remote.ProductlinesRemote;
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
@Path("com.classicmodels.productlines")
public class ProductlinesFacadeREST {

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/ProductlinesFacade!com.classicmodels.statelessejb.remote.ProductlinesRemote")
    private ProductlinesRemote productlinesRemote;

    private static final Logger logger
            = LoggerFactory.getLogger(ProductlinesFacadeREST.class);

    public ProductlinesRemote getProductlinesRemote() {
        return productlinesRemote;
    }

    public void setProductlinesRemote(ProductlinesRemote productlinesRemote) {
        this.productlinesRemote = productlinesRemote;
    }

    public ProductlinesFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public Response create(ProductlinesDTO productlinesDTO) {

        if (productlinesDTO != null) {
            productlinesRemote.create(productlinesDTO);
            return Response.ok().entity("Employee row is created successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, ProductlinesDTO productlinesDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if ((id != null) && (productlinesDTO != null)) {
            productlinesRemote.edit(id, productlinesDTO);
            return Response.ok().entity("Productlines row is edited successfuly").build();
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
            productlinesRemote.remove(id);
            return Response.ok().entity("Productlines row is removed successfuly").build();
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
        ProductlinesDTO productlinesDTO = productlinesRemote.find(id);
        if (productlinesDTO != null) {
            return Response.ok(productlinesDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {

        Collection<ProductlinesDTO> productlinesCollection = productlinesRemote.findAll();
        if (productlinesCollection != null) {
            return Response.ok(productlinesCollection).build();
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
        Collection<ProductlinesDTO> productlinesCollection = productlinesRemote.findRange(from, to);
        if (productlinesCollection != null) {
            return Response.ok(productlinesCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        String count = productlinesRemote.countREST();
        if (Integer.parseInt(count) >= 0) {
            return Response.ok().entity(count).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
