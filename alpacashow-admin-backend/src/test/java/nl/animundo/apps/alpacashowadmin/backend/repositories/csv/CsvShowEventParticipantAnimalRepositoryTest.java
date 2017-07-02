package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventParticipantAnimalRepository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.util.Collection;

import static org.junit.Assert.*;

public class CsvShowEventParticipantAnimalRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/showregistration/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventParticipantsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_ANIMALS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_ANIMALS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile);

        ShowEventParticipantAnimalRepository repo = CsvShowEventParticipantAnimalRepository.importData(reader);
        reader.close();
        assertEquals(5, repo.getAll().size());

        String showEventId2 = "82b051b7-c52a-4457-93fa-6af4a47f371b";
        String participantId2 = "d70b5bf6-a23e-410a-9be0-d450e1a73f31";
        String animalId2 = "1260c523-f7cc-4a05-8671-8fee42f8904a";

        repo.add(new ShowEventParticipantAnimal(showEventId2, participantId2, animalId2));

        String showEventId3 = "82b051b7-c52a-4457-93fa-6af4a47f371b";
        String participantId3 = "d70b5bf6-a23e-410a-9be0-d450e1a73f31";
        String animalId3 = "1260c523-f7cc-4a05-8671-8fee42f8904a";

        repo.add(new ShowEventParticipantAnimal(showEventId3, participantId3, animalId3));

        assertEquals(7, repo.getAll().size());

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_ANIMALS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventParticipantAnimalRepository.exportData(writer, repo);
        writer.flush();
        writer.close();
    }
}


