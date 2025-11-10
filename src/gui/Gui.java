package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Forestilling;
import model.Kunde;
import storage.Storage;

import java.time.LocalDate;

public class Gui extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("Car");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    private Controller controller = new Controller();
    private final ListView<Forestilling> forestillingView = new ListView<>(FXCollections.observableList(Storage.getForestillinger()));
    private final ListView<Kunde> kundeListView = new ListView<>(FXCollections.observableArrayList(Storage.getKunder()));
    private Button button = new Button("addKunde");
    private void initContent(GridPane pane){

        Storage.addForestilling(new Forestilling("Rikke", LocalDate.of(2000,5,5),LocalDate.of(2001,5,5)));
        Storage.addKunde(new Kunde("Bo","Inge"));
        pane.add(forestillingView,0,1);
        pane.add(kundeListView,0,0);
        DatePicker datePicker = new DatePicker();

        //controller.createKunde("bo","ingo");
//        pane.add(button,1,0);
//        button.setOnAction(event -> {
//            controller.createKunde("bo","Inge");
//        });
    }
}
