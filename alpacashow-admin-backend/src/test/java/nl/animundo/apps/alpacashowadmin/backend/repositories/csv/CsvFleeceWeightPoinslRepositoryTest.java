package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.*;
import static org.junit.Assert.*;

public class CsvFleeceWeightPoinslRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/helpfiles/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "FLEECEWEIGHTPOINTS.csv");

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile);

        FleeceWeightPointsRepository repo = CsvFleeceWeightPointsRepository.importData(reader);
        reader.close();

        String key = "HUACAYA_MATURE_5.0";
        FleeceWeightPoints fleeceWeightPoints = repo.getFleeceWeightPointsByKeySet(key);
        assertNotNull(fleeceWeightPoints);
        assertEquals("HUACAYA", fleeceWeightPoints.getBreed().toString());
        assertEquals("MATURE", fleeceWeightPoints.getAgeClass().toString());
        assertEquals("5.0", fleeceWeightPoints.getCleanFleeceWeight());
        assertEquals(15.0f, fleeceWeightPoints.getWeightPoints(), 0.05);
    }
}


