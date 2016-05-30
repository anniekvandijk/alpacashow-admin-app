package nl.animundo.apps.alpacashowadmin.backend.domain;


import java.time.*;

/**
 * Created by Anniek van Dijk on 29-5-2016.
 */
public class Show {

    private String showName;
    private LocalDate showDate;
    private LocalDate showCloseDate;
    private String showLocation;
    private String showJudge;

    public Show (String showName, LocalDate showDate, LocalDate showCloseDate, String showLocation, String showJudge) {
        this.showName = showName;
        this.showDate = showDate;
        this.showCloseDate = showCloseDate;
        this.showLocation = showLocation;
        this.showJudge = showJudge;

    }

    // TODO: vraag: zijn de setters nodig?

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalDate getShowCloseDate() {
        return showCloseDate;
    }

    public void setShowCloseDate(LocalDate showCloseDate) {
        this.showCloseDate = showCloseDate;
    }

    public String getShowLocation() {
        return showLocation;
    }

    public void setShowLocation(String showLocation) {
        this.showLocation = showLocation;
    }

    public String getShowJudge() {
        return showJudge;
    }

    public void setShowJudge(String showJudge) {
        this.showJudge = showJudge;
    }
}
