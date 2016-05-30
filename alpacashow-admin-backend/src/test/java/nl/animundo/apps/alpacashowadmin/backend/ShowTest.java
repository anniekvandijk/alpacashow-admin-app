package nl.animundo.apps.alpacashowadmin.backend;

import nl.animundo.apps.alpacashowadmin.backend.domain.Show;
import org.junit.*;
import java.time.*;
import static org.junit.Assert.*;

public class ShowTest {

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
    public void  newShow() {

        showName = "Test show";
        showDate = LocalDate.of(2016,5,1);
        showCloseDate = LocalDate.of(2016,1,1);
        showLocation = "Surhuisterveen";
        showJudge = "Test Judge";

        Show show = new Show(showName, showDate, showCloseDate, showLocation, showJudge);

        assertEquals("Test show", show.getShowName());
        assertEquals(LocalDate.of(2016,5,1), show.getShowDate());
        assertEquals(LocalDate.of(2016,1,1), show.getShowCloseDate());
        assertEquals("Surhuisterveen", show.getShowLocation());
        assertEquals("Test Judge", show.getShowJudge());
    }

    @Test
    public void  noDuplicateShowObjects() {

        // Er kunnen nooit meer objecten zijn dan 1 (voor nu)

        Show show = new Show(showName, showDate, showCloseDate, showLocation, showJudge);
        Show showduplicate = new Show(showName, showDate, showCloseDate, showLocation, showJudge);

        // TODO: Vraag: Hoe handig is het om deze objecten te tellen in een unittest?

    }
}
