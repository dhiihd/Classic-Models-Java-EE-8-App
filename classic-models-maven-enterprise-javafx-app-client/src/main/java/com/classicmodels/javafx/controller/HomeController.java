/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.classicmodels.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author dhiihd
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnCustomer;
    @FXML
    private Button btnStudents;
    @FXML
    private Button btn_Timetable;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnClasses;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonClicks(ActionEvent event) {
        
        try {
            App.setRoot("CustomersFXML");
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void handleButtonClicks1(ActionEvent event) {
        
        try {
            App.setRoot("CustomersChartsFXML");
            
           // CustomersChartsFXMLController customersChartsFXMLController = new CustomersChartsFXMLController();
           // customersChartsFXMLController.initUI();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
