package controller;
import model.*;
import storage.Storage;

import java.time.LocalDate;

public class Controller {
    public void createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn, mobil);
        Storage.addKunde(kunde);
    }

    public void createPlads(int række, int nr, int pris, PladsType pladsType){
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads);
    }

    public void createForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(forestilling);
    }
}
