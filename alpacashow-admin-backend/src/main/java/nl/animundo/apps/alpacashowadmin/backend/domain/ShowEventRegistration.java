package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ShowEventRegistration {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRegistration.class);

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private AgeClass ageClass;
    private int showClassCode;
    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    public ShowEventRegistration (final String showEventKey, final String participantKey, final String animalKey, final AgeClass ageClass,
                                  final int showClassCode, final LocalDate sheerDate, final LocalDate beforeSheerDate)
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
        if (ageClass == null) {
            throw new IllegalArgumentException("AgeClass can not be empty");
        }
        if (showClassCode == 0) {
            throw new IllegalArgumentException("ShowClassCode can not be empty");
        }

        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
        this.animalKey = animalKey;
        this.ageClass = ageClass;
        this.showClassCode = showClassCode;
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

    public AgeClass getAgeClass() {
        return ageClass;
    }

    public int getShowClassCode() {
        return showClassCode;
    }

    public LocalDate getSheerDate() {
        return sheerDate;
    }

    public LocalDate getBeforeSheerDate() {
        return beforeSheerDate;
    }
}
