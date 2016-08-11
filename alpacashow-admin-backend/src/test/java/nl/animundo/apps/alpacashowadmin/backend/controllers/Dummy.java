package nl.animundo.apps.alpacashowadmin.backend.controllers;

import java.time.LocalDate;

/**
 * Created by Anniek van Dijk on 10-8-2016.
 */
public class Dummy {

    private LocalDate date;

    public Dummy(LocalDate date) {
        this.date = date;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

