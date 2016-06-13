package nl.animundo.apps.alpacashowadmin.backend.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 8-6-2016.
 */
public class AnimalTest {

    String name;
    BreedClass breedClass;
    SexClass sexClass;
    ColorClass colorClass;
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
        breedClass      = BreedClass.HUACAYA;
        sexClass        = SexClass.FEMALE;
        colorClass      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "   982000123169930";
        registration    = " BAF12345 ";
        sire            = "Alpaca father ";
        dam             = " Alpaca mother";

        Animal animal = new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);

        assertEquals("Alpacaname", animal.getName());
        assertEquals(BreedClass.HUACAYA, animal.getBreedClass());
        assertEquals(SexClass.FEMALE, animal.getSexClass());
        assertEquals(ColorClass.WHITE, animal.getColorClass());
        assertEquals(LocalDate.now().minusMonths(6), animal.getDateOfBirth());
        assertEquals("982000123169930", animal.getMicrochip());
        assertEquals("BAF12345", animal.getRegistration());
        assertEquals("Alpaca father", animal.getSire());
        assertEquals("Alpaca mother", animal.getDam());

    }

    @Test
    public void nameNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        name            = null;
        breedClass      = BreedClass.HUACAYA;
        sexClass        = SexClass.FEMALE;
        colorClass      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void breedClassNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field breed can not be empty");

        name            = "Animal";
        breedClass      = null;
        sexClass        = SexClass.FEMALE;
        colorClass      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void sexClassNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field sex can not be empty");

        name            = "Animal";
        breedClass      = BreedClass.SURI;
        sexClass        = null;
        colorClass      = ColorClass.WHITE;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void colorClassNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field color can not be empty");

        name            = "Animal";
        breedClass      = BreedClass.SURI;
        sexClass        = SexClass.MALE;
        colorClass      = null;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void setDateOfBirthNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field date of birth can not be empty");

        name            = "Animal";
        breedClass      = BreedClass.SURI;
        sexClass        = SexClass.MALE;
        colorClass      = ColorClass.BROWN;
        dateOfBirth     = null;
        microchip       = "982000123169930";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void microchipNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field microchip can not be empty");

        name            = "Animal";
        breedClass      = BreedClass.SURI;
        sexClass        = SexClass.MALE;
        colorClass      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = null;
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void sireNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field sire can not be empty");

        name            = "Animal";
        breedClass      = BreedClass.SURI;
        sexClass        = SexClass.MALE;
        colorClass      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "123456789";
        registration    = "BAF12345";
        sire            = null;
        dam             = "Alpaca mother";

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }

    @Test
    public void damNotNull() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field dam can not be empty");

        name            = "Animal";
        breedClass      = BreedClass.SURI;
        sexClass        = SexClass.MALE;
        colorClass      = ColorClass.BROWN;
        dateOfBirth     = LocalDate.now().minusMonths(6);
        microchip       = "123456789";
        registration    = "BAF12345";
        sire            = "Alpaca father";
        dam             = null;

        new Animal(name, breedClass, sexClass, colorClass, dateOfBirth, microchip, registration, sire, dam);
    }


}
