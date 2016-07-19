package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventSearch;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Anniek van Dijk on 18-7-2016.
 */
public class CsvShowEventRepositoryTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventFromFile() throws IOException {
        final String workingDir = System.getProperty("user.dir");

        File file = new File(workingDir, "src/test/resources/csv/SHOWEVENTS.csv");
        assertTrue(file.isFile() && file.exists() && file.canRead());
        Reader reader = new FileReader(file) ;

        ShowEventRepository repo = CsvShowEventRepository.create(reader);
        assertEquals(2, repo.size());

        ShowEventSearch searchOption = ShowEventSearch.NAME;
        String searchFor = "Meppel 2017";
        ShowEvent showEvent = repo.search(searchOption, searchFor);
        assertNotNull(showEvent);
        assertEquals("Meppel", showEvent.getLocation());


    }
}
