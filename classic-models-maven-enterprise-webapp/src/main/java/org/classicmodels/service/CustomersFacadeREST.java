/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.classicmodels.service;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.statelessejb.remote.CustomersRemote;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import org.classicmodels.service.exception.PathParamNotFoundException;
import org.slf4j.LoggerFactory;
import java.io.StringWriter;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.classicmodels.dto.CountriesDTO;
import com.classicmodels.dto.CreditLimitsDTO;
import java.math.BigDecimal;

/**
 *
 * @author dhiihd
 */
@Path("com.classicmodels.customers")
public class CustomersFacadeREST {

    private static final org.slf4j.Logger logger
            = LoggerFactory.getLogger(CustomersFacadeREST.class);

    public CustomersRemote getCustomersRemote() {
        return customersRemote;
    }

    public void setCustomersRemote(CustomersRemote customersRemote) {
        this.customersRemote = customersRemote;
    }

    @EJB(lookup = "ejb:classic-models-maven-enterprise-ear-1.0-RELEASE/classic.models.maven.enterprise-classic-models-maven-enterprise-ejb-1.0-RELEASE/CustomersFacade!com.classicmodels.statelessejb.remote.CustomersRemote")
    private CustomersRemote customersRemote;

    public CustomersFacadeREST() {

    }

    @GET
    @Path("/creditlimits")
    @Produces({MediaType.APPLICATION_XML})
    public Response findCustomerCreditLimits(@QueryParam("country") String country) {

        if (country == null) {
            throw new PathParamNotFoundException("You need to select a country!");
        }

        logger.info("findCustomerCreditLimits --> " + country);
        List<BigDecimal> customersCreditLimitsList = customersRemote.findCustomerCreditLimits(country);
        CreditLimitsDTO creditLimitsDTO = new CreditLimitsDTO();
        creditLimitsDTO.setCreditLimits(customersCreditLimitsList);
        logger.info("customersCreditLimitsList --> " + customersCreditLimitsList);
        //   GenericEntity<List<Integer>> entity = new GenericEntity<List<Integer>>(customersCreditLimitsList) {};
        Response response = Response.ok().entity(creditLimitsDTO).build();
        logger.info("customersCreditLimitsList response --> " + ((Response) response).getEntity());
        if (creditLimitsDTO != null) {
            return response;
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response create(CustomersDTO customersDTO) {
        if (customersDTO != null) {
            customersRemote.create(customersDTO);
            return Response.ok().entity("Customers row is created successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response edit(@QueryParam("id") Integer id, CustomersDTO customersDTO) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if (customersDTO != null) {
            customersRemote.edit(customersDTO);
            return Response.ok().entity("Customers row is edited successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces({MediaType.APPLICATION_XML})
    public Response remove(@QueryParam("id") Integer id) {

        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }
        if (id != null) {
            customersRemote.remove(id);
            return Response.ok().entity("Customers row is removed successfuly").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/single")
    @Produces({MediaType.APPLICATION_XML})
    public Response find(@QueryParam("id") Integer id) {
        logger.info("Inside find @QueryParam --> " + id);
        if (id == null) {
            throw new PathParamNotFoundException("You need to pass an Id!");
        }

        CustomersDTO customersDTO = customersRemote.find(id);
        if (customersDTO != null) {
            return Response.ok(customersDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public Response findAll() {

        Collection<CustomersDTO> customersCollection = customersRemote.findAll();
        if (customersCollection != null) {
            return Response.ok().entity(customersCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("/countries")
    @Produces({MediaType.APPLICATION_XML})
    public Response findCountries() {
        logger.info("Inside find findCountries --> ");

        List<String> countriesCollection = customersRemote.findCountries();
        logger.info("countriesCollections --> " + countriesCollection);
        //   return countriesCollection;
        //   StringWriter stringWriter = new StringWriter();
        CountriesDTO countriesDTO = new CountriesDTO();
        countriesDTO.setCountries(countriesCollection);
        /*
        try {
            JAXBContext jc = JAXBContext.newInstance(CountriesDTO.class);
        CountriesDTO  content = new CountriesDTO();
        content.setCountries(countriesCollection);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(content, System.out);
        } catch (JAXBException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
         */
        if (countriesDTO != null) {
            return Response.ok().entity(countriesDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        //  return Response.ok(stringWriter.toString(), MediaType.APPLICATION_XML).build();       
        /*
        GenericEntity<List<String>> entity = new GenericEntity<List<String>>(countriesCollection) {};
        if (countriesCollection != null) {
            return Response.ok().entity(entity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        } 
         */
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findRange(@QueryParam("from") Integer from, @QueryParam("to") Integer to) {

        if (from == null || to == null) {
            throw new PathParamNotFoundException("You need to pass an from and to !");
        }

        Collection<CustomersDTO> customersCollection = customersRemote.findRange(from, to);
        if (customersCollection != null) {
            return Response.ok().entity(customersCollection).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        System.out.println("Inside find countREST()");
        String count = customersRemote.countREST();
        if (Integer.parseInt(count) >= 0) {
            return Response.ok().entity(count).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
