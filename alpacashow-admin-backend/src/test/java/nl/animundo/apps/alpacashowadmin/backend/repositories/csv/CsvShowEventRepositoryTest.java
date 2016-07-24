package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.Application;
import nl.animundo.apps.alpacashowadmin.backend.domain.Show;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventSearch;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Anniek van Dijk on 18-7-2016.
 */
public class CsvShowEventRepositoryTest {

    final String workingDir = System.getProperty("user.dir");


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importShowEventsFromFile() throws IOException {

        File file = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoimporttest.csv");

        assertTrue(file.isFile() && file.exists() && file.canRead());
        Reader reader = new FileReader(file) ;

        ShowEventRepository repo = CsvShowEventRepository.importData(reader);
        assertEquals(2, repo.size());

        ShowEventSearch searchOption = ShowEventSearch.NAME;
        String searchFor = "Meppel 2017";
        ShowEvent showEvent = repo.search(searchOption, searchFor);
        assertNotNull(showEvent);
        assertEquals("Meppel", showEvent.getLocation());

    }

    @Test
    public void exportShowEventsToFile() throws IOException {

        File importFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoimporttest.csv");
        File exportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoexporttest.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        ShowEventRepository repo = CsvShowEventRepository.importData(reader);
        assertEquals(2, repo.size());

        String name = "Test showEvent";
        LocalDate date = LocalDate.of(2017, 7, 1);
        LocalDate closeDate = LocalDate.of(2017, 5, 15);
        String location = "Surhuisterveen";
        String judge = " Test Judge ";
        Set<Show> shows = new HashSet<>();
        shows.add(new Show(ShowType.FLEECESHOW));
        shows.add(new Show(ShowType.HALTERSHOW));

        repo.add(new ShowEvent(name, date, closeDate, location, judge, shows));
        assertEquals(3, repo.size());

        File newExportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoexporttest.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoexporttest.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        ShowEventRepository newRepo = CsvShowEventRepository.importData(reader);
        assertEquals(3, newRepo.size());

        ShowEventSearch searchOption = ShowEventSearch.NAME;
        String searchFor = "Test showEvent";
        ShowEvent showEvent = newRepo.search(searchOption, searchFor);
        assertNotNull(showEvent);
        assertEquals("Surhuisterveen", showEvent.getLocation());

    }

    @Test
    public void deleteShowEvent() throws IOException {

        File importFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoimporttest.csv");
        File exportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repodeletetest.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        ShowEventRepository repo = CsvShowEventRepository.importData(reader);
        assertEquals(2, repo.size());

        repo.delete("Hapert 2017_2017-04-24");
//        assertEquals(1, repo.size());

        File newExportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repodeletetest.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repodeletetest.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        ShowEventRepository newRepo = CsvShowEventRepository.importData(reader);
        assertEquals(1, newRepo.size());

    }

    @Test
    public void notKnownShowType() throws IOException {
        final String workingDir = System.getProperty("user.dir");

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No enum constant");

        File file = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repotest_notKnownShowType.csv");
        assertTrue(file.isFile() && file.exists() && file.canRead());
        Reader reader = new FileReader(file) ;

        ShowEventRepository repo = CsvShowEventRepository.importData(reader);
        
    }
}
