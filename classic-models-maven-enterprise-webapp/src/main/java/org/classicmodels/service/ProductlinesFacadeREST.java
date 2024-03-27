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

@Path("com.classicmodels.productlines")
public class ProductlinesFacadeREST  {

   
   @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/ProductlinesFacade!com.classicmodels.statelessejb.remote.ProductlinesRemote")
   private ProductlinesRemote productlinesRemote;

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
    public void create(ProductlinesDTO productlinesDTO) {
        productlinesRemote.create(productlinesDTO);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@QueryParam("id") Integer id, ProductlinesDTO productlinesDTO) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        productlinesRemote.edit(productlinesDTO);
    }

    @DELETE
    public void remove(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        productlinesRemote.remove(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        return Response.ok().entity(productlinesRemote.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {
        
        Collection<ProductlinesDTO> productlinesCollection = productlinesRemote.findAll();
        return Response.ok().entity(productlinesCollection).build();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        
        if (from == null || to == null ) throw new PathParamNotFoundException("You need to pass an from and to !");
        Collection<ProductlinesDTO> productlinesCollection = productlinesRemote.findRange(from, to);
        return Response.ok().entity(productlinesCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok().entity(String.valueOf(productlinesRemote.countREST())).build();
    }

  }
