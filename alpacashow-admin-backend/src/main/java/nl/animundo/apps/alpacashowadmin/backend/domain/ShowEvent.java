package nl.animundo.apps.alpacashowadmin.backend.domain;


import nl.animundo.apps.alpacashowadmin.backend.services.InputValidationService;
import java.time.*;

/**
 * Created by Anniek van Dijk on 29-5-2016.
 */
public class ShowEvent {

    private String name;
    private LocalDate date;
    private LocalDate closeDate;
    private String location;
    private String judge;

    public ShowEvent(String name, LocalDate date, LocalDate closeDate, String location, String judge) {

        // TODO replace with other util

        if (null == name) {
            throw new IllegalArgumentException("Field name can not be empty");
        }
        if (null == location) {
            throw new IllegalArgumentException("Field location can not be empty");
        }
        if (null == judge) {
            throw new IllegalArgumentException("Field judge can not be empty");
        }

        name = name.trim();
        location = location.trim();
        judge = judge.trim();

        InputValidationService.requiredFields(name, "name");
        InputValidationService.requiredFields(location, "location");

        this.name = name;
        this.date = date;
        this.closeDate = closeDate;
        this.location = location;
        this.judge = judge;
    }

    // TODO: vraag: zijn de setters nodig?

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (null == name) {
            throw new IllegalArgumentException("Field name can not be empty");
        }

        name = name.trim();

        InputValidationService.requiredFields(this.name, "name");

        this.name = name;
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

        if (null == location) {
            throw new IllegalArgumentException("Field location can not be empty");
        }

        location = location.trim();

        InputValidationService.requiredFields(this.location, "location");

        this.location = location;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {

        if (null == judge) {
            throw new IllegalArgumentException("Field judge can not be empty");
        }
        judge = judge.trim();

        this.judge = judge;
    }
}
