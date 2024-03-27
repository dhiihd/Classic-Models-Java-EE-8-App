/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.EmployeesDTO;
import com.classicmodels.statelessejb.remote.EmployeesRemote;
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
@Path("com.classicmodels.employees")
public class EmployeesFacadeREST {

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/EmployeesFacade!com.classicmodels.statelessejb.remote.EmployeesRemote")
    private EmployeesRemote employeesRemote;

    public EmployeesRemote getEmployeesRemote() {
        return employeesRemote;
    }

    public void setEmployeesRemote(EmployeesRemote employeesRemote) {
        this.employeesRemote = employeesRemote;
    }

    public EmployeesFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    public void create(EmployeesDTO employeesDTO) {
        employeesRemote.create(employeesDTO);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public void edit(@QueryParam("id") Integer id, EmployeesDTO employeesDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        employeesRemote.edit(id, employeesDTO);
    }

    @DELETE
    public void remove(@QueryParam("id") Integer id) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        employeesRemote.remove(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        return Response.ok().entity(employeesRemote.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {

        Collection<EmployeesDTO> employeesCollection = employeesRemote.findAll();
        return Response.ok().entity(employeesCollection).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findRangeDTOs(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {

        if (from == null || to == null) {
            throw new PathParamNotFoundException("You need to pass an from and to !");
        }
        Collection<EmployeesDTO> employeesCollection = employeesRemote.findRange(from, to);
        return Response.ok().entity(employeesCollection).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return Response.ok().entity(String.valueOf(employeesRemote.countREST())).build();
    }

}
