package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.time.*;
import java.util.Set;

import static org.junit.Assert.*;

public class ShowEventTest {

    String name;
    LocalDate date;
    LocalDate closeDate;
    String location;
    String judge;

    int nrOfObjectsInClass = 0;

    // TODO: Create datehelper json date > jave date  and unittests for the datehelper

    // TODO: codecoverage set

    /** TODO Exception tests
     *
     * Alle velden zijn verplicht
     * Shownaam mag niet meer dan 60 tekens zijn
     *
     */

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newShowEvent() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,1,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }

    @Test
    public void newShowEventWithShowTypes() {

        // TODO At list for showTypes

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,1,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }


    @Test
    public void showEventTrim() {

        name = "Test showEvent  ";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,1,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }

    @Test @Ignore
    public void showEventNull() {

        name = null;
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,1,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }

    @Test
    public void showEventRequiredName() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Veld naam mag niet leeg zijn");

        name = "";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showEventRequiredLocation() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Veld locatie mag niet leeg zijn");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = " ";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void setShowEventFields() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        showEvent.setName("Test showEvent change");
        showEvent.setDate(LocalDate.of(2016,6,2));
        showEvent.setCloseDate(LocalDate.of(2016,7,12));
        showEvent.setLocation("Meppel");
        showEvent.setJudge("Test Judge change");

        assertEquals("Test showEvent change", showEvent.getName());
        assertEquals(LocalDate.of(2016,6,2), showEvent.getDate());
        assertEquals(LocalDate.of(2016,7,12), showEvent.getCloseDate());
        assertEquals("Meppel", showEvent.getLocation());
        assertEquals("Test Judge change", showEvent.getJudge());

    }
}
