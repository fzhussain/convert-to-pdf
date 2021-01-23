package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;



public class Controller implements Initializable{

    @FXML
    BorderPane rootPane;

    public void gotoFunctionPage() throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/functionPage.fxml"));
        rootPane.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
