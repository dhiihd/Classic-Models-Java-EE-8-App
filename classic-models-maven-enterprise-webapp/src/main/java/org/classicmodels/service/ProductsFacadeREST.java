/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.ProductsDTO;
import com.classicmodels.statelessejb.remote.ProductsRemote;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dhiihd
 */
@Path("com.classicmodels.products")
public class ProductsFacadeREST {

    @EJB(lookup = "ejb:classic.models.maven.enterprise-classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/ProductsFacade!com.classicmodels.statelessejb.remote.ProductsRemote")
    private ProductsRemote productsRemote;

    private static final Logger logger
            = LoggerFactory.getLogger(ProductsFacadeREST.class);

    public ProductsRemote getProductsRemote() {
        return productsRemote;
    }

    public void setProductsRemote(ProductsRemote productsRemote) {
        this.productsRemote = productsRemote;
    }

    public ProductsFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public Response create(ProductsDTO productsDTO) {

        if (productsDTO != null) {
            productsRemote.create(productsDTO);
            return Response.ok().entity("Employee row is created successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, ProductsDTO productsDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if ((id != null) && (productsDTO != null)) {
            productsRemote.edit(id, productsDTO);
            return Response.ok().entity("Products row is edited successfuly").build();
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
            productsRemote.remove(id);
            return Response.ok().entity("Products row is removed successfuly").build();
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
        ProductsDTO productsDTO = productsRemote.find(id);
        if (productsDTO != null) {
            return Response.ok(productsDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {

        Collection<ProductsDTO> productsCollection = productsRemote.findAll();
        if (productsCollection != null) {
            return Response.ok(productsCollection).build();
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
        Collection<ProductsDTO> productsCollection = productsRemote.findRange(from, to);
        if (productsCollection != null) {
            return Response.ok(productsCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        String count = productsRemote.countREST();
        if (Integer.parseInt(count) >= 0) {
            return Response.ok().entity(count).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
