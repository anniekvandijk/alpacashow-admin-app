package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
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
    final String testFileDir = "/src/test/resources/csv/";


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

        ShowEventRepository repo = CsvShowEventRepository.importData(reader);
        assertEquals(2, repo.getAllShowEvents().size());

        String key = "2017-04-24_MALE_PROGENY_SHOW";
        ShowEvent showEvent = repo.getShowEventByKeySet(key);
        assertNotNull(showEvent);
        assertEquals("Hapert 2017", showEvent.getName());
        assertEquals("2017-04-24", showEvent.getDate().toString());
        assertEquals("2017-03-20", showEvent.getCloseDate().toString());
        assertEquals("Hapert", showEvent.getLocation());
        assertEquals("Judge X", showEvent.getJudge());
        assertEquals("MALE_PROGENY_SHOW", showEvent.getShowType().toString());

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2017, 7, 1);
        LocalDate closeDate = LocalDate.of(2017, 5, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        ShowType showType = ShowType.FLEECESHOW;

        repo.add(new ShowEvent(name, date, closeDate, location, judge, showType));
        assertEquals(3, repo.getAllShowEvents().size());

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        ShowEventRepository newRepo = CsvShowEventRepository.importData(reader);
        assertEquals(3, newRepo.getAllShowEvents().size());

        String key2 = "2017-07-01_FLEECESHOW";
        ShowEvent showEvent2 = newRepo.getShowEventByKeySet(key2);
        assertNotNull(showEvent2);
        assertEquals("Surhuisterveen", showEvent2.getLocation());

    }
}
