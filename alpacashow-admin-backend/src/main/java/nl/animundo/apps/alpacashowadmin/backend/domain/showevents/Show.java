package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeSexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Show {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private boolean present;
    private int startNumber;
    private LocalDate dateOfBirth;
    private BreedClass breed;
    private AgeSexClass ageClass;
    private SexClass sex;
    private ColorClass color;
    private int showClass;

    public Show(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                final LocalDate dateOfBirth, final BreedClass breed, final AgeSexClass ageClass, final SexClass sex, final ColorClass color, final int showClass) {
        this.showEventKey = showEventKey;
        this.participantKey = participantKey;
        this.animalKey = animalKey;
        this.present = present;
        this.startNumber = startNumber;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.ageClass = ageClass;
        this.sex = sex;
        this.color = color;
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

    public boolean isPresent() {
        return present;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public BreedClass getBreed() {
        return breed;
    }

    public AgeSexClass getAgeClass() {
        return ageClass;
    }

    public SexClass getSex() {
        return sex;
    }

    public ColorClass getColor() {
        return color;
    }

    public int getShowClass() {
        return showClass;
    }
}


