package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.*;
import org.junit.rules.ExpectedException;
import java.time.*;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ShowEventTest {

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
    public void newShowEventWithTrim() {

        name = "Test showEvent    ";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "   Surhuisterveen";
        judge = " Test Judge ";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FEMALEPROGENYSHOW));
        shows.add(new Show(ShowType.MALEPROGENYSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.now().plusMonths(8), showEvent.getDate());
        assertEquals(LocalDate.now().plusMonths(6), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
        assertEquals(shows, showEvent.getShow());
    }

    @Test
    public void newShowEventWithParticipants() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge ";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));
        participants = new HashSet<>();
        participants.add(new Participant("Test participant"));
        participants.add(new Participant("Test participant2"));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows, participants);

        assertEquals(participants, showEvent.getParticipants());
    }

    @Test
    public void showNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = null;
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showNameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = "";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showDateBeforeNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is before today");

        name = "Test showEvent";
        date = LocalDate.now().minusDays(1);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date can not be empty");

        name = "Test showEvent";
        date = null;
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showCloseDateNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is before today");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now();
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showCloseDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field closeDate can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = null;
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void dateShowBeforeCloseDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date show before or same as close date subscriptions");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(9);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);

    }

    @Test
    public void showLocationNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = " ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showLocationNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = null;
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void showJudgeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = null;
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        new ShowEvent(name, date, closeDate, location, judge, shows);
    }

    @Test
    public void setShowEventName() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setName("Test showEvent change  ");

        assertEquals("Test showEvent change", showEvent.getName());

    }

    @Test
    public void setShowEventNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setName(null);
    }

    @Test
    public void setShowEventNameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setName("  ");
    }

    @Test
    public void setShowEventDate() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setDate(LocalDate.now().plusYears(1));

        assertEquals(LocalDate.now().plusYears(1), showEvent.getDate());

    }

    @Test
    public void setShowEventDateNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is before today");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setDate(LocalDate.now().minusWeeks(2));
    }

    @Test
    public void setShowEventDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setDate(null);
    }

    @Test
    public void setDateSameAsCloseDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date show before or same as close date subscriptions");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setDate(LocalDate.now().plusMonths(6));

    }

    @Test
    public void setShowEventCloseDate() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setCloseDate(LocalDate.now().plusWeeks(5));

        assertEquals(LocalDate.now().plusWeeks(5), showEvent.getCloseDate());
    }

    @Test
    public void setShowEventCloseDateBeforeNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Close date is before today");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setCloseDate(LocalDate.now().minusMonths(6));
    }

    @Test
    public void setShowEventCloseDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field closeDate can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setCloseDate(null);
    }

    @Test
    public void setCloseDateAfterDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date show before or same as close date subscriptions");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setCloseDate(LocalDate.now().plusMonths(9));

    }

    @Test
    public void setShowEventLocation() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setLocation("Somewhere else  ");

        assertEquals("Somewhere else", showEvent.getLocation());
    }

    @Test
    public void setShowEventLocationNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setLocation(null);
    }

    @Test
    public void setShowEventLocationNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setLocation("     ");
    }

    @Test
    public void setShowEventJudge() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setJudge("   Test judge2");

        assertEquals("Test judge2", showEvent.getJudge());
    }

    @Test
    public void setShowEventJudgeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setJudge(null);
    }

    @Test
    public void setShowEventJudgeNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        showEvent.setJudge("     ");
    }

    @Test
    public void setShowRemoveShowType() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        shows = new HashSet<>();
        shows.add(new Show(ShowType.HALTERSHOW));
        shows.add(new Show(ShowType.FLEECESHOW));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, shows);
        shows.remove(new Show(ShowType.FLEECESHOW));

        assertEquals(shows, showEvent.getShow());
    }
}
