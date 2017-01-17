package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventParticipant;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CsvShowEventParticipantRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventParticipantsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile);

        ShowEventParticipantRepository repo = CsvShowEventParticipantRepository.importData(reader);
        reader.close();
        assertEquals(3, repo.getAllShowEventParticipants().size());

        String key = "2017-04-01_MALE_PROGENY_SHOW_Deelnemer 1";
        ShowEventParticipant showEventParticipant = repo.getShowEventParticipantByKeySet(key);
        assertNotNull(showEventParticipant);
        assertEquals("2017-04-01_MALE_PROGENY_SHOW", showEventParticipant.getShowEventKey());
        assertEquals("Deelnemer 1", showEventParticipant.getParticipantKey());

        String showEventKey = "2017-06-04_FLEECESHOW";
        String participantKey = "Deelnemer 3";

        repo.add(new ShowEventParticipant(showEventKey, participantKey));
        repo.delete("2017-05-01_HALTERSHOW_Deelnemer 3");

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventParticipantRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile);

        ShowEventParticipantRepository newRepo = CsvShowEventParticipantRepository.importData(reader);
        reader.close();


        String key4 = "2017-06-04_FLEECESHOW_Deelnemer 3";
        ShowEventParticipant showEventParticipant4 = newRepo.getShowEventParticipantByKeySet(key4);
        assertEquals(4, repo.getAllShowEventParticipants().size());
        assertNotNull(showEventParticipant4);
        assertEquals("Deelnemer 3", showEventParticipant4.getParticipantKey());

    }
}


