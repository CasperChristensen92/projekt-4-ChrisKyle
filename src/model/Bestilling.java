package model;

import java.time.LocalDate;

public class Bestilling {
    private LocalDate date;

    public Bestilling(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
