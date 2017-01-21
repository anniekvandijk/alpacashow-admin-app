package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.AnimalShowDetail;
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
    String cleanFleeceWeight;
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

        assertEquals(cleanFleeceWeightPoints, ShowFleeceService.getCleanFleeceWeightPoints(dateOfBirth, sheerDate, beforeSheerDate, breed, fleeceWeight), 0);
    }

    @Test
    public void getCleanFleeceWeightPointsWithBeforeSheerDate () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 8, 13);;
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeightPoints = 12.0f;

        assertEquals(cleanFleeceWeightPoints, ShowFleeceService.getCleanFleeceWeightPoints(dateOfBirth, sheerDate, beforeSheerDate, breed, fleeceWeight), 0);
    }

    @Test
    public void fleeceGrowthInDays () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 5, 13);
        breed = BreedClass.SURI_FLEECE;
        fleeceGrowthInDays = 377;

        assertEquals(fleeceGrowthInDays,ShowFleeceService.fleeceGrowthInDays(dateOfBirth, sheerDate, beforeSheerDate));
    }

    @Test
    public void fleeceGrowthInDays2 () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 7, 30);
        breed = BreedClass.SURI_FLEECE;
        fleeceGrowthInDays = 275;

        assertEquals(fleeceGrowthInDays,ShowFleeceService.fleeceGrowthInDays(dateOfBirth, sheerDate, beforeSheerDate));
    }

    @Test
    public void fleeceWeightCorrection () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 4, 30);
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeight = "1.6";

        assertEquals(cleanFleeceWeight, ShowFleeceService.fleeceWeightCorrection(dateOfBirth, sheerDate, beforeSheerDate, fleeceWeight));
    }

    @Test
    public void fleeceWeightCorrection2 () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 7, 30);
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeight = "2.1";

        assertEquals(cleanFleeceWeight, ShowFleeceService.fleeceWeightCorrection(dateOfBirth, sheerDate, beforeSheerDate, fleeceWeight));
    }
}
