package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.*;
import org.junit.rules.ExpectedException;
import java.time.*;
import java.util.Date;

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
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,10,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }

    @Test
    public void newShowEventWithShowTypes() {

        // TODO At list for showTypes

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,10,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }


    @Test
    public void showEventTrim() {

        name = "Test showEvent  ";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.of(2016,5,1), showEvent.getDate());
        assertEquals(LocalDate.of(2016,10,1), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
    }

    @Test
    public void showNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = null;
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
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
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date can not be empty");

        name = "Test showEvent";
        date = null;
        closeDate = LocalDate.of(2016,1,1);
        location = "Surhuisterveen ";
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void showCloseDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field closeDate can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = null;
        location = "Surhuisterveen ";
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void closeDateBeforeDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Close date show before date show");

        name = "Test showEvent";
        date = LocalDate.of(2016, 5, 2);
        closeDate = LocalDate.of(2016, 5, 1);
        location = "Surhuisterveen ";
        judge = "Test Judge";

        new ShowEvent(name, date, closeDate, location, judge);

    }

    @Test
    public void showLocationNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
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
        closeDate = LocalDate.of(2016,10,1);
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
        closeDate = LocalDate.of(2016,10,1);
        location = "  Surhuisterveen ";
        judge = null;

        new ShowEvent(name, date, closeDate, location, judge);
    }

    @Test
    public void setShowEventName() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setName("Test showEvent change  ");

        assertEquals("Test showEvent change", showEvent.getName());

    }

    @Test
    public void setShowEventNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setName(null);
    }

    @Test
    public void setShowEventNameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setName("  ");
    }

    @Test
    public void setShowEventDate() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setDate(LocalDate.of(2016, Month.OCTOBER, 3));

        assertEquals(LocalDate.of(2016,10,3), showEvent.getDate());

    }

    @Test
    public void setShowEventDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setDate(null);
    }

    @Test
    public void setDateBeforeCloseDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Close date show before date show");

        name = "Test showEvent";
        date = LocalDate.of(2016, 5, 1);
        closeDate = LocalDate.of(2016, 10, 1);
        location = "Surhuisterveen ";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setDate(LocalDate.of(2016, 9, 30));

    }

    @Test
    public void setShowEventCloseDate() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setCloseDate(LocalDate.of(2016, Month.OCTOBER, 3));

        assertEquals(LocalDate.of(2016,10,3), showEvent.getCloseDate());
    }

    @Test
    public void setShowEventCloseDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field closeDate can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setCloseDate(null);
    }

    @Test
    public void setCloseDateSameAsDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Close date show before date show");

        name = "Test showEvent";
        date = LocalDate.of(2016, 5, 1);
        closeDate = LocalDate.of(2016, 10, 1);
        location = "Surhuisterveen ";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setCloseDate(LocalDate.of(2016, 4, 1));

    }

    @Test
    public void setShowEventLocation() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setLocation("Somewhere else  ");

        assertEquals("Somewhere else", showEvent.getLocation());
    }

    @Test
    public void setShowEventLocationNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setLocation(null);
    }

    @Test
    public void setShowEventLocationNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setLocation("     ");
    }

    @Test
    public void setShowEventJudge() {

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setJudge("   Test judge2");

        assertEquals("Test judge2", showEvent.getJudge());
    }

    @Test
    public void setShowEventJudgeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setJudge(null);
    }

    @Test
    public void setShowEventJudgeNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        name = "Test showEvent";
        date = LocalDate.of(2016,5,1);
        closeDate = LocalDate.of(2016,10,1);
        location = "Surhuisterveen";
        judge = "Test Judge";

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge);
        showEvent.setJudge("     ");
    }
}
