package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //scene builder attributes
    @FXML private RadioButton airlineRadioBtn;
    @FXML private RadioButton airlineNumRadioBtn;
    @FXML private RadioButton departureRadioBtn;
    @FXML private RadioButton arrivalRadioBtn;
    @FXML private ChoiceBox airlineChoiceBox;
    @FXML private ChoiceBox airlineNumChoiceBox;
    @FXML private ChoiceBox departureChoiceBox;
    @FXML private ChoiceBox arrivalChoiceBox;
    @FXML private Button searchBtn;
    @FXML private Button closeBtn;
    @FXML private ListView listView;

    //auxiliary variables
    private ObservableList<String> airline = FXCollections.observableArrayList("Air Canada","Air India");

    public void HandleAirlineRadioBtn(){
        System.out.println("Airline Radio Button");
    }

    public void HandleAirlineNumRadioBtn(){
        System.out.println("Airline Number Radio Button");
    }

    public void HandleDepartureRadioBtn(){
        System.out.println("Departure Radio Button");
    }

    public void HandleArrivalRadioBtn(){
        System.out.println("Arrival Radio Button");
    }

    public void HandleAirlineChoiceBox(){
        System.out.println("Airline Choice Box");
    }

    public void HandleAirlineNumChoiceBox(){
        System.out.println("Airline Number Choice Box");
    }

    public void HandleDepartureChoiceBox(){
        System.out.println("Departure Choice Box");
    }

    public void HandleArrivalChoiceBox(){
        System.out.println("Arrival Choice Box");
    }

    public void HandleSearchBtn(){
        System.out.println("Search Button");
    }

    public void HandleCloseBtn(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    public void HandleListView(){
        System.out.println("List View");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        airlineChoiceBox.getItems().addAll(airline);
        airlineChoiceBox.setValue("Select Airline");

    }
}
