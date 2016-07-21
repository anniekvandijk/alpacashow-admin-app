package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.csv.CsvShowEventRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Anniek van Dijk on 20-7-2016.
 */
public class ShowEventServiceTest {

    // add show

    private String name;
    private LocalDate date;
    private LocalDate closeDate;
    private String location;
    private String judge;
    private Set<Show> shows;
    private Set<Participant> participants;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventToCsv() throws IOException {

        // TODO unittest not working

        /*
        name = "Westerlee 2017";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);

        ShowEventService showEventService = new ShowEventService();
        showEventService.add(showEvent);

        */
//
//        ShowEventRepository repo = new CsvShowEventRepository();
//        ShowEventSearch searchOption = ShowEventSearch.NAME;
//        String searchFor = "Assen 2017";
//        showEvent = repo.search(searchOption, searchFor);
//        assertNotNull(showEvent);
//        assertEquals("Assen", showEvent.getLocation());



    }

    @Test
    public void doubleShowEvent() throws IOException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("ShowEvent with name 'Assen 2017' and date '2017-05-01' already excists");

        name = "Assen 2017";
        date = LocalDate.of(2017, 5, 1);
        closeDate = date.minusDays(1);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALE_PROGENY_SHOW));
        shows.add(new Show(ShowType.MALE_PROGENY_SHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);

        ShowEventService showEventService = new ShowEventService();
        showEventService.add(showEvent);

    }

    // delete show

    // update show


}
