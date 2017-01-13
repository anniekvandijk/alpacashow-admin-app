package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.Participant;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(AnimalRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addAnimal() {

        String name            = "Animal";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        AnimalRepository animalRepository = new AnimalRepository();

        animalRepository.add(animal);

        String key = "123456789";
        assertEquals("SURI", animalRepository.getAnimalByKeySet(key).getBreed().toString());
    }

    @Test
    public void AddAnimalWithSameKey() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Animal already exists");

        String name            = "Animal";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal1 = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        Animal animal2 = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        AnimalRepository animalRepository = new AnimalRepository();

        animalRepository.add(animal1);
        animalRepository.add(animal2);
    }

    @Test
    public void deleteAnimal() {

        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        AnimalRepository animalRepository = new AnimalRepository();

        animalRepository.add(animal);

        assertEquals(1, animalRepository.getAllAnimals().size());
        String key = "123456789";
        assertEquals("Animal to delete", animalRepository.getAnimalByKeySet(key).getName());

        animalRepository.delete(key);

        assertEquals(0, animalRepository.getAllAnimals().size());
    }

    @Test
    public void deleteAnimalWithNotKnownKey() {

        exception.expect(NullPointerException.class);

        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        AnimalRepository animalRepository = new AnimalRepository();

        animalRepository.add(animal);

        assertEquals(1, animalRepository.getAllAnimals().size());

        String key = "Not known key";
        animalRepository.delete(key);

        assertEquals(1, animalRepository.getAllAnimals().size());
        assertEquals(null, animalRepository.delete(key).toString());

    }

    @Test
    public void getNotKnownAnimal() {

        exception.expect(NullPointerException.class);

        String name            = "Animal to delete";
        BreedClass breedClass  = BreedClass.SURI;
        SexClass sexClass      = SexClass.MALE;
        ColorClass colorClass  = ColorClass.BROWN;
        LocalDate dateOfBirth  = LocalDate.of(2014, 6, 12);
        String microchip       = "123456789";
        String registration    = "BAF12345";
        String sire            = "father";
        String dam             = "mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
        AnimalRepository animalRepository = new AnimalRepository();

        animalRepository.add(animal);

        String key = "98754";

        animalRepository.getAnimalByKeySet(key).getName();
    }

    @Test
    public void getAllAnimalsByKeySet() {

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

        Animal animal1 = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip1, registration, sire, dam);
        Animal animal2 = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip2, registration, sire, dam);
        AnimalRepository animalRepository = new AnimalRepository();

        animalRepository.add(animal1);
        animalRepository.add(animal2);

        assertEquals(2, animalRepository.getAllAnimalsByKeySet().size());
        assertTrue(animalRepository.getAllAnimalsByKeySet().contains("123456789"));
        assertTrue(animalRepository.getAllAnimalsByKeySet().contains("987654321"));
    }
}

