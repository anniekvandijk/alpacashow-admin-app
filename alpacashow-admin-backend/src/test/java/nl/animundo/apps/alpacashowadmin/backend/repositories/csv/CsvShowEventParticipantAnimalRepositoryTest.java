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

        String showId = "cbef0073-5bc3-493e-99da-0e9ef967b3d9";
        String participantId = "13a6ec9d-dbb2-4370-a8db-113438e32103";
        String animalId = "6b82f05a-aabf-482b-a6f9-25816413294d";
        Collection<ShowEventParticipantAnimal> showEventParticipantAnimal = repo.getAll();
        assertTrue(showId, showEventParticipantAnimal.contains(showId));
        assertTrue(showEventParticipantAnimal.contains(participantId));
        assertTrue(showEventParticipantAnimal.contains(animalId));

        String showEventId2 = "82b051b7-c52a-4457-93fa-6af4a47f371b";
        String participantId2 = "d70b5bf6-a23e-410a-9be0-d450e1a73f31";
        String repoId = "9d539aac-ad77-47a7-9212-658a51c19374";

        repo.add(repoId, new ShowEventParticipantAnimal(showEventId2, participantId2));

        assertEquals(6, repo.getAll().size());

        repo.delete("2017-05-01_HALTERSHOW_Deelnemer 3");

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
//
//
//
//        String key4 = "2017-06-04_FLEECESHOW_Deelnemer 3";
//        ShowEventParticipantAnimal showEventParticipant4 = newRepo.getShowEventParticipantByKeySet(key4);
//
//        assertNotNull(showEventParticipant4);
//        assertEquals("Deelnemer 3", showEventParticipant4.getParticipantKey());

    }
}


