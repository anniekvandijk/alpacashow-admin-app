package nl.animundo.apps.alpacashowadmin.backend.controllers;

import nl.animundo.apps.alpacashowadmin.backend.IThelper;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import nl.animundo.apps.alpacashowadmin.backend.services.application.ApplicationRepositoryService;
import org.junit.Test;
import java.io.IOException;
import static nl.animundo.apps.alpacashowadmin.backend.controllers.JsonFileReaderHelper.readJsonfile;
import static org.junit.Assert.assertEquals;

public class FleeceWeightPointsControllerTest {

    private FleeceWeightPointsRepository fleeceWeightPointsRepository;
    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private IThelper helper = new IThelper(service);

    @Test
    public void getAllFleeceWeightPoints() throws IOException {

        FleeceWeightPointsController controller = new FleeceWeightPointsController();

        String result = (String)controller.getFleeceWeightPoints().getEntity();
        String resultTrim = result.replaceAll("\\s", "");
        String fileName = "get_allfleeceweightpoints.json";
        String expected = readJsonfile(fileName);
        String expectedTrim = expected.replaceAll("\\s", "");

        assertEquals(expectedTrim, resultTrim);
    }
}
