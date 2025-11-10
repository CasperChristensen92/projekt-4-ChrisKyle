package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate date;
    private Kunde kunde;
    private ArrayList<Plads> pladser = new ArrayList<>();
    private Forestilling forestilling;

    public Bestilling(LocalDate date, Kunde kunde, ArrayList<Plads> pladser) {
        this.date = date;
        this.kunde = kunde;
        this.pladser = pladser;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setForestilling(Forestilling forestilling) {
        this.forestilling = forestilling;
    }

    protected void setKunde(Kunde kunde) {
        this.kunde = kunde;
        kunde.addBestilling(this);
    }

    protected void setPladser(ArrayList<Plads> pladser) {
        this.pladser = pladser;
    }

    public Kunde getKunde() {
        return kunde;
    }
}
