/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.OfficesDTO;
import com.classicmodels.statelessejb.remote.OfficesRemote;
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

@Path("com.classicmodels.offices")
public class OfficesFacadeREST  {

   
   @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/OfficesFacade!com.classicmodels.statelessejb.remote.OfficesRemote")
   private OfficesRemote officesRemote;

    public OfficesRemote getOfficesRemote() {
        return officesRemote;
    }

    public void setOfficesRemote(OfficesRemote officesRemote) {
        this.officesRemote = officesRemote;
    }
    

    public OfficesFacadeREST() {
        
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void create(OfficesDTO officesDTO) {
        officesRemote.create(officesDTO);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@QueryParam("id") String id, OfficesDTO officesDTO) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        officesRemote.edit(id,officesDTO);
    }

    @DELETE
    public void remove(@QueryParam("id") String id) {
        
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        officesRemote.remove(id);
    }
 
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") String id) {
        System.out.println("Inside find @QueryParam --> OfficesFacadeREST "+id);
        if (id == null) throw new PathParamNotFoundException("You need to pass an Id!");
        OfficesDTO officesDTO = officesRemote.find(id);
        System.out.println("officesDTO --> "+officesDTO);
        return Response.ok().entity(officesDTO).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {
        
        Collection<OfficesDTO> officesCollection = officesRemote.findAll();
        return Response.ok().entity(officesCollection).build();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {
        
        if (from == null || to == null ) throw new PathParamNotFoundException("You need to pass an from and to !");
        Collection<OfficesDTO> officesCollection = officesRemote.findRange(from, to);
        return Response.ok().entity(officesCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok().entity(String.valueOf(officesRemote.countREST())).build();
    }

  }
