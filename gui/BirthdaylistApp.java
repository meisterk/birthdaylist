package gui;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BirthdaylistApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // FXML
        URL url = getClass().getResource("birthdaylist.fxml");
        System.out.println(url.toString());
        FXMLLoader loader = new FXMLLoader(url);
        
        // Controller
        loader.setController(new BirthdaylistController());
        
        // Load FXML
        Parent parent = loader.load();        
        stage.setScene(new Scene(parent));
        
        // Window-properties
        stage.setTitle("Geburtstagsliste");
        stage.setWidth(500.0);
        stage.setHeight(300.0);
        stage.setResizable(false);
        stage.show();
    }

    
}
