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
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import org.slf4j.LoggerFactory;
import javafx.collections.ListChangeListener.Change;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        
        worldPopulationChart.setTitle("Emotions of people");

   
        
        logger.info("fasfasfs fasfasfsa--> " );
//set title for x axis
       
//dataset on 1999

        barChartData = FXCollections.observableArrayList();
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
        XYChart.Series s2 = new XYChart.Series();
        s2.setName("2009");
        
     /*   Node n = worldPopulationChart.lookup(".s2.chart-bar");
    n.setStyle("-fx-bar-fill: red");
    n = worldPopulationChart.lookup(".S3.chart-bar");
    n.setStyle("-fx-bar-fill: blue");
        */
     
        s2.getData().add(new XYChart.Data(A,50));
        s2.getData().add(new XYChart.Data(C,30));
        s2.getData().add(new XYChart.Data(B,20));
//dataset on 2019
        XYChart.Series S3 = new XYChart.Series();
        S3.setName("2019");
        S3.getData().add(new XYChart.Data(A,70));
        S3.getData().add(new XYChart.Data(B,25));
        S3.getData().add(new XYChart.Data(C,5));
/*      
        Node n = worldPopulationChart.lookup(".data0.chart-bar");
    n.setStyle("-fx-bar-fill: red");
    n = worldPopulationChart.lookup("S3.chart-bar");
    n.setStyle("-fx-bar-fill: blue");
   */  
        worldPopulationChart.getData().addAll( s2, S3);
               
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


class DataItem {

    private StringProperty name = new SimpleStringProperty(this, "name");
    private IntegerProperty value = new SimpleIntegerProperty(this, "value");

    public DataItem( String name,  int value) {
        setName(name);
        setValue(value);
    }
    public StringProperty nameProperty() {
        return name;
    }
    public String getName() {
        return this.nameProperty().get();
    }
    public void setName( String name) {
        this.nameProperty().set(name);
    }
    public  IntegerProperty valueProperty() {
        return value;
    }
    public int getValue() {
        return this.valueProperty().get();
    }
    public void setValue( int value) {
        this.valueProperty().set(value);
    }
}

//simple coupling between items and graph data 
class DataConvertor{

    ObservableList<DataItem> items;
    ObservableList<Data<String, Number>>data;
     DataConvertor( ObservableList<DataItem> items) {
        super();
        this.items = items;
        data =  FXCollections.observableArrayList();
        items.forEach(item -> data.add(new Data<>(item.getName(), item.getValue())));
        items.addListener( ( Change<? extends DataItem> arg0 ) ->   update());
    }

    void update() {
        for(int i =0; i < data.size(); i++){
             Data<String, Number> d = data.get(i);
            d.setYValue(items.get(i).getValue());
        }
        data.clear();
        items.forEach(item -> data.add(new Data<>(item.getName(), item.getValue())));
    }

    ObservableList<Data<String, Number>>getData(){
        return data;
    }
}