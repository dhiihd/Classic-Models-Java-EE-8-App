/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.classicmodels.javafx.concurrent;

import com.classicmodels.dto.CustomersDTO;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author dhiihd
 */
public class CustomersService extends Service<CustomersDTO> {

    private CustomersTask customersTask = null;
    private CustomersDTO customersDTO = null;

    public void setCustomersDTO(CustomersDTO customersDTO) {
        this.customersDTO = customersDTO;
    }

    /**
     * Constructor
     */
    public CustomersService() {

        // if succeeded
        setOnSucceeded(s -> {
            //code if Service succeeds
            customersDTO = customersTask.getValue();
        });

        // if failed
        setOnFailed(fail -> {
            //code it Service fails
        });

        //if cancelled
        setOnCancelled(cancelled -> {
            //code if Service get's cancelled
        });
    }

    /**
     * This method starts the Service
     */
    public void startTheService() {
        if (!isRunning()) {
            //...
            reset();
            start();

        }

    }

    @Override
    public Task<CustomersDTO> createTask() {

        customersTask = new CustomersTask();
        return customersTask;

    }
}
