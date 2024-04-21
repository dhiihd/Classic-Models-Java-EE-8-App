package com.classicmodels.javafx.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import com.classicmodels.dto.CountriesDTO;
import com.classicmodels.dto.CreditLimitsDTO;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import org.slf4j.LoggerFactory;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.Integer;
import java.math.BigDecimal;
import java.util.Collections;

/**
 * FXML Controller class
 *
 * @author dhiihd
 */
public class CustomersCreditLimitsChartsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static final org.slf4j.Logger logger
            = LoggerFactory.getLogger(CustomersCreditLimitsChartsFXMLController.class);

    private ObservableList<DataItem> items;
    
    
    @FXML
    private VBox root = new VBox();
    @FXML
    private Button btnInitUI;
    private static  int SIZE = 10;
    
    @FXML
    private GridPane gridPane = new GridPane();
    @FXML
    private final AnchorPane anchorPane = new AnchorPane();
    
    @FXML
    private ListView countriesListView = new ListView();
    
    private static final String BASE_URL = "http://127.0.0.1:8080/classic-models-maven-enterprise-webapp/webresources/com.classicmodels.customers";
    
   private String statusInfo = null;
   // private Dialog<String> dialog = new Dialog<String>();
    
   // private  Random rnd = new Random();
    
    @FXML
    private final NumberAxis yAxis = new NumberAxis();
    
    @FXML
    private final NumberAxis xAxis = new NumberAxis();
//create bar chart
      
    @FXML
    private LineChart customerCreditLimitsChart =  new LineChart(xAxis, yAxis);


    @FXML
    public void getCountriesList(){
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL+"/countries");
        
        Invocation.Builder request = target.request();
  
        Response response = null;

        statusInfo = null;

        try {
            // request.
            response = request.accept(MediaType.APPLICATION_XML).get();
           //  response.
           //response = target.request().post(Entity.xml(customersDTO));
            CountriesDTO message  =  response.readEntity(CountriesDTO.class);
            logger.info("Inside getCountriesList()");
            ObservableList<String> observableArrayList = 
            (ObservableList<String>) FXCollections.observableArrayList(message.getCountries());
            countriesListView.setItems(observableArrayList);
            statusInfo = response.getStatusInfo().toString().trim();
            logger.info("message --> " + message.getCountries());
           
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
    }
    
     @FXML
    public void generateCreditLimitsChart() {
        
        String country = (String) countriesListView.getSelectionModel().getSelectedItem();
        
        logger.info("country --> "+country );
     //   xAxis.setLabel("Time");
     
     // yAxis.setLabel("Thousand bbl/d");

         /*
        
        AreaChart areaChart = new AreaChart(xAxis, yAxis);
        areaChart.setTitle("Oil consumption");

        XYChart.Series data = new XYChart.Series<String, Number>();

        data.getData().add(new XYChart.Data<>("2004", 82502));
        data.getData().add(new XYChart.Data<>("2005", 84026));
        data.getData().add(new XYChart.Data<>("2006", 85007));
        data.getData().add(new XYChart.Data<>("2007", 86216));
        data.getData().add(new XYChart.Data<>("2008", 85559));
        data.getData().add(new XYChart.Data<>("2009", 84491));
        data.getData().add(new XYChart.Data<>("2010", 87672));
        data.getData().add(new XYChart.Data<>("2011", 88575));
        data.getData().add(new XYChart.Data<>("2012", 89837));
        data.getData().add(new XYChart.Data<>("2013", 90701));

        areaChart.getData().add(data);
        areaChart.setLegendVisible(false);

        root.getChildren().add(areaChart);
*/
//s.setTitle("Bar Chart Sample");
//x and y axis
     //   xAxis.setLabel("Country");
      //  xAxis.setTickLabelRotation(90);
        // xAxis.setLabel("Credit Limits");
        
        
     
        
   //     customerCreditLimitsChart.setTitle("Customer Credit Limits");

        logger.info("fasfasfs fasfasfsa--> " );
//set title for x axis
       
//dataset on 1999
    
        for(Node n:customerCreditLimitsChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: red;");
        }
   //second bar color
       for(Node n:customerCreditLimitsChart.lookupAll(".default-color1.chart-bar")) {
            n.setStyle("-fx-bar-fill: green;");
        }
       
       //third bar color
       for(Node n:customerCreditLimitsChart.lookupAll(".default-color2.chart-bar")) {
            n.setStyle("-fx-bar-fill: blue;");
        }
       
       for(Node n:customerCreditLimitsChart.lookupAll(".default-color3.chart-bar")) {
            n.setStyle("-fx-bar-fill: yellow;");
        }
       
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASE_URL+"/creditlimits");
        
        Invocation.Builder request = (Invocation.Builder) target.queryParam("country", country).request();
  
        Response response = null;

        statusInfo = null;
        
        CreditLimitsDTO message  =  null;
        
        List<BigDecimal> creditLimits = null;
    
        // GenericType<List<Integer>> message1  = null;
        try {
            // request.
            response = request.accept(MediaType.APPLICATION_XML).get();
           //  response.
           //response = target.request().post(Entity.xml(customersDTO));
          //  message  = response.getEntity();
            message  = (CreditLimitsDTO) response.readEntity(CreditLimitsDTO.class);
            creditLimits = message.getCreditLimits();
      //   message1  =  (GenericType<List<Integer>>) response.readEntity(new GenericType<List<Integer>>(){});
            logger.info("message --> " + creditLimits);
            Collections.sort(creditLimits);
            logger.info("message sorted --> " + creditLimits);
        } finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }
           
        //    ObservableList<Integer> observableArrayList = 
          //  (ObservableList<Integer>) FXCollections.observableArrayList(message1);
          //  customerCreditLimitsChart.setData(observableArrayList);
            //message  =  response.readEntity(new GenericType<CreditLimitsDTO>(){});
            logger.info("Inside generateCreditLimitsChart()");
            
            statusInfo = response.getStatusInfo().toString().trim();
           
           
            /**
             * btnAddCustomers.setOnAction(e -> {
             * dialog.setContentText(statusInfo); dialog.showAndWait(); });
             */
            //Creating a dialog

            //    customersDTO = target.queryParam("id", id).request().get(CustomersDTO.class);
       
        
        
        //Configuring data for XY chart 
        XYChart.Series data = new XYChart.Series();
        data.setName(country);
        int j=10;
        for (int i=0;i < creditLimits.size();i++ ) {
            data.getData().add(new XYChart.Data(j,creditLimits.get(i)));
           logger.info("Inside XYChartData "+i+" --> "+creditLimits.get(i));
           j+=10;
        }
     
        
             /*
        data.getData().add(new XYChart.Data(2,142000));
         data.getData().add(new XYChart.Data(3,178000));
        data.getData().add(new XYChart.Data(4,192000));
      
        */
        //Adding data to the barchart
      customerCreditLimitsChart.getData().add(data);
    
  

    }

    public CustomersCreditLimitsChartsFXMLController() {
       FXMLLoader fxml = new FXMLLoader(getClass().getResource("com/classicmodels/javafx/controller/CustomersCreditLimitsChartsFXML.fxml"));
       fxml.setRoot(this);
       fxml.setController(this);
      // getCountriesList();
    //   generateCreditLimitsChart();
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(10);
        xAxis.setUpperBound(100);
        xAxis.setTickUnit(10);
        xAxis.setMinorTickVisible(false);
//set title for y axis
        yAxis.setLabel("Credit Limits");
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(15000);
        yAxis.setUpperBound(150000);
        yAxis.setTickUnit(15000);
        yAxis.setMinorTickVisible(false);
     //  getCountriesList();
      // generateCreditLimitsChart();
        /*     
        
// NumberAxis
        // TODO
        XYChart.Series sr = new XYChart.Series();
       
        sr.getData().add(new XYChart.Data( 1, 567));
sr.getData().add(new XYChart.Data( 2, 557));
sr.getData().add(new XYChart.Data( 3, 547));
        	ObservableList<XYChart.Data<String, Number>> data = ControlDAO.getControlDao().getCountryDao().getAllBarChart();
		XYChart.Series<String, Number> series = new XYChart.Series<>("Countries", data);
		worldPopulationChart.getData().setAll(series);
        		//worldPopulationChart.prefHeightProperty().bind(vbox.heightProperty());
     items = FXCollections.observableArrayList(
                dataItem -> new Observable[] { dataItem.nameProperty(), dataItem.valueProperty()});
        //initialize with random values 
        for (int i = 0; i < SIZE; i++) {
            items.add(new DataItem(String.valueOf(i), rnd.nextInt(100)));
        }
 */    }
    
     //an observable collection of DataItem objects, each representing data of one bar 
   
        
        

}


