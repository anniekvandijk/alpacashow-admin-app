package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.time.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class ShowEventTest {

    private String id;
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

        id = "c6947908-830d-4c10-ac0a-042f044f7a40   ";
        name = "Test showEvent    ";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "   Surhuisterveen";
        judge = " Test Judge ";
        showType = ShowType.FLEECESHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);

        assertEquals("c6947908-830d-4c10-ac0a-042f044f7a40", showEvent.getId());
        assertEquals("Test showEvent", showEvent.getName());
        assertEquals(LocalDate.now().plusMonths(8), showEvent.getDate());
        assertEquals(LocalDate.now().plusMonths(6), showEvent.getCloseDate());
        assertEquals("Surhuisterveen", showEvent.getLocation());
        assertEquals("Test Judge", showEvent.getJudge());
        assertEquals("FLEECESHOW", showEvent.getShowType().toString());
    }

    @Test
    public void newShowEventWithParticipants() {

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge ";
        showType = ShowType.HALTERSHOW;
        participants = new LinkedHashSet<>();
        participants.add(new Participant("a00b6108-cdd8-44f4-a5f4-b5a520f1f38a","Test participant", "farm 1", "", "", "", "", "", ""));
        participants.add(new Participant("a00b6108-cdd8-44f4-a5f4-b5a520f1f381","Test participant2", "farm 2", "", "", "", "", "", ""));

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType, participants);

        assertEquals(participants, showEvent.getParticipants());
    }

    @Test @Ignore
    public void showIdNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field id can not be empty");

        id = null;
        name = "Show";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test @Ignore
    public void showIdNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field id can not be empty");

        id = " ";
        name = "Show";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showNameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = null;
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "   Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showNameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = null;
        closeDate = LocalDate.now().plusMonths(6);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showCloseDateNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field closeDate can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = null;
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void dateShowBeforeCloseDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date show before or same as close date subscriptions");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(9);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);

    }

    @Test
    public void dateShowEqualsCloseDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Date show before or same as close date subscriptions");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(8);
        location = "Surhuisterveen ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);

    }

    @Test
    public void showLocationNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = " ";
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showLocationNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field location can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = null;
        judge = "Test Judge";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showJudgeNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "  ";
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showJudgeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field judge can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = null;
        showType = ShowType.HALTERSHOW;

        ShowEvent showEvent = new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }

    @Test
    public void showTypeNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field showType can not be empty");

        id = "c6947908-830d-4c10-ac0a-042f044f7a40";
        name = "Test showEvent";
        date = LocalDate.now().plusMonths(8);
        closeDate = LocalDate.now().plusMonths(6);
        location = "  Surhuisterveen ";
        judge = "Test Judge";
        showType = null;

        new ShowEvent(id, name, date, closeDate, location, judge, showType);
    }
}
