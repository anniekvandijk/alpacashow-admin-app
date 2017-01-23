package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

public class ShowEventAnimalDetail {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalDetail.class);

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;
    private AgeClass ageClass;
    private int showClass;

    public ShowEventAnimalDetail(final String showEventKey, final String participantKey, final String animalKey, final LocalDate sheerDate,
                                 final LocalDate beforeSheerDate)
    {

        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
        this.animalKey = animalKey;
        this.sheerDate = sheerDate;
        this.beforeSheerDate = beforeSheerDate;
        this.ageClass = null;
        this.showClass = 0;
    }

    public ShowEventAnimalDetail(final String showEventKey, final String participantKey, final String animalKey, final LocalDate sheerDate,
                                 final LocalDate beforeSheerDate, final AgeClass ageClass, final int showClass)
    {

        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
        this.animalKey = animalKey;
        this.sheerDate = sheerDate;
        this.beforeSheerDate = beforeSheerDate;
        this.ageClass = ageClass;
        this.showClass = showClass;
    }

    public String getShowEventKey() {
        return showEventKey;
    }

    public String getParticipantKey() {
        return participantKey;
    }

    public String getAnimalKey() {
        return animalKey;
    }

    public LocalDate getSheerDate() {
        return sheerDate;
    }

    public LocalDate getBeforeSheerDate() {
        return beforeSheerDate;
    }

    public AgeClass getAgeClass() {
        return ageClass;
    }

    public int getShowClass() {
        return showClass;
    }
}
