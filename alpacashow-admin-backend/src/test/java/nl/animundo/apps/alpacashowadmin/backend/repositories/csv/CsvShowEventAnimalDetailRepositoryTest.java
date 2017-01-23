package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventAnimalDetailRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CsvShowEventAnimalDetailRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/showregistration/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventAnimalDetailsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALDETAIL_import.csv");
        File exportFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALDETAIL_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile);

        ShowEventAnimalDetailRepository repo = CsvShowEventAnimalDetailRepository.importData(reader);
        reader.close();
        assertEquals(6, repo.getAllShowEventAnimalDetails().size());

        String key = "2017-08-15_HALTERSHOW_Test participant 1_8765";
        ShowEventAnimalDetail showEventAnimalDetail = repo.getShowEventAnimalDetailByKeySet(key);
        assertNotNull(showEventAnimalDetail);
        assertEquals("2017-08-15_HALTERSHOW", showEventAnimalDetail.getShowEventKey());
        assertEquals("Test participant 1", showEventAnimalDetail.getParticipantKey());
        assertEquals("8765", showEventAnimalDetail.getAnimalKey());
        assertEquals(null, showEventAnimalDetail.getSheerDate());
        assertEquals(null, showEventAnimalDetail.getBeforeSheerDate());

        String key2 = "2017-06-15_FLEECESHOW_Test participant 1_8765";
        ShowEventAnimalDetail showEventAnimalDetail2 = repo.getShowEventAnimalDetailByKeySet(key2);
        assertEquals("2016-05-01", showEventAnimalDetail2.getSheerDate().toString());
        assertEquals(null, showEventAnimalDetail2.getBeforeSheerDate());

        String showEventKey = "2017-06-15_FLEECESHOW";
        String participantKey = "Deelnemer 3";
        String animalKey = "8888";
        LocalDate sheerDate = LocalDate.of(2016, 5, 3);
        LocalDate beforeSheerDate = null;
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClass = 123;

        repo.add(new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate, ageClass, showClass));

        repo.delete("2017-08-15_HALTERSHOW_Test participant 1_7659");

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALDETAIL_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventAnimalDetailRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALDETAIL_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile);

        ShowEventAnimalDetailRepository newRepo = CsvShowEventAnimalDetailRepository.importData(reader);
        reader.close();

        String key4 = "2017-06-15_FLEECESHOW_Deelnemer 3_8888";
        ShowEventAnimalDetail showEventAnimalDetail4 = newRepo.getShowEventAnimalDetailByKeySet(key4);
        assertNotNull(showEventAnimalDetail4);
        assertEquals("8888", showEventAnimalDetail4.getAnimalKey());

    }
}


