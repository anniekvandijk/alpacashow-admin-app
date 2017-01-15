package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CsvShowEventRegistrationRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventRegistrationsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_REGISTRATIONS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "SHOWEVENTS_REGISTRATIONS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile);

        ShowEventRegistrationRepository repo = CsvShowEventRegistrationRepository.importData(reader);
        reader.close();
        assertEquals(5, repo.getAllShowEventRegistrations().size());

        String key = "2017-04-01_MALE_PROGENY_SHOW_Deelnemer 1_982000123169930";
        ShowEventRegistration showEventRegistration = repo.getShowEventRegistrationByKeySet(key);
        assertNotNull(showEventRegistration);
        assertEquals("2017-04-01_MALE_PROGENY_SHOW", showEventRegistration.getShowEventKey());
        assertEquals("Deelnemer 1", showEventRegistration.getParticipantKey());
        assertEquals("982000123169930", showEventRegistration.getAnimalKey());
        assertEquals("INTERMEDIATE", showEventRegistration.getAgeClass().toString());
        assertEquals(110, showEventRegistration.getShowClassCode());
        assertEquals("2016-05-01", showEventRegistration.getSheerDate().toString());
        assertEquals(null, showEventRegistration.getBeforeSheerDate());

        String showEventKey = "2017-06-04_FLEECESHOW";
        String participantKey = "Deelnemer 3";
        String animalKey = "8888";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 210;
        LocalDate sheerDate = LocalDate.of(2016, 5, 3);
        LocalDate beforeSheerDate = null;

        repo.add(new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate));
        repo.delete("2017-05-01_HALTERSHOW_Deelnemer 2_12347");

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_REGISTRATIONS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventRegistrationRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_REGISTRATIONS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile);

        ShowEventRegistrationRepository newRepo = CsvShowEventRegistrationRepository.importData(reader);
        reader.close();

        String key2 = "2017-06-04_FLEECESHOW_Deelnemer 3_8888";
        ShowEventRegistration showEventRegistration2 = newRepo.getShowEventRegistrationByKeySet(key2);
        assertNotNull(showEventRegistration2);
        assertEquals(210, showEventRegistration2.getShowClassCode());

    }

    @Test
    public void importEmptyFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_REGISTRATIONS_importEmpty.csv");

        Reader reader = new FileReader(importFile);
        ShowEventRegistrationRepository repo = CsvShowEventRegistrationRepository.importData(reader);
        reader.close();
        assertEquals(0,repo.getAllShowEventRegistrations().size());
    }

    @Test
    public void importFileWithOnlyHeader() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_REGISTRATIONS_importOnlyHeader.csv");

        Reader reader = new FileReader(importFile);
        ShowEventRegistrationRepository repo = CsvShowEventRegistrationRepository.importData(reader);
        reader.close();
        assertEquals(0,repo.getAllShowEventRegistrations().size());
    }
}


