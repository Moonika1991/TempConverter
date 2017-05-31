package tempConverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Temperature Converter");
        this.primaryStage.setMinHeight(400);
        this.primaryStage.setMinWidth(400);

        showWindow();
    }

    public void showWindow(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Window.fxml"));
            BorderPane window = (BorderPane) loader.load();

            Scene scene = new Scene(window);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main (String[] args){
        launch(args);
    }
}
