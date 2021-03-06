package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
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

    ShowFleeceService showFleeceService = new ShowFleeceService();

    float delta = 0.05f;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public ShowFleeceServiceTest() throws IOException {
    }

    @Test
    public void getCleanFleeceWeightPointsWithoutBeforeSheerDate () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = null;
        breed = BreedClass.HUACAYA_FLEECE;
        cleanFleeceWeightPoints = 12.5f;

        assertEquals(cleanFleeceWeightPoints, showFleeceService.getCleanFleeceWeightPoints(dateOfBirth, sheerDate, beforeSheerDate, breed, fleeceWeight), 0);
    }

    @Test
    public void getCleanFleeceWeightPointsWithBeforeSheerDate () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 8, 13);;
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeightPoints = 12.0f;

        assertEquals(cleanFleeceWeightPoints, showFleeceService.getCleanFleeceWeightPoints(dateOfBirth, sheerDate, beforeSheerDate, breed, fleeceWeight), 0);
    }

    @Test
    public void fleeceGrowthInDays () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 5, 13);
        breed = BreedClass.SURI_FLEECE;
        fleeceGrowthInDays = 377;

        assertEquals(fleeceGrowthInDays,showFleeceService.fleeceGrowthInDays(dateOfBirth, sheerDate, beforeSheerDate));
    }

    @Test
    public void fleeceGrowthInDays2 () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 7, 30);
        breed = BreedClass.SURI_FLEECE;
        fleeceGrowthInDays = 275;

        assertEquals(fleeceGrowthInDays,showFleeceService.fleeceGrowthInDays(dateOfBirth, sheerDate, beforeSheerDate));
    }

    @Test
    public void fleeceWeightCorrection () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 4, 30);
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeight = 1.6f;

        assertEquals(cleanFleeceWeight, showFleeceService.fleeceWeightCorrection(dateOfBirth, sheerDate, beforeSheerDate, fleeceWeight), 0.05f);
    }

    @Test
    public void fleeceWeightCorrection2 () throws IOException {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 8, 13);
        sheerDate = LocalDate.of(2013, 5, 1);
        beforeSheerDate = LocalDate.of(2012, 7, 30);
        breed = BreedClass.SURI_FLEECE;
        cleanFleeceWeight = 2.1f;

        assertEquals(cleanFleeceWeight, showFleeceService.fleeceWeightCorrection(dateOfBirth, sheerDate, beforeSheerDate, fleeceWeight), 0.05f);
    }
}
