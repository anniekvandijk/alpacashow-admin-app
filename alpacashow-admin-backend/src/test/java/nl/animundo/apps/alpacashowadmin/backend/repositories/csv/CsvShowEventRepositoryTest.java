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

        File file = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repotest.csv");

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

        File file = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoimporttest.csv");

        assertTrue(file.isFile() && file.exists() && file.canRead());
        Reader reader = new FileReader(file) ;

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

        File exportFile = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repoexporttest.csv");
        FileWriter writer = new FileWriter(exportFile);
        CsvShowEventRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

    }

    @Test
    public void notKnownShowType() throws IOException {
        final String workingDir = System.getProperty("user.dir");

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Showtype Haltershows is not a known showtype.");

        File file = new File(workingDir, "src/test/resources/csv/SHOWEVENTS_repotest_notKnownShowType.csv");
        assertTrue(file.isFile() && file.exists() && file.canRead());
        Reader reader = new FileReader(file) ;

        ShowEventRepository repo = CsvShowEventRepository.importData(reader);
        
    }
}
