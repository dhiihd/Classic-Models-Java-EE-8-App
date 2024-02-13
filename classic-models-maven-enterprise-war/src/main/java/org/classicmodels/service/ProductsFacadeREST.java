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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.classicmodels.service.exception.PathParamNotFoundException;

/**
 *
 * @author dhiihd
 */

@Path("com.classicmodels.products")
public class ProductsFacadeREST  {

   
   @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/ProductsFacade!com.classicmodels.statelessejb.remote.ProductsRemote")
   private ProductsRemote productsRemote;

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
    public void create(ProductsDTO productsDTO) {
        productsRemote.create(productsDTO);
    }

    @PUT
    
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@QueryParam("id") Integer id, ProductsDTO productsDTO) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        productsRemote.edit(productsDTO);
    }

    @DELETE
    public void remove(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        productsRemote.remove(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        return Response.ok().entity(productsRemote.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {
        
        Collection<ProductsDTO> productsCollection = productsRemote.findAll();
        return Response.ok().entity(productsCollection).build();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        
        if (from == null || to == null ) throw new PathParamNotFoundException("You need to pass an from and to !");
        Collection<ProductsDTO> productsCollection = productsRemote.findRange(from, to);
        return Response.ok().entity(productsCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok().entity(String.valueOf(productsRemote.countREST())).build();
    }

  }
