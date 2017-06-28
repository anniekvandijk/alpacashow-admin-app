package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.*;
import static org.junit.Assert.*;

public class CsvParticipantRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/showregistration/";


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportParticipantsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "PARTICIPANTS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "PARTICIPANTS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        Repository<Participant> repo = CsvParticipantRepository.importData(reader);
        reader.close();
        assertEquals(3, repo.getAll().size());

        String getId = "90a4dbdc-a580-40c8-8429-d90c15446951";
        Participant participant = repo.getById(getId);
        assertNotNull(participant);
        assertEquals("Alpacafarm 1", participant.getFarmName());
        assertEquals("farmnaam@iets.nl", participant.getEmail());
        assertEquals("050-1234567", participant.getTelephone());
        assertEquals("thuis 3a", participant.getAddress());
        assertEquals("1111 BB", participant.getZipCode());
        assertEquals("Surhuisterveen", participant.getCity());
        assertEquals("Nederland", participant.getCountry());

        String id = "5c492ade-412d-4d6f-9d5d-8f9aedb37a0a";
        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        repo.add(id, new Participant(id, name, farmName, email, telephone, address, zipCode, city, country));
        assertEquals(4, repo.getAll().size());

        File newExportFile = new File(workingDir + testFileDir + "PARTICIPANTS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvParticipantRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "PARTICIPANTS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        Repository<Participant> newRepo = CsvParticipantRepository.importData(reader);
        reader.close();
        assertEquals(4, newRepo.getAll().size());

        String key2 = "5c492ade-412d-4d6f-9d5d-8f9aedb37a0a";
        Participant participant2 = newRepo.getById(key2);
        assertNotNull(participant2);
        assertEquals("some City", participant2.getCity());

    }
}
