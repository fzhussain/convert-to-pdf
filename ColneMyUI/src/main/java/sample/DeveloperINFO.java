package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;


public class DeveloperINFO implements Initializable{

    @FXML
    BorderPane devPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void gotoFuncPage()throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/functionPage.fxml"));
        devPane.getChildren().setAll(pane);

    }
    public void gotoHomePage()throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        devPane.getChildren().setAll(pane);

    }
}
