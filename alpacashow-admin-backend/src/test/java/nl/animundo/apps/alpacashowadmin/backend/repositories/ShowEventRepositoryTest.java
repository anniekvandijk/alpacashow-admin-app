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

    // TODO add exceptions
    // TODO Add search for showTypes and participants
    // TODO Add search for part of searchvalue
    // TODO Add search for more search options. HOW? Make a list and loop through list I think

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.NAME;
        String searchFor = "Test showEvent";
        assertEquals("Test showEvent", showEventRepository.search(searchOption, searchFor).getName());

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
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.DATE;
        String searchFor = String.valueOf(LocalDate.now().plusMonths(8));
        assertEquals(LocalDate.now().plusMonths(8), showEventRepository.search(searchOption, searchFor).getDate());

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
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.CLOSEDATE;
        String searchFor = String.valueOf(LocalDate.now().plusMonths(6));
        assertEquals(LocalDate.now().plusMonths(6), showEventRepository.search(searchOption, searchFor).getCloseDate());

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
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        ShowEventSearch searchOption = ShowEventSearch.LOCATION;
        String searchFor = "Surhuisterveen";
        assertEquals("Surhuisterveen", showEventRepository.search(searchOption, searchFor).getLocation());

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
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        String searchFor = "Test Judge";
        assertEquals(searchFor, showEventRepository.search(ShowEventSearch.JUDGE, searchFor).getJudge());
    }
}


