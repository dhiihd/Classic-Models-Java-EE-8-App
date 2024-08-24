/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.classicmodels.javafx.controller;

import com.classicmodels.dto.CustomersDTO;
import com.classicmodels.dto.CustomersListDTO;
import io.github.palexdev.materialfx.controls.MFXPaginatedTableView;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.BigDecimalFilter;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import org.slf4j.LoggerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;

/**
 * FXML Controller class
 *
 * @author dhiihd
 */
public class CustomersPaginationFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static final Logger logger
            = LoggerFactory.getLogger(CustomersPaginationFXMLController.class);

    @FXML
    private MFXPaginatedTableView customersTableView;

    @FXML
    MFXTableColumn customerNumberColumn;

    @FXML
    MFXTableColumn customerNameColumn;

    @FXML
    MFXTableColumn phoneColumn;

    @FXML
    MFXTableColumn contactLastNameColumn;

    @FXML
    MFXTableColumn contactFirstNameColumn;

    @FXML
    MFXTableColumn addressLine1Column;
    @FXML
    MFXTableColumn addressLine2Column;

    @FXML
    MFXTableColumn cityColumn;

    @FXML
    MFXTableColumn stateColumn;

    @FXML
    MFXTableColumn postalCodeColumn;

    @FXML
    MFXTableColumn countryColumn;

    @FXML
    MFXTableColumn creditLimitColumn;

    private String statusInfo = null;

    // private Dialog<String> dialog = new Dialog<String>();
    private static final String BASE_URL = "https://127.0.0.1:8443/classic-models-maven-enterprise-webapp/webresources/com.classicmodels.customers";

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  customersService = new CustomersService();
        // customersService.startTheService();

    }

    @FXML
    public void findCustomersList() {

        // TODO
        logger.info("Inside findCustomersList()");

        //customersDTO = null;
        // customersPages.getCurrentPage()..addAll(customerNumber, customerName, phone);
        //customerNumberColumn = new MFXTableColumn<>("Customer Number", Comparator.comparing(CustomersDTO::getCustomerNumber));
        //customerNumberColumn1.setCellValueFactory(new PropertyValueFactory<>("Customer Number"));
        //  customerNumberColumn.setRowCellFactory(customerNumber -> new MFXTableRowCell<>(CustomersDTO::getCustomerNumber));
        //  customerNumberColumn1.setRowCellFactory(rowCellFactory);CellValueFactory(new PropertyValueFactory<>("customerNumber"));
        customerNumberColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getCustomerNumber));
        customerNameColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getCustomerName));
        contactLastNameColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getContactLastName));
        contactFirstNameColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getContactFirstName));
        phoneColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getPhone));
        addressLine1Column.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getAddressLine1));
        addressLine2Column.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getAddressLine2));
        cityColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getCity));
        stateColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getState));
        postalCodeColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getPostalCode));
        countryColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getCountry));
        creditLimitColumn.setRowCellFactory(transaction -> new MFXTableRowCell<>(CustomersDTO::getCreditLimit));
  //      customersTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        customersTableView.getFilters().addAll(
                new IntegerFilter<>("Customer Number", CustomersDTO::getCustomerNumber),
                new StringFilter<>("Customer Name", CustomersDTO::getCustomerName),
                new StringFilter<>("Phone", CustomersDTO::getPhone),
                new StringFilter<>("Contact FirstName", CustomersDTO::getContactFirstName),
                new StringFilter<>("Contact LastName", CustomersDTO::getContactLastName),
                new StringFilter<>("City", CustomersDTO::getCity),
                new StringFilter<>("Contact AddressLine1", CustomersDTO::getAddressLine1),
                new StringFilter<>("Contact AddressLine2", CustomersDTO::getAddressLine2),
                new StringFilter<>("State", CustomersDTO::getState),
                new StringFilter<>("PostalCode", CustomersDTO::getPostalCode),
                new StringFilter<>("Country", CustomersDTO::getCountry),
                new BigDecimalFilter<>("CreditLimit", CustomersDTO::getCreditLimit)
        );
        
        customersTableView.
            setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");
        

        //customersTableView.getItems().setAll(customerDTOList);
        //customersTableView.setItems(customerDTOList);
        Response response = null;
        Client client = null;

        try {

            ClientBuilder clientBuilder = ClientBuilder.newBuilder();
            client = clientBuilder.sslContext(ClassicModelsSSL.getInstance().getSSLContext()).build();

            WebTarget target = client.target(BASE_URL + "/findCustomersList");

            // String findCustomersPath = FULL_PATH ;
            // ResteasyClient client = (ResteasyClient) ClientBuilder.newClient();
            //    ResteasyWebTarget target = client.target(BASE_URL + "/single");
            Invocation.Builder request = (Invocation.Builder) target.request(MediaType.APPLICATION_XML);

            statusInfo = null;

            //     response = request.get();
            response = request.get();
            statusInfo = response.getStatusInfo().toString().trim();
            logger.info("Inside findCustomersList()" + response);
            logger.info("statusInfo --> " + statusInfo);
            if (statusInfo.equals("OK")) {
                CustomersListDTO message = response.readEntity(CustomersListDTO.class);
                logger.info("Inside getCustomersList()");
                ObservableList<CustomersDTO> observableArrayList
                        = (ObservableList<CustomersDTO>) FXCollections.observableArrayList(message.getCustomersList());
                customersTableView.setItems(observableArrayList);
                statusInfo = response.getStatusInfo().toString().trim();
                logger.info("message --> " + message.getCustomersList());
                // dialog.setContentText("Customers row found successfully");

            }

            //    dialog.showAndWait();
            //    customersDTO = target.queryParam("id", id).request().get(CustomersTableDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }

        //  customersDTO = null;
    }

}
