package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    //auxiliary variable
    private ObservableList<String> cBItem;

    public void HandleAirlineRadioBtn(){

        //cleaning items before user chooses again
        airlineChoiceBox.getItems().clear();

        //letting only the selected radio button working with the respective choicebox
        airlineNumRadioBtn.setSelected(false);
        departureRadioBtn.setSelected(false);
        arrivalRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(false);
        airlineNumChoiceBox.setDisable(true);
        departureChoiceBox.setDisable(true);
        arrivalChoiceBox.setDisable(true);

        try {
            //reading file
            File myObj = new File("/Users/marianamagalhaes/Desktop/assignment04/src/sample/Flight.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<String> aL = new ArrayList<>();

           //retrieving information from file and splitting in tokens
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] token = data.split(",");
                aL.add(token[0]);
            }

            List<String> aList = aL.stream().distinct().collect(Collectors.toList());
            //adding information in file to observable list
            cBItem = FXCollections.observableArrayList(aList);

            //adding items to choicebox
            airlineChoiceBox.getItems().addAll(cBItem);

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void HandleAirlineNumRadioBtn(){

        airlineNumChoiceBox.getItems().clear();

        airlineRadioBtn.setSelected(false);
        departureRadioBtn.setSelected(false);
        arrivalRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(true);
        airlineNumChoiceBox.setDisable(false);
        departureChoiceBox.setDisable(true);
        arrivalChoiceBox.setDisable(true);

        try {
            File myObj = new File("/Users/marianamagalhaes/Desktop/assignment04/src/sample/Flight.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> aL = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] token = data.split(",");
                aL.add(token[1]);
            }

            List<String> aList = aL.stream().distinct().collect(Collectors.toList());
            cBItem = FXCollections.observableArrayList(aList);

            airlineNumChoiceBox.getItems().addAll(cBItem);

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void HandleDepartureRadioBtn(){

        departureChoiceBox.getItems().clear();

        airlineRadioBtn.setSelected(false);
        airlineNumRadioBtn.setSelected(false);
        arrivalRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(true);
        airlineNumChoiceBox.setDisable(true);
        departureChoiceBox.setDisable(false);
        arrivalChoiceBox.setDisable(true);

        try {
            File myObj = new File("/Users/marianamagalhaes/Desktop/assignment04/src/sample/Flight.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> aL = new ArrayList<>();


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] token = data.split(",");
                aL.add(token[2]);
            }

            List<String> aList = aL.stream().distinct().collect(Collectors.toList());
            cBItem = FXCollections.observableArrayList(aList);

            departureChoiceBox.getItems().addAll(cBItem);

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void HandleArrivalRadioBtn(){

        arrivalChoiceBox.getItems().clear();

        airlineRadioBtn.setSelected(false);
        airlineNumRadioBtn.setSelected(false);
        departureRadioBtn.setSelected(false);

        airlineChoiceBox.setDisable(true);
        airlineNumChoiceBox.setDisable(true);
        departureChoiceBox.setDisable(true);
        arrivalChoiceBox.setDisable(false);

        try {
            File myObj = new File("/Users/marianamagalhaes/Desktop/assignment04/src/sample/Flight.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> aL = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] token = data.split(",");
                aL.add(token[3]);
            }

            List<String> aList = aL.stream().distinct().collect(Collectors.toList());
            cBItem = FXCollections.observableArrayList(aList);

            arrivalChoiceBox.getItems().addAll(cBItem);

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String choice;


    public void HandleSearchBtn(){
        listView.getItems().clear();
        //adding header to listview
        listView.getItems().add("\t Airline \t\t\t\t AirlineNo \t\t\t\t Departure \t\t\t\t Arrival");

        try {
            File myObj = new File("/Users/marianamagalhaes/Desktop/assignment04/src/sample/Flight.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] token = data.split(",");

                //adding tokens in listview according to chosen one
                if (choice.equals(token[0]) || choice.equals(token[1]) || choice.equals(token[2]) || choice.equals(token[3])) {
                        listView.getItems().add("\t" + token[0] + "\t\t\t\t" + token[1] + "\t\t\t\t" + token[2] + "\t\t\t\t\t" + token[3]);
                    }


                }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void HandleCloseBtn(){
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //setting initial values to choicebox
        airlineChoiceBox.setValue("Select Airline");


        airlineNumChoiceBox.setValue("Select Airline Number");


        departureChoiceBox.setValue("Select Departure Airport");


        arrivalChoiceBox.setValue("Select Arrival Airport");

        //header of listview
        listView.getItems().add("\t Airline \t\t\t\t AirlineNo \t\t\t\t Departure \t\t\t\t Arrival");

        //choice as a new string according to value selected in choicebox
        airlineChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, ov, nv) -> choice = new String(nv.toString()));
        airlineNumChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, ov, nv) -> choice = new String(nv.toString()));
        departureChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, ov, nv) -> choice = new String(nv.toString()));
        arrivalChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, ov, nv) -> choice = new String(nv.toString()));

    }
}
