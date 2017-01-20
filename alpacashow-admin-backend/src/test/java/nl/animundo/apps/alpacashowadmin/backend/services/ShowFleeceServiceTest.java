package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.AnimalShowDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowFleeceServiceTest {

    LocalDate dateOfBirth;
    LocalDate sheerDate;
    LocalDate beforeSheerDate;
    BreedClass breed;
    int fleeceGrowthInDays;
    float fleeceWeight;
    float cleanFleeceWeight;
    float cleanFleeceWeightPoints;

    float delta = 0.05f;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        exception.expect(InstantiationException.class);
        exception.expectMessage("Instances of this type are forbidden!");

        Constructor<ShowFleeceService> constructor = ShowFleeceService.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);

        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (InstantiationException) e.getTargetException();
        }

        constructor.setAccessible(false);

    }

    @Test
    public void getCleanFleeceWeightPointsWithoutBeforeSheerDate () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = null;
        breed = BreedClass.HUACAYA_FLEECE;
        cleanFleeceWeightPoints = 12.5f;

        Animal animal = new Animal("Animal", breed, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth,
                "1", null, "dad", "mom", new AnimalShowDetail(sheerDate, beforeSheerDate));

        assertEquals(cleanFleeceWeightPoints, ShowFleeceService.getCleanFleeceWeightPoints(animal,fleeceWeight), delta);
    }

    @Test
    public void getCleanFleeceWeightPointsWithBeforeSheerDate () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 8, 13);;
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeightPoints = 12.0f;

        Animal animal = new Animal("Animal", breed, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth,
                "1", null, "dad", "mom", new AnimalShowDetail(sheerDate, beforeSheerDate));

        assertEquals(cleanFleeceWeightPoints, ShowFleeceService.getCleanFleeceWeightPoints(animal,fleeceWeight), delta);
    }

    @Test
    public void fleeceGrowthInDays () throws IOException {

        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 5, 13);
        fleeceGrowthInDays = 377;

        assertEquals(fleeceGrowthInDays,ShowFleeceService.fleeceGrowthInDays(sheerDate,beforeSheerDate));
    }

    @Test
    public void fleeceGrowthInDays2 () throws IOException {

        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 7, 30);
        fleeceGrowthInDays = 275;

        assertEquals(fleeceGrowthInDays,ShowFleeceService.fleeceGrowthInDays(sheerDate,beforeSheerDate));
    }

    @Test
    public void fleeceWeightCorrection () throws IOException {

        fleeceWeight = 1.567f;
        fleeceGrowthInDays = 377;
        cleanFleeceWeight = 1.5f; // 1.517122

        assertEquals(cleanFleeceWeight, ShowFleeceService.fleeceWeightCorrection(fleeceGrowthInDays, fleeceWeight), delta);
    }

    @Test
    public void fleeceWeightCorrection2 () throws IOException {

        fleeceWeight = 1.567f;
        fleeceGrowthInDays = 275;
        cleanFleeceWeight = 2.1f; // 2.0798364

        assertEquals(cleanFleeceWeight, ShowFleeceService.fleeceWeightCorrection(fleeceGrowthInDays, fleeceWeight), delta);
    }
}
