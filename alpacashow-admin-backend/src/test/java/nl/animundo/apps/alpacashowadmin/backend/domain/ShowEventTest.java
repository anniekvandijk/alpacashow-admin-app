package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.time.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ShowEventTest {

    private String name;
    private LocalDate date;
    private LocalDate closeDate;
    private String location;
    private String judge;
    private ShowType showType;
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
        showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);

        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.now().plusMonths(8), showEvent.getDate());
        assertEquals(LocalDate.now().plusMonths(6), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
        assertEquals("FLEECESHOW", showEvent.getShowType().toString());
    }

    @Test
    public void newShowEventWithParticipants() {

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge ";
        showType = ShowType.HALTERSHOW;
        participants = new HashSet<>();
        participants.add(new Participant("Test participant"));
        participants.add(new Participant("Test participant2"));

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType, participants);

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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showDateBeforeNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is (before) today");

        name = "Test showEvent";
        date = LocalDate.now().minusDays(1);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showDateNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is (before) today");

        name = "Test showEvent";
        date = LocalDate.now();
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showCloseDateBeforeNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is (before) today");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().minusDays(1);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showCloseDateNow() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date is (before) today");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now();
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);

    }

    @Test
    public void dateShowEqualsCloseDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date show before or same as close date subscriptions");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(8);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);

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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
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
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showTypeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field showType can not be empty");

        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "Test Judge";
        showType = null;

        new ShowEvent(name, date, closeDate, location, judge, showType);
    }
}
