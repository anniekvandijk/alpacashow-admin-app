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

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void searchForShow() {

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
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

        String searchForKey = "Test showEvent_2017-06-15";
        assertEquals("Test showEvent", showEventRepository.search(searchForKey).getName());

    }
}


