package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.*;
import static org.junit.Assert.*;

public class CsvParticipantsRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/";


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importParticipantsFromFile() throws IOException {

        File file = new File(workingDir + testFileDir + "PARTICIPANTS_import.csv");

        assertTrue(file.isFile() && file.exists() && file.canRead());
        Reader reader = new FileReader(file) ;

        ParticipantRepository repo = CsvParticipantRepository.importData(reader);
        assertEquals(2, repo.getAllParticipants().size());

        String key = "Deelnemer 1";
        Participant participant = repo.getParticipantByKeySet(key);
        assertNotNull(participant);
        assertEquals("Alpacafarm 1", participant.getFarmName());
        assertEquals("farmnaam@iets.nl", participant.getEmail());
        assertEquals("050-1234567", participant.getTelephone());
        assertEquals("thuis 3a", participant.getAddress());
        assertEquals("1111 BB", participant.getZipCode());
        assertEquals("Surhuisterveen", participant.getCity());
        assertEquals("Nederland", participant.getCountry());
    }

    @Test
    public void exportParticipantsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "PARTICIPANTS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "PARTICIPANTS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        ParticipantRepository repo = CsvParticipantRepository.importData(reader);

        String name = "Test participant";
        String farmName = "farm";
        String email = "farm@farm.nl";
        String telephone = "06-12345678";
        String address = "some address";
        String zipCode = "1234 AA";
        String city = "some City";
        String country = "Netherlands";

        repo.add(new Participant(name, farmName, email, telephone, address, zipCode, city, country));
        assertEquals(3, repo.getAllParticipants().size());

        File newExportFile = new File(workingDir + testFileDir + "PARTICIPANTS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvParticipantRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "PARTICIPANTS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        ParticipantRepository newRepo = CsvParticipantRepository.importData(reader);
        assertEquals(3, newRepo.getAllParticipants().size());

        String key = "Test participant";
        Participant participant = newRepo.getParticipantByKeySet(key);
        assertNotNull(participant);
        assertEquals("some City", participant.getCity());

    }
}
