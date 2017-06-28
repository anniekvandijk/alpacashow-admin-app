package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addAnimal() {

        String id              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String name            = "Animal";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(id, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.add(id, animal);

        assertEquals("SURI", animalRepository.getById(id).getBreed().toString());
    }

    @Test
    public void updateAnimal()
    {
        String id              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String name            = "Animal";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "1234567890";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(id, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.update(id, animal);

        assertEquals("1234567890", animalRepository.getById(id).getMicrochip().toString());
    }

    @Test
    public void deleteAnimal() {

        String id              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(id, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.add(id, animal);

        assertEquals(1, animalRepository.getAll().size());

        assertEquals("Animal to delete", animalRepository.getById(id).getName());

        animalRepository.delete(id);

        assertEquals(0, animalRepository.getAll().size());
    }

    @Test
    public void deleteAll()
    {
        String id1              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String id2              = "555894e5-b2bb-4dd2-b9e1-a98fe3274053";
        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal1 = new Animal(id1, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Animal animal2 = new Animal(id2, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.add(id1, animal1);
        animalRepository.add(id2, animal2);

        assertEquals(2, animalRepository.getAll().size());

        animalRepository.deleteAll();

        assertEquals(0, animalRepository.getAll().size());
    }

    @Test
    public void deleteAnimalWithNotKnownId() {

        exception.expect(NullPointerException.class);

        String id              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(id, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.add(id, animal);

        assertEquals(1, animalRepository.getAll().size());

        String key = "Not known key";
        animalRepository.delete(key);

        assertEquals(1, animalRepository.getAll().size());
        assertEquals(null, animalRepository.delete(key).toString());

    }

    @Test
    public void getNotKnownAnimal() {

        exception.expect(NullPointerException.class);

        String id              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(id, name,breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.add(id, animal);

        String key = "98754";

        animalRepository.getById(key).getName();
    }

    @Test
    public void getAllAnimalsById() {

        String id1              = "1f7eb2e8-69b0-42f2-ac25-950e14465b16";
        String id2              = "1f7eb2e8-69b0-42f2-ac25-950e14465b17";
        String name            = "Animal";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip1       = "123456789";
        String microchip2       = "987654321";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal1 = new Animal(id1, name,breedClass, sexClass, colorClass, dateOfBirth, microchip1, registration, sire, dam);
        Animal animal2 = new Animal(id2, name,breedClass, sexClass, colorClass, dateOfBirth, microchip2, registration, sire, dam);
        Repository<Animal> animalRepository = new Repository<>();

        animalRepository.add(id1, animal1);
        animalRepository.add(id2, animal2);

        assertEquals(2, animalRepository.getAllById().size());
        assertTrue(animalRepository.getAllById().contains("1f7eb2e8-69b0-42f2-ac25-950e14465b16"));
        assertTrue(animalRepository.getAllById().contains("1f7eb2e8-69b0-42f2-ac25-950e14465b17"));
    }
}


