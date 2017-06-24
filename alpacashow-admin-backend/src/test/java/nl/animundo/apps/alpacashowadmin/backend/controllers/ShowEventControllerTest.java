package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.IThelper;
import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.*;

import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventControllerTest {

    private RepositoryContext context;
    private ApplicationRepositoryService service;
    private IThelper helper = new IThelper(context, service);

    public ShowEventControllerTest(RepositoryContext context)
    {
        this.context = context;
        service = new ApplicationRepositoryService(context);
    }

    @Before
    public void AddShowEvents () throws IOException {
        helper.AddCompleteShowEvent();
    }

    @Test
    public void getAllShowEvents() throws IOException {

        ShowEventController controller = new ShowEventController();

        String result = (String)controller.getShowEvents().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allshowevents.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }

    @Test
    public void getShowEventByKey() throws IOException {

        ShowEventController controller = new ShowEventController();

        Response resultCode = controller.getShowEventById("2017-04-01_MALE_PROGENY_SHOW");
        String result = (String) controller.getShowEventById("2017-04-01_MALE_PROGENY_SHOW").getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_showeventbykey.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
        assertEquals(200, resultCode.getStatus());
    }

    @Test
    public void addDeleteUpdateShowEvent() throws IOException {

        ShowEventController controller = new ShowEventController();

        String showEvent = readJsonfile("add_showevent.json");
        controller.addShowEvent(showEvent);

        String result = (String) controller.getShowEventById("2017-03-01_HALTERSHOW").getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "add_showevent.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");
        assertEquals(expectedTrim, resultTrim);

        String showEvent2 = readJsonfile("update_showevent.json");
        controller.updateShowEvent("2017-03-01_HALTERSHOW", showEvent2);

        String result2 = (String) controller.getShowEventById("2017-03-01_HALTERSHOW").getEntity();
        String resultTrim2 = result2.replaceAll("\\s", "");
        String fileName2 = "update_showevent.json";
        String expected2 = readJsonfile(fileName2);
        String expectedTrim2 = expected2.replaceAll("\\s", "");
        assertEquals(expectedTrim2, resultTrim2);

        controller.deleteShowEvent("2017-03-01_HALTERSHOW");

        Response response = controller.getShowEventById("2017-03-01_HALTERSHOW");
        assertEquals(404, response.getStatus());


    }

    @Test
    public void getShowEventByNotExistingKey() throws IOException {

        ShowEventController controller = new ShowEventController();

        Response resultCode = controller.getShowEventById("2017-04-01_HALTERSHOW");
        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void addShowEventWithWrongData() throws IOException {

        ShowEventController controller = new ShowEventController();

        String showEvent = readJsonfile("add_showeventWrong.json");
        Response resultCode = controller.addShowEvent(showEvent);

        assertEquals(400, resultCode.getStatus());

    }

    @Test
    public void updateShowEventWithWrongKey() throws IOException {

        ShowEventController controller = new ShowEventController();

        String showEvent = readJsonfile("update_showevent.json");
        Response resultCode = controller.updateShowEvent("Breda 2017_2018-04-01", showEvent);

        assertEquals(404, resultCode.getStatus());
    }

    @Test
    public void updateShowEventWithWrongData() throws IOException {

        ShowEventController controller = new ShowEventController();

        String showEvent = readJsonfile("update_showeventWrong.json");
        Response resultCode = controller.updateShowEvent("2017-04-01_MALE_PROGENY_SHOW", showEvent);

        assertEquals(400, resultCode.getStatus());
    }

    @Test
    public void deleteShowEventWithWrongKey() throws IOException {

        ShowEventController controller = new ShowEventController();
        Response resultCode = controller.deleteShowEvent("2017-03-01_HALTERSHO");

        assertEquals(404, resultCode.getStatus());

    }
}
