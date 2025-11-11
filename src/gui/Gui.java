package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Forestilling;
import model.Kunde;
import storage.Storage;

import java.time.LocalDate;

public class Gui extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Car");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private Controller controller = new Controller();
    private ListView<Forestilling> forestillingView = new ListView<>(Storage.getForestillinger());
    private ListView<Kunde> kundeListView = new ListView<>(Storage.getKunder());
    private TextField textFieldForestillingsNavn = new TextField();
    private TextField textFieldKundeNavn = new TextField();
    private TextField textFieldKundeMobil = new TextField();
    private DatePicker datePickerStartDato = new DatePicker();
    private DatePicker datePickerSlutDato = new DatePicker();
    private Button buttonAddKunde = new Button("Opret kunde");
    private Button buttonAddForestilling = new Button("Opret forestilling");

    private void initContent(GridPane pane) {
        pane.setVgap(10);
        pane.setHgap(20);
        pane.setPadding(new Insets(20));
        //pane.setGridLinesVisible(false);

        Label labelForestillinger = new Label("Forestillinger");
        Label labelKunder = new Label("Kunder");
        Label labelForestillingNavn = new Label("Forestillingens Navn");
        Label labelStartDato = new Label("Start dato");
        Label labelSlutDato = new Label("Slut dato");
        Label labelKundeNavn = new Label("Kunde navn");
        Label labelKundeMobil = new Label("Kunde mobil");
        pane.add(labelForestillinger,0,0,2,1);
        pane.add(labelKunder,2,0,2,1);
        pane.add(forestillingView, 0, 1,2,1);
        pane.add(kundeListView, 2, 1,2,1);
        pane.add(labelForestillingNavn,0,3);
        pane.add(textFieldForestillingsNavn,1,3);
        pane.add(labelKundeNavn,2,3);
        pane.add(textFieldKundeNavn,3,3);
        pane.add(labelStartDato,0,4);
        pane.add(datePickerStartDato,1,4);
        pane.add(labelKundeMobil,2,4);
        pane.add(textFieldKundeMobil,3,4);
        pane.add(labelSlutDato,0,5);
        pane.add(datePickerSlutDato,1,5);
        pane.add(buttonAddForestilling,1,6);
        pane.add(buttonAddKunde,3,6);

        buttonAddForestilling.setOnAction(event -> addForestilling());
        buttonAddKunde.setOnAction(event -> addKunde());
    }

    private void addForestilling() {
        if (textFieldForestillingsNavn.getText().isEmpty() || datePickerStartDato.getValue()==null || datePickerSlutDato.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Missing name or date input for forestilling. Fill the fields and try again");
            alert.showAndWait();
        }
        else {
            String navn = textFieldForestillingsNavn.getText();
            LocalDate startDato = datePickerStartDato.getValue();
            LocalDate slutDato = datePickerSlutDato.getValue();
            controller.createForestilling(navn, startDato, slutDato);
            textFieldForestillingsNavn.clear();
            datePickerStartDato.setValue(null);
            datePickerSlutDato.setValue(null);
        }
    }
    private void addKunde(){
        if (textFieldKundeNavn.getText().isEmpty() || textFieldKundeMobil.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Missing name or mobil input for kunde. Fill the fields and try again");
            alert.showAndWait();
        }
        else {
            String navn = textFieldKundeNavn.getText();
            String mobil = textFieldKundeMobil.getText();
            controller.createKunde(navn, mobil);
            textFieldKundeNavn.clear();
            textFieldKundeMobil.clear();
        }
    }
}
