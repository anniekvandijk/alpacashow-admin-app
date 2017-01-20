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

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);

        ShowEventRepository showEventRepository = new ShowEventRepository();

        assertEquals(0, showEventRepository.getAllShowEvents().size());

        showEventRepository.add(showEvent);

        String key = "2030-06-15_FLEECESHOW";

        assertEquals(1, showEventRepository.getAllShowEvents().size());
        assertEquals("Test showEvent", showEventRepository.getShowEventByKeySet(key).getName());
    }

    @Test
    public void AddShowEventWithSameKey() throws IOException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Showevent with same date and showtype already exists");

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent1 = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEvent showEvent2 = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent1);
        showEventRepository.add(showEvent2);
    }

    @Test
    public void deleteShowEvent() throws IOException {

        String name = "Test showEvent to delete";
        LocalDate date = LocalDate.of(2030, 6, 12);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.MALE_PROGENY_SHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();
        showEventRepository.add(showEvent);

        assertEquals(1, showEventRepository.getAllShowEvents().size());
        String key = "2030-06-12_MALE_PROGENY_SHOW";
        assertEquals("Test showEvent to delete", showEventRepository.getShowEventByKeySet(key).getName());

        showEventRepository.delete(key);

        assertEquals(0, showEventRepository.getAllShowEvents().size());
    }

    @Test
    public void deleteShowEventWithNotKnownKey() throws IOException {

        exception.expect(NullPointerException.class);

        String name = "Test showEvent to delete";
        LocalDate date = LocalDate.of(2030, 6, 12);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.MALE_PROGENY_SHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();
        showEventRepository.add(showEvent);

        assertEquals(1, showEventRepository.getAllShowEvents().size());

        String key = "2030-06-15_MALE_PROGENY_SHOW";
        showEventRepository.delete(key);

        assertEquals(1, showEventRepository.getAllShowEvents().size());
        assertEquals(null, showEventRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownShowEvent() throws IOException {

        exception.expect(NullPointerException.class);

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        String key = "2030-06-14_FLEECESHOW";
        showEventRepository.getShowEventByKeySet(key).getName();

    }

    @Test
    public void getAllShowEventsByKeySet() throws IOException {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String name1 = "Test showEvent 1";
        String name2 = "Test showEvent 2";
        LocalDate date = LocalDate.of(2030, 6, 15);
        LocalDate closeDate = LocalDate.of(2030, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType1 = ShowType.FLEECESHOW;
        ShowType showType2 = ShowType.HALTERSHOW;

        ShowEvent showEvent1 = new ShowEvent(name1, date, closeDate, location, judge, showType1);
        ShowEvent showEvent2 = new ShowEvent(name2, date, closeDate, location, judge, showType2);

        showEventRepository.add(showEvent1);
        showEventRepository.add(showEvent2);

        assertEquals(2, showEventRepository.getAllShowEventsByKeySet().size());
        assertTrue(showEventRepository.getAllShowEventsByKeySet().contains("2030-06-15_HALTERSHOW"));
        assertTrue(showEventRepository.getAllShowEventsByKeySet().contains("2030-06-15_FLEECESHOW"));

    }
}


