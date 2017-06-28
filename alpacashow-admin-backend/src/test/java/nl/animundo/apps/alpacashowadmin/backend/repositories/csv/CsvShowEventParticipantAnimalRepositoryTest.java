package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventParticipantAnimal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.util.Collection;

import static org.junit.Assert.*;

@Ignore
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

        Repository<ShowEventParticipantAnimal> repo = CsvShowEventParticipantAnimalRepository.importData(reader);
        reader.close();
        assertEquals(5, repo.getAll().size());

        String showId = "89560684-dd3a-4f69-a0c4-656dbba40585";
        String participantId = "13a6ec9d-dbb2-4370-a8db-113438e32103";
        String animalId = "a1d81f18-e47e-4f0a-b7f5-28b9eb42fa8e";

        String id2 = "9d539aac-ad77-47a7-9212-658a51c19374";
        String showEventId2 = "82b051b7-c52a-4457-93fa-6af4a47f371b";
        String participantId2 = "d70b5bf6-a23e-410a-9be0-d450e1a73f31";

        repo.add(id2, new ShowEventParticipantAnimal(id2, showEventId2, participantId2));

        String id3 = "d657aec8-6619-4a33-846e-0017f56d4de0";
        String showEventId3 = "82b051b7-c52a-4457-93fa-6af4a47f371b";
        String participantId3 = "d70b5bf6-a23e-410a-9be0-d450e1a73f31";
        String animalId3 = "1260c523-f7cc-4a05-8671-8fee42f8904a";

        repo.add(id3, new ShowEventParticipantAnimal(id3, showEventId3, participantId3, animalId3));

        assertEquals(7, repo.getAll().size());

        repo.delete("8e054946-97d2-4989-ba6c-760e4b71da7a");

        assertEquals(6, repo.getAll().size());

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_ANIMALS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventParticipantAnimalRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_PARTICIPANTS_ANIMALS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile);

        Repository<ShowEventParticipantAnimal> newRepo = CsvShowEventParticipantAnimalRepository.importData(reader);
        reader.close();

        String id4 = "d657aec8-6619-4a33-846e-0017f56d4de0";
        ShowEventParticipantAnimal showEventParticipantAnimal4 = newRepo.getById(id4);

        assertNotNull(showEventParticipantAnimal4);
        assertEquals("d70b5bf6-a23e-410a-9be0-d450e1a73f31", showEventParticipantAnimal4.getParticipantId());

    }
}


