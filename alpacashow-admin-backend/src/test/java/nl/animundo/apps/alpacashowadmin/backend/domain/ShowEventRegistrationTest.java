package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ShowEventRegistrationTest {

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private AgeClass ageClass;
    private int showClassCode;
    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newShowEventRegistration() {

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

        assertEquals(showEventKey, showEventRegistration.getShowEventKey());
        assertEquals(participantKey, showEventRegistration.getParticipantKey());
        assertEquals(animalKey, showEventRegistration.getAnimalKey());
        assertEquals(ageClass, showEventRegistration.getAgeClass());
        assertEquals(showClassCode, showEventRegistration.getShowClassCode());
        assertEquals(sheerDate, showEventRegistration.getSheerDate());
        assertEquals(beforeSheerDate, showEventRegistration.getBeforeSheerDate());
    }

    @Test
    public void showEventKeyNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventKey can not be empty");

        showEventKey = null;
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }

    @Test
    public void showEventKeyNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventKey can not be empty");

        showEventKey = "";
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
    }

    @Test
    public void participantKeyNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = null;
        animalKey = "12345";
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }

    @Test
    public void participantKeyNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "";
        animalKey = "12345";
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }

    @Test
    public void animalNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("AnimalKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = null;
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }

    @Test
    public void animalNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("AnimalKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = "";
        ageClass = AgeClass.ADULT;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }

    @Test
    public void ageClassNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("AgeClass can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        ageClass = null;
        showClassCode = 100;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }

    @Test
    public void showClassCodeNot0() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowClassCode can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        ageClass = AgeClass.ADULT;
        showClassCode = 0;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

    }
}
