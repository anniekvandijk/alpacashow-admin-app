package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

public class ShowEventAnimal {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    public ShowEventAnimal(final String showEventKey, final String participantKey, final String animalKey, final LocalDate sheerDate, final LocalDate beforeSheerDate)
    {
        if (showEventKey == null || showEventKey.isEmpty()) {
            throw new IllegalArgumentException("ShowEventKey can not be empty");
        }
        if (participantKey == null || participantKey.isEmpty()) {
            throw new IllegalArgumentException("ParticipantKey can not be empty");
        }
        if (animalKey == null || animalKey.isEmpty()) {
            throw new IllegalArgumentException("AnimalKey can not be empty");
        }
        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
        this.animalKey = animalKey;
        this.sheerDate = sheerDate;
        this.beforeSheerDate = beforeSheerDate;
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
}
