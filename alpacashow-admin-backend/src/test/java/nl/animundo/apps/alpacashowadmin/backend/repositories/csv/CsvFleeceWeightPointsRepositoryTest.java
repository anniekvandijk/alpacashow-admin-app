package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import nl.animundo.apps.alpacashowadmin.backend.repositories.FleeceWeightPointsRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CsvFleeceWeightPointsRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/json.helpfiles/";


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "FLEECEWEIGHTPOINTS.csv");
        File exportFile = new File(workingDir + testFileDir + "FLEECEWEIGHTPOINTS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        FleeceWeightPointsRepository repo = CsvFleeceWeightPointsRepository.importData(reader);
        reader.close();

        assertEquals(450, repo.getAllFleeceWeightPoints().size());

        String key = "HUACAYA_INTERMEDIATE_1.3";
        FleeceWeightPoints fleeceWeightPoints = repo.getFleeceWeightPointsByKeySet(key);
        assertNotNull(fleeceWeightPoints);
        assertEquals("HUACAYA", fleeceWeightPoints.getBreed().toString());
        assertEquals("INTERMEDIATE", fleeceWeightPoints.getAgeClass().toString());
        assertEquals("1.3", fleeceWeightPoints.getCleanFleeceWeight());
        assertEquals(6.0f, fleeceWeightPoints.getWeightPoints(), 0.05);

        BreedClass breed          = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "5.1";
        float weightPoints        = 17.0f;

        repo.add(new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints));

        assertEquals(451, repo.getAllFleeceWeightPoints().size());

        File newExportFile = new File(workingDir + testFileDir + "FLEECEWEIGHTPOINTS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvFleeceWeightPointsRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "FLEECEWEIGHTPOINTS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        FleeceWeightPointsRepository newRepo = CsvFleeceWeightPointsRepository.importData(reader);
        reader.close();
        assertEquals(451, newRepo.getAllFleeceWeightPoints().size());

        String key2 = "HUACAYA_FLEECE_JUNIOR_5.1";
        FleeceWeightPoints fleeceWeightPoints1 = newRepo.getFleeceWeightPointsByKeySet(key2);
        assertNotNull(fleeceWeightPoints1);
        assertEquals(17.0f, fleeceWeightPoints1.getWeightPoints(), 0.05);

    }
}
