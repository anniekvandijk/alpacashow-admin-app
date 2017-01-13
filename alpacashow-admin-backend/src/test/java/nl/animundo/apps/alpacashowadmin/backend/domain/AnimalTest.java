package nl.animundo.apps.alpacashowadmin.backend.domain;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    String name;
    BreedClass breed;
    SexClass sex;
    ColorClass color;
    LocalDate dateOfBirth;
    String microchip;
    String registration;
    String sire;
    String dam;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newAnimalWithTrim() {

        name            = "Alpacaname  ";
        breed      = BreedClass.HUACAYA;
        sex        = SexClass.FEMALE;
        color      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "   982000123169930";
        registration    = " BAF12345 ";
        sire            = "Alpaca father ";
        dam             = " Alpaca mother";

        Animal animal = new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);

        assertEquals("Alpacaname", animal.getName());
        assertEquals(BreedClass.HUACAYA, animal.getBreed());
        assertEquals(SexClass.FEMALE, animal.getSex());
        assertEquals(ColorClass.WHITE, animal.getColor());
        assertEquals(LocalDate.now().minusMonths(6), animal.getDateOfBirth());
        assertEquals("982000123169930", animal.getMicrochip());
        assertEquals("BAF12345", animal.getRegistration());
        assertEquals("Alpaca father", animal.getSire());
        assertEquals("Alpaca mother", animal.getDam());

    }

    @Test
    public void nameNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name            = "";
        breed      = BreedClass.HUACAYA;
        sex        = SexClass.FEMALE;
        color      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void nameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name            = null;
        breed      = BreedClass.HUACAYA;
        sex        = SexClass.FEMALE;
        color      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void breedNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field breed can not be empty");

        name            = "Animal";
        breed      = null;
        sex        = SexClass.FEMALE;
        color      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void sexNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field sex can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = null;
        color      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void colorNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field color can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = null;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void setDateOfBirthNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date of birth can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = null;
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void microchipNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field microchip can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = " ";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void microchipNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field microchip can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = null;
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }


    @Test
    public void sireNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field sire can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "123456789";
        registration    = "BAF12345";
        sire            = " ";
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void sireNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field sire can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "123456789";
        registration    = "BAF12345";
        sire            = null;
        dam             = "Alpaca mother";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void damNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field dam can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "123456789";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "";

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void damNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field dam can not be empty");

        name            = "Animal";
        breed      = BreedClass.SURI;
        sex        = SexClass.MALE;
        color      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "123456789";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = null;

        new Animal(name, breed, sex, color, dateOfBirth, microchip, registration, sire, dam);
    }


}
