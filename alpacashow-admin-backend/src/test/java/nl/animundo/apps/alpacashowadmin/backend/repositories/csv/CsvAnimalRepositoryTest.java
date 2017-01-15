package nl.animundo.apps.alpacashowadmin.backend.repositories.csv;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class CsvAnimalRepositoryTest {

    final String workingDir = System.getProperty("user.dir");
    final String testFileDir = "/src/test/resources/csv/";


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void importExportAnimalsToFile() throws IOException {

        File importFile = new File(workingDir + testFileDir + "ANIMALS_import.csv");
        File exportFile = new File(workingDir + testFileDir + "ANIMALS_export.csv");

        if (exportFile.exists()) {
            exportFile.delete();
        }

        assertTrue(importFile.isFile() && importFile.exists() && importFile.canRead());
        Reader reader = new FileReader(importFile) ;

        AnimalRepository repo = CsvAnimalRepository.importData(reader);
        reader.close();
        assertEquals(3, repo.getAllAnimals().size());

        String key = "12346";
        Animal animal = repo.getAnimalByKeySet(key);
        assertNotNull(animal);
        assertEquals("My Alpaca 2", animal.getName());
        assertEquals("HUACAYA", animal.getBreed().toString());
        assertEquals("FEMALE", animal.getSex().toString());
        assertEquals("FANCY", animal.getColor().toString());
        assertEquals("2016-05-08", animal.getDateOfBirth().toString());
        assertEquals("BAF12304", animal.getRegistration());
        assertEquals("My father", animal.getSire());
        assertEquals("My mothertoo", animal.getDam());

        String name            = "Alpie";
        BreedClass breed       = BreedClass.HUACAYA;
        SexClass sex           = SexClass.FEMALE;
        ColorClass color       = ColorClass.WHITE;
        LocalDate dateOfBirth  = LocalDate.of(2015, 10, 23);
        String microchip       = "982000123169930";
        String registration    = "BAF12345";
        String sire            = "Alpaca father";
        String dam             = "Alpaca mother";

        repo.add(new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam));
        assertEquals(4, repo.getAllAnimals().size());

        repo.delete("12345");
        assertEquals(3, repo.getAllAnimals().size());

        File newExportFile = new File(workingDir + testFileDir + "ANIMALS_export.csv");
        FileWriter writer = new FileWriter(newExportFile);
        CsvAnimalRepository.exportData(writer, repo);
        writer.flush();
        writer.close();

        File newImportFile = new File(workingDir + testFileDir + "ANIMALS_export.csv");

        assertTrue(newImportFile.isFile() && newImportFile.exists() && newImportFile.canRead());
        reader = new FileReader(newImportFile) ;

        AnimalRepository newRepo = CsvAnimalRepository.importData(reader);
        reader.close();
        assertEquals(3, newRepo.getAllAnimals().size());

        String key2 = "982000123169930";
        Animal animal2 = newRepo.getAnimalByKeySet(key2);
        assertNotNull(animal2);
        assertEquals("BAF12345", animal2.getRegistration());

    }
}
