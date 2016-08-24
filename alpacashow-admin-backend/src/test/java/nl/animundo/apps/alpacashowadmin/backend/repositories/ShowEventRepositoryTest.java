package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class ShowEventRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void searchForShow() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        SortedSet<Show> shows = new TreeSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        String searchForName = "Test showEvent";
        assertEquals("Test showEvent", showEventRepository.searchForName(searchForName).getName());

    }

    @Test
    public void searchForNotKnownShow() {

        exception.expect(NullPointerException.class);

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        SortedSet<Show> shows = new TreeSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        String searchForName = "Test showEvent";
        showEventRepository.searchForKey(searchForName).getName();

    }

    @Test
    public void getAllShowEvents() {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String name = "Test showEvent 1";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        SortedSet<Show> shows = new TreeSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent1 = new ShowEvent(name, date, closeDate, location, judge, shows);

        name = "Test showEvent 2";
        date = LocalDate.of(2017, 6, 15);
        closeDate = LocalDate.of(2017, 4, 15);
        location = "Surhuisterveen";
        judge = " Test Judge ";
        shows = new TreeSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));

        ShowEvent showEvent2 = new ShowEvent(name, date, closeDate, location, judge, shows);

        showEventRepository.add(showEvent1);
        showEventRepository.add(showEvent2);

        assertEquals(2, showEventRepository.getAllShowEvents().size());

    }
}


