package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ShowEventAnimalDetailTest {

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newShowEventRegistration() {

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
               sheerDate, beforeSheerDate);

        assertEquals(showEventKey, showEventAnimalDetail.getShowEventKey());
        assertEquals(participantKey, showEventAnimalDetail.getParticipantKey());
        assertEquals(animalKey, showEventAnimalDetail.getAnimalKey());
        assertEquals(sheerDate, showEventAnimalDetail.getSheerDate());
        assertEquals(beforeSheerDate, showEventAnimalDetail.getBeforeSheerDate());
    }

    @Test
    public void showEventKeyNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventKey can not be empty");

        showEventKey = null;
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

    }

    @Test
    public void showEventKeyNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEventKey can not be empty");

        showEventKey = "";
        participantKey = "Deelnemer 1";
        animalKey = "12345";
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);
    }

    @Test
    public void participantKeyNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = null;
        animalKey = "12345";
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

    }

    @Test
    public void participantKeyNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ParticipantKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "";
        animalKey = "12345";
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);
    }

    @Test
    public void animalNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("AnimalKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = null;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

    }

    @Test
    public void animalNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("AnimalKey can not be empty");

        showEventKey = "2017-05-01_HALTERSHOW";
        participantKey = "Deelnemer 1";
        animalKey = "";
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 29);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

    }

 }
