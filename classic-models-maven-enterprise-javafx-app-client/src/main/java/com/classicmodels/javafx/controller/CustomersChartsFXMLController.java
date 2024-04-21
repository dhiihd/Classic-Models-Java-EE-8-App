package com.classicmodels.javafx.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import org.slf4j.LoggerFactory;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author dhiihd
 */
public class CustomersChartsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static final org.slf4j.Logger logger
            = LoggerFactory.getLogger(CustomersChartsFXMLController.class);

    private ObservableList<DataItem> items;
    
    
    @FXML
    private VBox root = new VBox();
    @FXML
    private Button btnInitUI;
    private static  int SIZE = 10;
    
    @FXML
    private GridPane gridPane = new GridPane();
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    
    
    private  Random rnd = new Random();
    private final static String A = "Happy";
    private final static String B = "Sad";
    private final static String C = "Mixed emotions";
    
    @FXML
    private NumberAxis yAxis = new NumberAxis();
    
    @FXML
    private CategoryAxis xAxis = new CategoryAxis();
//create bar chart
      
    @FXML
    private BarChart worldPopulationChart =  new BarChart(xAxis, yAxis);;

    private ObservableList<BarChart.Series<String, Double>> barChartData;

   // @FXML
    public void initUI() {

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
        xAxis.setLabel("Percentage");
        xAxis.setTickLabelRotation(90);
//set title for y axis
        yAxis.setLabel("Emotion");
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(10);
        yAxis.setUpperBound(100);
        yAxis.setTickUnit(10);
        yAxis.setMinorTickVisible(false);
     
        worldPopulationChart.setTitle("Emotions of people");

        logger.info("fasfasfs fasfasfsa--> " );
//set title for x axis
       
//dataset on 1999

  //      barChartData = FXCollections.observableArrayList();
  /*      
        ObservableList<Data<String, Number>> seriesData = new DataConvertor(items).getData();
        BarChart.Series<String, Number> series1 = new BarChart.Series<>();
        series1.setName("1999");
        series1.getData().add(new BarChart.Data(Integer.toString(10), A));
        series1.getData().add(new BarChart.Data(Integer.toString(60), B));
        series1.getData().add(new BarChart.Data(Integer.toString(30), C));
        
        series1.setData(seriesData);
        barChartData.add(series1);
        worldPopulationChart.setData(barChartData);
       // gridPane.reclear();
   //     gridPane.getChildren().add(worldPopulationChart);
   //     anchorPane.getChildren().add(gridPane);
   //     root.getChildren().add(anchorPane);
 */

//dataset on 2009
 //BarChart.Series<String, Number> series1 = new BarChart.Series<>();
              
     /*   Node n = worldPopulationChart.lookup(".s2.chart-bar");
    n.setStyle("-fx-bar-fill: red");
    n = worldPopulationChart.lookup(".S3.chart-bar");
    n.setStyle("-fx-bar-fill: blue");
        */
        
        for(Node n:worldPopulationChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: red;");
        }
   //second bar color
       for(Node n:worldPopulationChart.lookupAll(".default-color1.chart-bar")) {
            n.setStyle("-fx-bar-fill: green;");
        }
       
       //third bar color
       for(Node n:worldPopulationChart.lookupAll(".default-color2.chart-bar")) {
            n.setStyle("-fx-bar-fill: blue;");
        }
       
     
        XYChart.Series s2 = new XYChart.Series();
        String yearName = "2009";
        s2.setName(yearName);
        
        s2.getData().add(new XYChart.Data(A,50));
        s2.getData().add(new XYChart.Data(C,30));
        s2.getData().add(new XYChart.Data(B,20));
        
     //   Node fill = s2.getNode().lookup(".chart-series-bar-fill");; 
     //   fill.setStyle("-fx-bar-fill: red");
//dataset on 2019
        XYChart.Series S3 = new XYChart.Series();
        S3.setName("2019");
        S3.getData().add(new XYChart.Data(A,70));
        S3.getData().add(new XYChart.Data(B,25));
        S3.getData().add(new XYChart.Data(C,5));
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("1999");
        series1.getData().add(new XYChart.Data(A,10));
        series1.getData().add(new XYChart.Data(B,60));
        series1.getData().add(new XYChart.Data(C,30));
        
      
     /* 
        Node n = worldPopulationChart.lookup("default-color0");
    n.setStyle("-fx-bar-fill: red");
    n = worldPopulationChart.lookup("default-color1");
    n.setStyle("-fx-bar-fill: blue");
    */
        worldPopulationChart.getData().addAll( series1,s2, S3);
               
//create scene
//Scene sc  = new Scene(b,700,500);
 //       worldPopulationChart.getData().addAll(s1, s2, S3);
//set scene
//s.setScene(sc);
//display result
//s.show();

    }

    public CustomersChartsFXMLController() {
       FXMLLoader fxml = new FXMLLoader(getClass().getResource("com/classicmodels/javafx/controller/CustomersChartsFXML.fxml"));
       fxml.setRoot(this);
       fxml.setController(this);
       initUI();
        
    }

    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        
       initUI();
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
         */		//worldPopulationChart.prefHeightProperty().bind(vbox.heightProperty());
     items = FXCollections.observableArrayList(
                dataItem -> new Observable[] { dataItem.nameProperty(), dataItem.valueProperty()});
        //initialize with random values 
        for (int i = 0; i < SIZE; i++) {
            items.add(new DataItem(String.valueOf(i), rnd.nextInt(100)));
        }
    }
    
     //an observable collection of DataItem objects, each representing data of one bar 
   
        
        

}


