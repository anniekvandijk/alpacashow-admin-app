package nl.animundo.apps.alpacashowadmin.backend.domain;


import nl.animundo.apps.alpacashowadmin.backend.services.InputValidationService;

import java.time.*;

/**
 * Created by Anniek van Dijk on 29-5-2016.
 */
public class ShowEvent {

    // TODO check input

    private String name;
    private LocalDate date;
    private LocalDate closeDate;
    private String location;
    private String judge;

    public ShowEvent(String name, LocalDate date, LocalDate closeDate, String location, String judge) {

        // TODO Null and fix trim ()

        this.name = name.trim();
        this.date = date;
        this.closeDate = closeDate;
        this.location = location.trim();
        this.judge = judge.trim();

        InputValidationService.requiredFields(this.name, "naam");
        InputValidationService.requiredFields(this.location, "locatie");
    }

    // TODO: vraag: zijn de setters nodig?

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        InputValidationService.requiredFields(this.name, "naam");
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location.trim();
        InputValidationService.requiredFields(this.location, "locatie");
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge.trim();
    }
}
