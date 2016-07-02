package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ShowEventRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRepositoryTest.class);

    // TODO Add search for showTypes and participants

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void searchForKey() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.now().plusMonths(8);
        LocalDate closeDate = LocalDate.now().plusMonths(6);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.KEY;
        String searchFor = "Test showEvent_" + String.valueOf(LocalDate.now().plusMonths(8));
        assertEquals("Test showEvent_" + String.valueOf(LocalDate.now().plusMonths(8)), showEventRepository.search(searchOption, searchFor));

    }

    @Test
    public void searchForName() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.now().plusMonths(8);
        LocalDate closeDate = LocalDate.now().plusMonths(6);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.NAME;
        String searchFor = "Test showEvent";
        assertEquals("Test showEvent", showEventRepository.search(searchOption, searchFor));

    }

    @Test
    public void searchForDate() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.now().plusMonths(8);
        LocalDate closeDate = LocalDate.now().plusMonths(6);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.DATE;
        String searchFor = String.valueOf(LocalDate.now().plusMonths(8));
        assertEquals(String.valueOf(LocalDate.now().plusMonths(8)), showEventRepository.search(searchOption, searchFor));

    }

    @Test
    public void searchForCloseDate() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.now().plusMonths(8);
        LocalDate closeDate = LocalDate.now().plusMonths(6);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.CLOSEDATE;
        String searchFor = String.valueOf(LocalDate.now().plusMonths(6));
        assertEquals(String.valueOf(LocalDate.now().plusMonths(6)), showEventRepository.search(searchOption, searchFor));

    }

    @Test
    public void searchForLocation() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.now().plusMonths(8);
        LocalDate closeDate = LocalDate.now().plusMonths(6);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.LOCATION;
        String searchFor = "Surhuisterveen";
        assertEquals("Surhuisterveen", showEventRepository.search(searchOption, searchFor));

    }

    @Test
    public void searchForJudge() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.now().plusMonths(8);
        LocalDate closeDate = LocalDate.now().plusMonths(6);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();

        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.JUDGE;
        String searchFor = "Test Judge";
        assertEquals("Test Judge", showEventRepository.search(searchOption, searchFor));

    }
}


