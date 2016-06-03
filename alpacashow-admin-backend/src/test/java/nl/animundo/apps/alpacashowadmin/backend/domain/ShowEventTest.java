package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import org.junit.*;
import java.time.*;
import static org.junit.Assert.*;

public class ShowEventTest {

    String showName;
    LocalDate showDate;
    LocalDate showCloseDate;
    String showLocation;
    String showJudge;

    int nrOfObjectsInClass = 0;

    // TODO: Create datehelper json date > jave date  and unittests for the datehelper

    // TODO: codecoverage set

    /*********************************
     * GENERAL TESTS
     ********************************/

    @Test
    public void newShowEvent() {

        showName = "Test showEvent";
        showDate = LocalDate.of(2016,5,1);
        showCloseDate = LocalDate.of(2016,1,1);
        showLocation = "Surhuisterveen";
        showJudge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(showName, showDate, showCloseDate, showLocation, showJudge);

        assertEquals("Test showEvent", showEvent.getShowName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getShowDate());
        assertEquals(LocalDate.of(2016,1,1), showEvent.getShowCloseDate());
        assertEquals("Surhuisterveen", showEvent.getShowLocation());
        assertEquals("Test Judge", showEvent.getShowJudge());
    }

    @Test
    public void setShowEventFields() {

        showName = "Test showEvent";
        showDate = LocalDate.of(2016,5,1);
        showCloseDate = LocalDate.of(2016,1,1);
        showLocation = "Surhuisterveen";
        showJudge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(showName, showDate, showCloseDate, showLocation, showJudge);

        showEvent.setShowName("Test showEvent change");
        showEvent.setShowDate(LocalDate.of(2016,6,2));
        showEvent.setShowCloseDate(LocalDate.of(2016,7,12));
        showEvent.setShowLocation("Meppel");
        showEvent.setShowJudge("Test Judge change");

        assertEquals("Test showEvent change", showEvent.getShowName());
        assertEquals(LocalDate.of(2016,6,2), showEvent.getShowDate());
        assertEquals(LocalDate.of(2016,7,12), showEvent.getShowCloseDate());
        assertEquals("Meppel", showEvent.getShowLocation());
        assertEquals("Test Judge change", showEvent.getShowJudge());

    }

    @Test
    public void  noDuplicateShowEventObjects() {

        // Er kunnen nooit meer objecten zijn dan 1 (voor nu)

        ShowEvent showEvent = new ShowEvent(showName, showDate, showCloseDate, showLocation, showJudge);
        ShowEvent showduplicate = new ShowEvent(showName, showDate, showCloseDate, showLocation, showJudge);

        // TODO: Vraag: Hoe handig is het om deze objecten te tellen in een unittest?

    }
}
