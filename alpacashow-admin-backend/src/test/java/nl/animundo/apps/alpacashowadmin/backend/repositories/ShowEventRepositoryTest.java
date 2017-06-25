package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEvent() throws IOException {

        String id = "dceef758-011f-421b-8933-73cec9beca7a";
        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);

        ShowEventRepository showEventRepository = new ShowEventRepository();

        assertEquals(0, showEventRepository.getAllShowEvents().size());

        showEventRepository.add(id, showEvent);
        assertEquals(1, showEventRepository.getAllShowEvents().size());
        assertEquals(name, showEventRepository.getShowEventById(id).getName());
    }

    @Test
    public void deleteShowEvent() throws IOException {

        String id = "dceef758-011f-421b-8933-73cec9beca72";
        String name = "Test showEvent to delete";
        LocalDate date = LocalDate.of(2030, 6, 12);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.MALE_PROGENY_SHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();
        showEventRepository.add(id, showEvent);

        assertEquals(1, showEventRepository.getAllShowEvents().size());
        assertEquals("Test showEvent to delete", showEventRepository.getShowEventById(id).getName());

        showEventRepository.delete(id);

        assertEquals(0, showEventRepository.getAllShowEvents().size());
    }

    @Test
    public void deleteShowEventWithNotKnownId() throws IOException {

        exception.expect(NullPointerException.class);

        String id = "dceef758-011f-421b-8933-73cec9beca73";
        String name = "Test showEvent to delete";
        LocalDate date = LocalDate.of(2030, 6, 12);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.MALE_PROGENY_SHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();
        showEventRepository.add(id, showEvent);

        assertEquals(1, showEventRepository.getAllShowEvents().size());

        String key = "12345";
        showEventRepository.delete(key);

        assertEquals(1, showEventRepository.getAllShowEvents().size());
        assertEquals(null, showEventRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownShowEvent() throws IOException {

        exception.expect(NullPointerException.class);

        String id = "dceef758-011f-421b-8933-73cec9beca74";
        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(id, showEvent);

        String id2 = "12345";
        showEventRepository.getShowEventById(id2).getName();

    }

    @Test
    public void getAllShowEventsByKeySet() throws IOException {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String id1 = "dceef758-011f-421b-8933-73cec9beca75";
        String id2 = "dceef758-011f-421b-8933-73cec9beca76";
        String name = "Test showEvent 1";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType1 = ShowType.FLEECESHOW;
        ShowType showType2 = ShowType.HALTERSHOW;

        ShowEvent showEvent1 = new ShowEvent(id1, name, date, closeDate, location, judge, showType1);
        ShowEvent showEvent2 = new ShowEvent(id2, name, date, closeDate, location, judge, showType2);

        showEventRepository.add(id1, showEvent1);
        showEventRepository.add(id2, showEvent2);

        assertEquals(2, showEventRepository.getAllShowEventsById().size());
        assertTrue(showEventRepository.getAllShowEventsById().contains("dceef758-011f-421b-8933-73cec9beca75"));
        assertTrue(showEventRepository.getAllShowEventsById().contains("dceef758-011f-421b-8933-73cec9beca76"));

    }
}


