/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.javafx.concurrent;

import com.classicmodels.dto.CustomersDTO;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

/**
 *
 * @author dhiihd
 */
public class CustomersTask extends Task<CustomersDTO> {

    public CustomersTask() {

    }

    private static final String FULL_PATH = "https://127.0.0.1:8443/classic-models-maven-enterprise-webapp/webresources/com.classicmodels.customers";

    private CustomersDTO customersDTO = null;

    public void setCustomersDTO(CustomersDTO customersDTO) {
        this.customersDTO = customersDTO;
    }

    @Override
    public CustomersDTO call() throws Exception {

        //  customersDTO = new CustomersDTO();
        //create other variables here
        /**
         * try {
         *
         * final ResteasyClient client = new ResteasyClientBuilder().build();
         * final ResteasyWebTarget target = client.target(FULL_PATH);
         * target.request().post(customersDTO, CustomersDTO.class);
         * System.out.println(customersDTO);
         *
         * //some code here //.....do your manipulation here //
         * updateProgress(++currentProgress, totalProgress); } catch (Exception
         * ex) { throw ex; // return null; //something bad happened so you have
         * to do something instead of returning null }
         *
         * Client client = ClientBuilder.newClient(); WebTarget target =
         * client.target(FULL_PATH); Invocation.Builder request =
         * (Invocation.Builder) target.request(); Response response = null; try
         * { // Person person = new Person(name,surname); response =
         * request.post(Entity.xml(customersDTO));
         * System.out.println(response.getStatusInfo()); } finally {
         * response.close(); client.close(); }
         */
        return customersDTO;
    }

}
