/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.classicmodels.javafx.controller;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.javafx.concurrent.CustomersService;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.Validator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import javafx.scene.control.Button;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * FXML Controller class
 *
 * @author dhiihd
 */
public class CustomersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private CustomersDTO customersDTO = null;
    private CustomersService customersService = null;

    private static final org.slf4j.Logger logger
            = LoggerFactory.getLogger(CustomersController.class);

    @FXML
    private Label customerNumberLabel;
    @FXML
    private TextField customerNumberTextField;
    @FXML
    private Label customerNameLabel;
    @FXML
    private TextField customerNameTextField;
    @FXML
    private Label contactLastNameLabel;
    @FXML
    private TextField contactLastNameTextField;
    @FXML
    private Label contactFirstNameLabel;
    @FXML
    private TextField contactFirstNameTextField;
    @FXML
    private Label phoneLabel;
    @FXML
    private TextField phoneTextField;
    @FXML
    private Label addressLine1Label;
    @FXML
    private TextField addressLine1TextField;
    @FXML
    private Label addressLine2Label;
    @FXML
    private TextField addressLine2TextField;
    @FXML
    private Label cityLabel;
    @FXML
    private TextField cityTextField;
    @FXML
    private Label stateLabel;
    @FXML
    private TextField stateTextField;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private TextField postalCodeTextField;
    @FXML
    private Label countryLabel;
    @FXML
    private TextField countryTextField;
    @FXML
    private Label creditLimitLabel;
    @FXML
    private TextField creditLimitTextField;

    @FXML
    private Button btnAddCustomers;

    private Validator validator = null;

    private Check customerNumberCheck = null;

    private Check customerNameCheck = null;

    private Check contactFirstNameCheck = null;

    private Check contactLastNameCheck = null;

    private Check phoneCheck = null;

    private Check stateCheck = null;

    private Check addressLine1Check = null;

    private Check addressLine2Check = null;

    private Check cityCheck = null;

    private Check countryCheck = null;

    private Check creditLimitCheck = null;

    private Check postalCodeCheck = null;

    private String statusInfo = null;

    private Dialog<String> dialog = new Dialog<String>();

    private static final String BASE_URL = "http://127.0.0.1:8080/classic-models-maven-enterprise-webapp/webresources/com.classicmodels.customers";

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  customersService = new CustomersService();
        // customersService.startTheService();

        validator = new Validator();

        customerNumberCheck = validator.createCheck().decorates(customerNumberTextField);

        customerNameCheck = validator.createCheck().decorates(customerNameTextField);

        contactFirstNameCheck = validator.createCheck().decorates(contactFirstNameTextField);

        contactLastNameCheck = validator.createCheck().decorates(contactLastNameTextField);

        phoneCheck = validator.createCheck().decorates(phoneTextField);

        stateCheck = validator.createCheck().decorates(stateTextField);

        addressLine1Check = validator.createCheck().decorates(addressLine1TextField);

        addressLine2Check = validator.createCheck().decorates(addressLine2TextField);

        cityCheck = validator.createCheck().decorates(cityTextField);

        countryCheck = validator.createCheck().decorates(countryTextField);

        creditLimitCheck = validator.createCheck().decorates(creditLimitTextField);

        postalCodeCheck = validator.createCheck().decorates(postalCodeTextField);

        customerNameCheck.dependsOn("customerName", customerNameTextField.textProperty())
                .withMethod(c -> {
                    String customerName = c.get("customerName");
                    if (!(customerName.trim().equals("")) && !(Pattern.matches("[a-zA-Z0-9\\s.,]+", customerName))) {
                        c.error("Please use only alphanumeric,numbers,dot,comma and space characters");
                    }

                    if ((customersDTO != null)) {
                        if ((customerName.trim().equals(""))) {
                            c.error("Customer Name can't be empty");
                        }
                    }

                })
                .decorates(customerNameTextField)
                .immediate();

        postalCodeCheck.dependsOn("postalCode", postalCodeTextField.textProperty())
                .withMethod(c -> {
                    String postalCode = c.get("postalCode");
                    if (!(postalCode.trim().equals("")) && !(Pattern.matches("[a-zA-Z0-9\\s-]+", postalCode))) {
                        c.error("Please use only alphanumeric,numbers and space characters");
                    }

                    if ((customersDTO != null)) {
                        if ((postalCode.trim().equals(""))) {
                            c.error("Customer Name can't be empty");
                        }
                    }

                })
                .decorates(postalCodeTextField)
                .immediate();

        contactFirstNameCheck.dependsOn("contactFirstName", contactFirstNameTextField.textProperty())
                .withMethod(c -> {
                    String contactFirstName = c.get("contactFirstName").toString().trim();
                    if (!(contactFirstName.equals("")) && !(StringUtils.isAlphanumeric(contactFirstName))) {
                        c.error("Please use only alphanumeric");
                    }

                    if ((customersDTO != null)) {
                        if ((contactFirstName.trim().equals(""))) {
                            c.error("Contact First Name can't be empty");
                        }
                    }

                })
                .decorates(contactFirstNameTextField)
                .immediate();

        contactLastNameCheck.dependsOn("contactLastName", contactLastNameTextField.textProperty())
                .withMethod(c -> {
                    String contactLastName = c.get("contactLastName");
                    if (!(contactLastName.trim().equals("")) && !(StringUtils.isAlphanumeric(contactLastName))) {
                        c.error("Please use only alphanumeric");
                    }

                    if ((customersDTO != null)) {
                        if ((contactLastName.trim().equals(""))) {
                            c.error("Contact Last Name can't be empty");
                        }
                    }

                })
                .decorates(contactLastNameTextField)
                .immediate();

        phoneCheck.dependsOn("phone", phoneTextField.textProperty())
                .withMethod(c -> {
                    String phone = c.get("phone").toString().trim();
                    if (!(phone.equals("")) && !(Pattern.matches("[a-zA-Z0-9\\s()\\-\\+\\.]+", phone))) {
                        c.error("Please use only alphanumeric,numbers,dot,hyphen,plus,paranthesis and space characters");
                    }

                    if ((customersDTO != null)) {
                        if ((phone.trim().equals(""))) {
                            c.error("Phone can't be empty");
                        }
                    }

                })
                .decorates(phoneTextField)
                .immediate();
        stateCheck.dependsOn("state", stateTextField.textProperty())
                .withMethod(c -> {
                    String state = c.get("state").toString().trim();
                    if (!(state.equals("")) && !(Pattern.matches("[a-zA-Z0-9\\s]+", state))) {
                        c.error("Please use only alphanumeric and space characters");
                    }

                    if ((customersDTO != null)) {
                        if ((state.trim().equals(""))) {
                            c.error("State can't be empty");
                        }
                    }

                })
                .decorates(stateTextField)
                .immediate();

        addressLine1Check.dependsOn("addressLine1", addressLine1TextField.textProperty())
                .withMethod(c -> {
                    String addressLine1 = c.get("addressLine1");
                    /*     if (!(addressLine1.trim().equals("")) && !(StringUtils.isAlphanumeric(addressLine1))) {
                        c.error("Please use only alphanumeric");
                    } */

                    if ((customersDTO != null)) {
                        if ((addressLine1.trim().equals(""))) {
                            c.error("AddressLine1 can't be empty");
                        }
                    }

                })
                .decorates(addressLine1TextField)
                .immediate();

        addressLine2Check.dependsOn("addressLine2", addressLine2TextField.textProperty())
                .withMethod(c -> {
                    String addressLine2 = c.get("addressLine2");
                    /*     if (!(addressLine1.trim().equals("")) && !(StringUtils.isAlphanumeric(addressLine1))) {
                        c.error("Please use only alphanumeric");
                    } */

                    if ((customersDTO != null)) {
                        if ((addressLine2.trim().equals(""))) {
                            c.error("AddressLine2 can't be empty");
                        }
                    }

                })
                .decorates(addressLine2TextField)
                .immediate();

        cityCheck.dependsOn("city", cityTextField.textProperty())
                .withMethod(c -> {
                    String city = c.get("city");
                    if (!(city.trim().equals("")) && !(Pattern.matches("[a-zA-Z0-9\\s.-]+", city))) {
                        c.error("Please use only alphanumeric,numbers,dot and space characters");
                    }

                    if ((customersDTO != null)) {
                        if ((city.trim().equals(""))) {
                            c.error("City can't be empty");
                        }
                    }

                })
                .decorates(cityTextField)
                .immediate();

        countryCheck.dependsOn("country", countryTextField.textProperty())
                .withMethod(c -> {
                    String country = c.get("country");
                    if (!(country.trim().equals("")) && !(StringUtils.isAlphanumeric(country))) {
                        c.error("Please use only alphanumeric");
                    }

                    if ((customersDTO != null)) {
                        if ((country.trim().equals(""))) {
                            c.error("Country can't be empty");
                        }

                    }

                })
                .decorates(countryTextField)
                .immediate();

        customerNumberCheck.dependsOn("customerNumber", customerNumberTextField.textProperty())
                .withMethod(c -> {
                    String customerNumber = c.get("customerNumber");
                    if ((statusInfo != null) && !(statusInfo.trim().equals("OK"))) {

                        logger.info("fasfasfs Inside validator ");

                        c.error(statusInfo);

                        statusInfo = null;

                    } else {

                        if ((customerNumber != null) && !(customerNumber.trim().equals(""))) {

                            // else
                            //     c.error("Please use only number.");
                            try {
                                Integer customerNumberIntValue = new Integer(customerNumber.trim());
                                if (customersDTO != null) {
                                    customersDTO.setCustomerNumber(new Integer(customerNumberIntValue).intValue());
                                }
                            } catch (NumberFormatException ex) {
                                ex.printStackTrace();
                                c.error("Please use only number.");
                            }
                        }

                        if ((customersDTO != null)) {
                            if ((customerNumber.trim().equals(""))) {
                                c.error("Customer Number can't be empty");
                            }
                        }
                    }
                })
                .decorates(customerNumberTextField)
                .immediate();

        creditLimitCheck.dependsOn("creditLimit", creditLimitTextField.textProperty())
                .withMethod(c -> {
                    String creditLimit = c.get("creditLimit");

                    if ((creditLimit != null) && !(creditLimit.trim().equals(""))) {

                        // else
                        //     c.error("Please use only number.");
                        try {
                            BigDecimal creditLimitBigDecimalValue = new BigDecimal(creditLimit.trim());
                            if (customersDTO != null) {
                                customersDTO.setCreditLimit(new BigDecimal(creditLimit.trim()));
                            }
                        } catch (NumberFormatException ex) {
                            ex.printStackTrace();
                            c.error("Please use only big decimal.");
                        }
                    }

                    if ((customersDTO != null)) {
                        if ((creditLimit.trim().equals(""))) {
                            c.error("Customer Number can't be empty");
                        }
                    }

                })
                .decorates(creditLimitTextField)
                .immediate();

        //Setting the title
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Setting the content of the dialog

        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.getDialogPane().getChildren().addAll();

    }

    @FXML
    private void handleButtonClicks(ActionEvent event) {

        /*    try {
            App.setRoot("CustomersFXML");
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
         */
    }

    @FXML
    public void findCustomers() {

        // TODO
        logger.info("Inside findCustomers()");

        //customersDTO = null;
        String id = customerNumberTextField.getText();
        logger.info("fasfasfs --> " + customerNumberTextField.getText());

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL + "/single");

        // String findCustomersPath = FULL_PATH ;
        //  ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
        //    ResteasyWebTarget target = client.target(BASE_URL + "/single");
        Invocation.Builder request = (Invocation.Builder) target.queryParam("id", id).request();
        Response response = null;

        statusInfo = null;

        try {
            //     response = request.get();
            response = request.get();
            statusInfo = response.getStatusInfo().toString().trim();
            logger.info("Inside findCustomers()" + response);
            logger.info("statusInfo --> " + statusInfo);
            if (statusInfo.equals("OK")) {
                customersDTO = response.readEntity(CustomersDTO.class);
                logger.info(customersDTO.toString());
                logger.info(customersDTO.getCustomerName());

                logger.info("statusInfo --> " + statusInfo);
                dialog.setContentText("Customers row found successfully");
                //  dialog.showAndWait();
            } else {
                customersDTO = null;
                dialog.setContentText("Customers row not found");

            }
            //    customersDTO = target.queryParam("id", id).request().get(CustomersDTO.class);

        } finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }

        if ((customerNumberTextField.getText() != null) && !(customerNumberTextField.getText().equals("")) && !(statusInfo.equals("OK"))) {
            if ((validator != null) && (customerNumberCheck != null)) {
                customerNumberCheck.recheck();
            }
        }

        logger.info("fasfasfs --> " + customerNumberTextField.getText());

        if ((customersDTO != null) && (customersDTO.getAddressLine1() != null)) {
            addressLine1TextField.setText(customersDTO.getAddressLine1());
        }

        if ((customersDTO != null) && (customersDTO.getAddressLine2() != null)) {
            addressLine2TextField.setText(customersDTO.getAddressLine2());
        }

        if ((customersDTO != null) && (customersDTO.getCustomerNumber() != null)) {
            customerNumberTextField.setText(customersDTO.getCustomerNumber().toString());
        }

        if ((customersDTO != null) && (customersDTO.getCustomerName() != null)) {
            customerNameTextField.setText(customersDTO.getCustomerName());
        }

        if ((customersDTO != null) && (customersDTO.getContactLastName() != null)) {
            contactLastNameTextField.setText(customersDTO.getContactLastName());
        }

        if ((customersDTO != null) && (customersDTO.getContactFirstName() != null)) {
            contactFirstNameTextField.setText(customersDTO.getContactFirstName());
        }

        if ((customersDTO != null) && (customersDTO.getPhone() != null)) {
            phoneTextField.setText(customersDTO.getPhone());
        }

        if ((customersDTO != null) && (customersDTO.getCity() != null)) {
            cityTextField.setText(customersDTO.getCity());
        }

        if ((customersDTO != null) && (customersDTO.getPostalCode() != null)) {
            postalCodeTextField.setText(customersDTO.getPostalCode());
        }

        if ((customersDTO != null) && (customersDTO.getCountry() != null)) {
            countryTextField.setText(customersDTO.getCountry());
        }

        if ((customersDTO != null) && (customersDTO.getState() != null)) {
            stateTextField.setText(customersDTO.getState());
        }

        if ((customersDTO != null) && (customersDTO.getCreditLimit() != null)) {
            creditLimitTextField.setText(customersDTO.getCreditLimit().toString());
        }

        dialog.showAndWait();

        if (customersDTO != null) {
            validatorRechecks();
            //   return;
        }
        //  customersDTO = null;
    }

    private void validatorRechecks() {

        // customersDTO.setCustomerNumber(Integer.MIN_VALUE);
        if ((addressLine2TextField.getText() != null) && (addressLine2TextField.getText().trim().equals(""))) {

            if ((validator != null) && (addressLine2Check != null)) {
                addressLine2Check.recheck();
            }

        }

        if ((addressLine1TextField.getText() != null) && (addressLine1TextField.getText().trim().equals(""))) {

            if ((validator != null) && (addressLine1Check != null)) {
                addressLine1Check.recheck();
            }

        }
        if ((stateTextField.getText() != null) && (stateTextField.getText().trim().equals(""))) {

            if ((validator != null) && (stateCheck != null)) {
                stateCheck.recheck();
            }

        }

        if ((postalCodeTextField.getText() != null) && (postalCodeTextField.getText().trim().equals(""))) {

            if ((validator != null) && (postalCodeCheck != null)) {
                postalCodeCheck.recheck();
            }

        }

        if ((creditLimitTextField.getText() != null) && (creditLimitTextField.getText().trim().equals(""))) {

            if ((validator != null) && (creditLimitCheck != null)) {
                creditLimitCheck.recheck();
            }

        }

        if ((customerNameTextField.getText() != null) && (customerNameTextField.getText().trim().equals(""))) {

            if ((validator != null) && (customerNameCheck != null)) {
                customerNameCheck.recheck();
            }

        }

        if ((contactFirstNameTextField.getText() != null) && (contactFirstNameTextField.getText().trim().equals(""))) {

            if ((validator != null) && (contactFirstNameCheck != null)) {
                contactFirstNameCheck.recheck();
            }

        }

        if ((contactLastNameTextField.getText() != null) && (contactLastNameTextField.getText().trim().equals(""))) {

            if ((validator != null) && (contactLastNameCheck != null)) {
                contactLastNameCheck.recheck();
            }

        }

        if ((phoneTextField.getText() != null) && (phoneTextField.getText().trim().equals(""))) {

            if ((validator != null) && (phoneCheck != null)) {
                phoneCheck.recheck();
            }

        }

        if ((cityTextField.getText() != null) && (cityTextField.getText().trim().equals(""))) {

            if ((validator != null) && (cityCheck != null)) {
                cityCheck.recheck();
            }

        }

        if ((countryTextField.getText() != null) && (countryTextField.getText().trim().equals(""))) {

            if ((validator != null) && (countryCheck != null)) {
                countryCheck.recheck();
            }

        }

        if ((customerNumberTextField.getText() != null) && (customerNumberTextField.getText().trim().equals(""))) {

            if ((validator != null) && (customerNumberCheck != null)) {
                customerNumberCheck.recheck();
            }

        }

    }

    @FXML
    public void addCustomers() {

        //    validator = new Validator();
        // TODO
        logger.info("Inside addCustomer()");

        if (customersDTO != null) {
            validatorRechecks();
            //  return;
        }

        logger.info("Inside addCustomer()+ if (customersDTO == null) ");

        customersDTO = new CustomersDTO();

        logger.info("fasfasfs --> " + customerNumberTextField.getText());

        // customersDTO.setCustomerNumber(Integer.MIN_VALUE);
        customersDTO.setAddressLine2(addressLine2TextField.getText());

        customersDTO.setState(stateTextField.getText());
        customersDTO.setPostalCode(postalCodeTextField.getText());

        if ((creditLimitTextField.getText() != null) && !(creditLimitTextField.getText().trim().equals(""))) {
            customersDTO.setCreditLimit(new BigDecimal(creditLimitTextField.getText()));
        }

        customersDTO.setContactLastName(contactLastNameTextField.getText());

        customersDTO.setContactFirstName(contactFirstNameTextField.getText());

        customersDTO.setPhone(phoneTextField.getText());

        customersDTO.setAddressLine1(addressLine1TextField.getText());

        customersDTO.setCity(cityTextField.getText());

        customersDTO.setCountry(countryTextField.getText());

        if ((customerNumberTextField.getText() != null) && !(customerNumberTextField.getText().trim().equals(""))) {
            customersDTO.setCustomerNumber(new Integer(customerNumberTextField.getText()));
        }

        customersDTO.setCustomerName(customerNameTextField.getText());

        //      customersService.setCustomersDTO(customersDTO);
        // String findCustomersPath = FULL_PATH ;
        String id = customerNumberTextField.getText();

        // ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
        // ResteasyWebTarget target = client.target(BASE_URL);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL);

        Invocation.Builder request = target.request();
        Response response = null;

        statusInfo = null;

        try {
            //     response = request.get();
            response = target.request().post(Entity.xml(customersDTO));
            String message = response.readEntity(String.class).toString().trim();
            logger.info("Inside addCustomers()");

            statusInfo = response.getStatusInfo().toString().trim();
            logger.info("message --> " + message);
            if ((statusInfo != null) && (statusInfo.equals("OK"))) {
                dialog.setContentText(message);
            } else {
                dialog.setContentText("Customers row not added successfully");
            }
            dialog.showAndWait();
            /**
             * btnAddCustomers.setOnAction(e -> {
             * dialog.setContentText(statusInfo); dialog.showAndWait(); });
             */
            //Creating a dialog

            //    customersDTO = target.queryParam("id", id).request().get(CustomersDTO.class);
        } finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }
        // customersDTO = null;
    }

}
