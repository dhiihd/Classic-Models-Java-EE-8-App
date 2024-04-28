package com.classicmodels.javafx.controller;

import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static final Logger logger
            = LoggerFactory.getLogger(App.class);

    @Override
    public void start(Stage stage) throws IOException {

        //  String fxml = "CustomersFXML";
        String fxml = "Home";
        scene = new Scene(loadFXML(fxml), 1440, 900);
        scene.getStylesheets().add("styles/colored-chart.css");
        //    scene = new Scene(loadFXML(fxml), 1280, 800 );
        MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
        logger.info("scene --> " + scene);
        stage.setScene(scene);
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {

        //   MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        //  Parent root = FXMLLoader.load(getClass().getResource("gui/SplashScreen.fxml"));
        logger.info("efasf -> " + fxml + App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setLocation(App.class.getResource(fxml + ".fxml"));
        //  FXMLLoader fxmlLoader = new FXMLLoader();
        //  fxmlLoader.setLocation(getClass().getClassLoader().getResource(getResource(fxml + ".fxml"));

        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
