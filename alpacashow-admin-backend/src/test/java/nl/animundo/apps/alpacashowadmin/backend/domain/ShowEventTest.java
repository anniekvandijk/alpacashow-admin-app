package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.*;
import org.junit.rules.ExpectedException;
import java.time.*;

import static org.junit.Assert.*;

public class ShowEventTest {

    String name;
    LocalDate date;
    LocalDate closeDate;
    String location;
    String judge;

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

    @Test
    public void showNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = null;
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showNameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = "";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showLocationNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = " ";
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showLocationNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = null;
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showJudgeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,1,1);
        location = "  Surhuisterveen ";
        judge = null;

        new ShowEvent(name, date, closeDate, location, judge);
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
