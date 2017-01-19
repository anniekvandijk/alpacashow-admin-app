package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventAnimal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventAnimalRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CsvShowEventAnimalRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportShowEventAnimalsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile);

        ShowEventAnimalRepository repo = CsvShowEventAnimalRepository.importData(reader);
        reader.close();
        assertEquals(5, repo.getAllShowEventAnimals().size());

        String key = "2017-04-01_MALE_PROGENY_SHOW_Deelnemer 1_982000123169930";
        ShowEventAnimal showEventAnimal = repo.getShowEventAnimalByKeySet(key);
        assertNotNull(showEventAnimal);
        assertEquals("2017-04-01_MALE_PROGENY_SHOW", showEventAnimal.getShowEventKey());
        assertEquals("Deelnemer 1", showEventAnimal.getParticipantKey());
        assertEquals("982000123169930", showEventAnimal.getAnimalKey());
        assertEquals("2016-05-01", showEventAnimal.getSheerDate().toString());
        assertEquals(null, showEventAnimal.getBeforeSheerDate());

        String key2 = "2017-05-01_HALTERSHOW_Deelnemer 2_12347";
        ShowEventAnimal showEventAnimal2 = repo.getShowEventAnimalByKeySet(key2);
        assertEquals("2016-04-30", showEventAnimal2.getSheerDate().toString());
        assertEquals("2015-05-02", showEventAnimal2.getBeforeSheerDate().toString());

        String key3 = "2017-05-01_HALTERSHOW_Deelnemer 1_982000123169930";
        ShowEventAnimal showEventAnimal3 = repo.getShowEventAnimalByKeySet(key3);
        assertEquals(null, showEventAnimal3.getSheerDate());
        assertEquals(null, showEventAnimal3.getBeforeSheerDate());

        String showEventKey = "2017-06-04_FLEECESHOW";
        String participantKey = "Deelnemer 3";
        String animalKey = "8888";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 210;
        LocalDate sheerDate = LocalDate.of(2016, 5, 3);
        LocalDate beforeSheerDate = null;

        repo.add(new ShowEventAnimal(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate));
        repo.delete("2017-05-01_HALTERSHOW_Deelnemer 2_12347");

        File newExportFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvShowEventAnimalRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile);

        ShowEventAnimalRepository newRepo = CsvShowEventAnimalRepository.importData(reader);
        reader.close();

        String key4 = "2017-06-04_FLEECESHOW_Deelnemer 3_8888";
        ShowEventAnimal showEventAnimal4 = newRepo.getShowEventAnimalByKeySet(key4);
        assertNotNull(showEventAnimal4);
        assertEquals("8888", showEventAnimal4.getAnimalKey());

    }

    @Test
    public void importEmptyFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALS_importEmpty.csv");

        Reader reader = new FileReader(importFile);
        ShowEventAnimalRepository repo = CsvShowEventAnimalRepository.importData(reader);
        reader.close();
        assertEquals(0,repo.getAllShowEventAnimals().size());
    }

    @Test
    public void importFileWithOnlyHeader() throws IOException {

        File importFile = new File(workingDir + testFileDir + "SHOWEVENTS_ANIMALS_importOnlyHeader.csv");

        Reader reader = new FileReader(importFile);
        ShowEventAnimalRepository repo = CsvShowEventAnimalRepository.importData(reader);
        reader.close();
        assertEquals(0,repo.getAllShowEventAnimals().size());
    }
}


