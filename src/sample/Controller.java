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

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
    private ObservableList<String> airlineNum = FXCollections.observableArrayList("AC102","AC104","AC107","AC113","AI011");
    private ObservableList<String> departureAirport = FXCollections.observableArrayList("YVR","YYZ");
    private ObservableList<String> arrivalAirport = FXCollections.observableArrayList("YYZ", "YVR", "NRT");

    public void HandleAirlineRadioBtn(){

        airlineNumRadioBtn.setSelected(false);
        departureRadioBtn.setSelected(false);
        arrivalRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(false);
        airlineNumChoiceBox.setDisable(true);
        departureChoiceBox.setDisable(true);
        arrivalChoiceBox.setDisable(true);
    }

    public void HandleAirlineNumRadioBtn(){

        airlineRadioBtn.setSelected(false);
        departureRadioBtn.setSelected(false);
        arrivalRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(true);
        airlineNumChoiceBox.setDisable(false);
        departureChoiceBox.setDisable(true);
        arrivalChoiceBox.setDisable(true);
    }

    public void HandleDepartureRadioBtn(){

        airlineRadioBtn.setSelected(false);
        airlineNumRadioBtn.setSelected(false);
        arrivalRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(true);
        airlineNumChoiceBox.setDisable(true);
        departureChoiceBox.setDisable(false);
        arrivalChoiceBox.setDisable(true);
    }

    public void HandleArrivalRadioBtn(){

        airlineRadioBtn.setSelected(false);
        airlineNumRadioBtn.setSelected(false);
        departureRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(true);
        airlineNumChoiceBox.setDisable(true);
        departureChoiceBox.setDisable(true);
        arrivalChoiceBox.setDisable(false);    }

    public void HandleAirlineChoiceBox(){
        System.out.println("Airline Choice Box");
    }

    public void HandleAirlineNumChoiceBox(){
        System.out.println("Airline Number Choice Box");
    }

    public void HandleDepartureChoiceBox(){
        System.out.println("Departure Choice Box");
    }


   //private String aC;

    public void HandleArrivalChoiceBox(){
      //System.out.println(arrivalChoiceBox.getSelectionModel().getSelectedItem());
    }

    public void HandleSearchBtn(){
        listView.getItems().clear();
        listView.getItems().add("\t Airline \t\t\t\t AirlineNo \t\t\t\t Departure \t\t\t\t Arrival");

        try {
            File myObj = new File("/Users/marianamagalhaes/Desktop/assignment04/src/sample/Flight.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] token = data.split(",");
                /*System.out.println(token[0]);
                System.out.println(token[1]);
                System.out.println(token[2]);
                System.out.println(token[3]);
                System.out.println();*/
                listView.getItems().add("\t" + token[0] + "\t\t\t\t" + token[1] + "\t\t\t\t" + token[2] + "\t\t\t\t\t" + token[3]);

            }
            myReader.close();

            System.out.println(airlineChoiceBox.getSelectionModel().getSelectedItem());
            System.out.println(airlineNumChoiceBox.getSelectionModel().getSelectedItem());
            System.out.println(departureChoiceBox.getSelectionModel().getSelectedItem());
            System.out.println(arrivalChoiceBox.getSelectionModel().getSelectedItem());

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void HandleCloseBtn(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    public void HandleListView(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        airlineChoiceBox.getItems().addAll(airline);
        airlineChoiceBox.setValue("Select Airline");

        airlineNumChoiceBox.getItems().addAll(airlineNum);
        airlineNumChoiceBox.setValue("Select Airline Number");

        departureChoiceBox.getItems().addAll(departureAirport);
        departureChoiceBox.setValue("Select Departure Airport");

        arrivalChoiceBox.getItems().addAll(arrivalAirport);
        arrivalChoiceBox.setValue("Select Arrival Airport");

        listView.getItems().add("\t Airline \t\t\t\t AirlineNo \t\t\t\t Departure \t\t\t\t Arrival");

    }
}
