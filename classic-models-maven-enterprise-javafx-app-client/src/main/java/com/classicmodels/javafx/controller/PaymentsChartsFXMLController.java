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
import javafx.scene.chart.LineChart;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;

/**
 * FXML Controller class
 *
 * @author dhiihd
 */
public class PaymentsChartsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static final Logger logger
            = LoggerFactory.getLogger(PaymentsChartsFXMLController.class);

    private ObservableList<DataItem> items;

    @FXML
    private VBox root = new VBox();
    @FXML
    private Button btnInitUI;
    private static int SIZE = 10;

    @FXML
    private GridPane gridPane = new GridPane();
    @FXML
    private AnchorPane anchorPane = new AnchorPane();

    private Random rnd = new Random();

    @FXML
    private NumberAxis yAxis = new NumberAxis();

    @FXML
    private NumberAxis xAxis = new NumberAxis();
//create bar chart

    @FXML
    private LineChart classicModelsPaymentsChart = new LineChart(xAxis, yAxis);

    private ObservableList<LineChart.Series<String, Double>> lineChartData;

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
        //   classicModelsPaymentsChart.setTitle("Emotions of people");
        xAxis.setLabel("Year of Payments");
        //  xAxis.setTickLabelRotation(90);
//set title for y axis
        yAxis.setLabel("Amount");
        /*yAxis.setAutoRanging(false);
        yAxis.setLowerBound(20000);
        yAxis.setUpperBound(200000);
        yAxis.setTickUnit(20000);
        yAxis.setMinorTickVisible(false);
         */
        classicModelsPaymentsChart.setTitle("Classic Models Payments");

        logger.info("fasfasfs fasfasfsa--> ");
//set title for x axis

//dataset on 1999
        for (Node n : classicModelsPaymentsChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: red;");
        }
        //second bar color
        for (Node n : classicModelsPaymentsChart.lookupAll(".default-color1.chart-bar")) {
            n.setStyle("-fx-bar-fill: green;");
        }

        //third bar color
        for (Node n : classicModelsPaymentsChart.lookupAll(".default-color2.chart-bar")) {
            n.setStyle("-fx-bar-fill: blue;");
        }

        for (Node n : classicModelsPaymentsChart.lookupAll(".default-color3.chart-bar")) {
            n.setStyle("-fx-bar-fill: yellow;");
        }

        //Configuring data for XY chart
        XYChart.Series<String, Float> data = new XYChart.Series<>();
        data.getData().add(new XYChart.Data(1, 138000));
        data.getData().add(new XYChart.Data(2, 142000));
        data.getData().add(new XYChart.Data(3, 178000));
        data.getData().add(new XYChart.Data(4, 192000));

        //Adding data to the barchart
        classicModelsPaymentsChart.getData().add(data);

    }

    public PaymentsChartsFXMLController() {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("com/classicmodels/javafx/controller/PaymentsChartsFXML.fxml"));
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
                dataItem -> new Observable[]{dataItem.nameProperty(), dataItem.valueProperty()});
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

    public DataItem(String name, int value) {
        setName(name);
        setValue(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return this.nameProperty().get();
    }

    public void setName(String name) {
        this.nameProperty().set(name);
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public int getValue() {
        return this.valueProperty().get();
    }

    public void setValue(int value) {
        this.valueProperty().set(value);
    }
}

//simple coupling between items and graph data 
class DataConvertor {

    ObservableList<DataItem> items;
    ObservableList<Data<String, Number>> data;

    DataConvertor(ObservableList<DataItem> items) {
        super();
        this.items = items;
        data = FXCollections.observableArrayList();
        items.forEach(item -> data.add(new Data<>(item.getName(), item.getValue())));
        items.addListener((Change<? extends DataItem> arg0) -> update());
    }

    void update() {
        for (int i = 0; i < data.size(); i++) {
            Data<String, Number> d = data.get(i);
            d.setYValue(items.get(i).getValue());
        }
        data.clear();
        items.forEach(item -> data.add(new Data<>(item.getName(), item.getValue())));
    }

    ObservableList<Data<String, Number>> getData() {
        return data;
    }
}
