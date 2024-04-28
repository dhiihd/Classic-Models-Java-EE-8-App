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
@Path("com.classicmodels.employees")
public class EmployeesFacadeREST {

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/EmployeesFacade!com.classicmodels.statelessejb.remote.EmployeesRemote")
    private EmployeesRemote employeesRemote;

    private static final Logger logger
            = LoggerFactory.getLogger(EmployeesFacadeREST.class);

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
    public Response create(EmployeesDTO employeesDTO) {

        if (employeesDTO != null) {
            employeesRemote.create(employeesDTO);
            return Response.ok().entity("Employee row is created successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, EmployeesDTO employeesDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if ((id != null) && (employeesDTO != null)) {
            employeesRemote.edit(id, employeesDTO);
            return Response.ok().entity("Employees row is edited successfuly").build();
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
            employeesRemote.remove(id);
            return Response.ok().entity("Employees row is removed successfuly").build();
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
        EmployeesDTO employeesDTO = employeesRemote.find(id);
        if (employeesDTO != null) {
            return Response.ok(employeesDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAllDTOs() {

        Collection<EmployeesDTO> employeesCollection = employeesRemote.findAll();
        if (employeesCollection != null) {
            return Response.ok(employeesCollection).build();
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
        Collection<EmployeesDTO> employeesCollection = employeesRemote.findRange(from, to);
        if (employeesCollection != null) {
            return Response.ok(employeesCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        String count = employeesRemote.countREST();
        if (Integer.parseInt(count) >= 0) {
            return Response.ok().entity(count).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
