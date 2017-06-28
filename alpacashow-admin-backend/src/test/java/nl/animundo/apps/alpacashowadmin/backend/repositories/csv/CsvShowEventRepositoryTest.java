package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CsvShowEventRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/showregistration/";


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "SHOWEVENTS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        Repository<ShowEvent> repo = CsvShowEventRepository.importData(reader);
        reader.close();
        assertEquals(2, repo.getAll().size());

        String getId = "524cace0-65b5-4db4-88da-b3f1960d3ca8";
        ShowEvent showEvent = repo.getById(getId);
        assertNotNull(showEvent);
        assertEquals("Hapert 2017", showEvent.getName());
        assertEquals("2030-04-24", showEvent.getDate().toString());
        assertEquals("2030-03-20", showEvent.getCloseDate().toString());
        assertEquals("Hapert", showEvent.getLocation());
        assertEquals("Judge X", showEvent.getJudge());
        assertEquals("MALE_PROGENY_SHOW", showEvent.getShowType().toString());

        String id = "65c8f84d-7920-4387-879e-addc2f95f8d4";
        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2030, 7, 1);
        LocalDate closeDate = LocalDate.of(2030, 5, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        repo.add(id, new ShowEvent(id, name, date, closeDate, location, judge, showType));
        assertEquals(3, repo.getAll().size());

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        Repository <ShowEvent> newRepo = CsvShowEventRepository.importData(reader);
        reader.close();
        assertEquals(3, newRepo.getAll().size());

        String key2 = "65c8f84d-7920-4387-879e-addc2f95f8d4";
        ShowEvent showEvent2 = newRepo.getById(key2);
        assertNotNull(showEvent2);
        assertEquals("Surhuisterveen", showEvent2.getLocation());

    }
}
