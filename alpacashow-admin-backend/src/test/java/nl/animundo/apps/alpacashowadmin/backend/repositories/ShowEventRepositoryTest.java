package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

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
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        String searchForKey = "2017-06-15_FLEECESHOW";
        assertEquals("Test showEvent", showEventRepository.search(searchForKey).getName());

    }

    @Test
    public void searchForNotKnownShow() {

        exception.expect(NullPointerException.class);

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
        ShowEventRepository showEventRepository = new ShowEventRepository();

        showEventRepository.add(showEvent);

        String searchForKey = "2017-06-14_FLEECESHOW";
        showEventRepository.search(searchForKey).getName();

    }

    @Test
    public void getAllShowEvents() {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String name = "Test showEvent 1";
        LocalDate date = LocalDate.of(2017, 6, 15);
        LocalDate closeDate = LocalDate.of(2017, 4, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        ShowEvent showEvent1 = new ShowEvent(name, date, closeDate, location, judge, showType);

        name = "Test showEvent 2";
        date = LocalDate.of(2017, 6, 15);
        closeDate = LocalDate.of(2017, 4, 15);
        location = "Surhuisterveen";
        judge = " Test Judge ";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent2 = new ShowEvent(name, date, closeDate, location, judge, showType);

        showEventRepository.add(showEvent1);
        showEventRepository.add(showEvent2);

        assertEquals(2, showEventRepository.getAllShowEvents().size());

    }
}


