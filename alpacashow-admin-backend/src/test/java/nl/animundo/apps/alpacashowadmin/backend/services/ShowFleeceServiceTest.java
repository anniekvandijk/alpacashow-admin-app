package nl.animundo.apps.alpacashowadmin.backend.services;

import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.domain.AnimalShowDetail;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void getCleanFleeceWeightPoints () {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 5, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = null;
        breed = BreedClass.HUACAYA_FLEECE;
        cleanFleeceWeightPoints = 8.0f;

        Animal animal = new Animal("Animal", breed, SexClass.FEMALE, ColorClass.WHITE, dateOfBirth,
                "1", null, "dad", "mom", new AnimalShowDetail(sheerDate, beforeSheerDate));

        assertEquals(cleanFleeceWeightPoints, ShowFleeceService.getCleanFleeceWeightPoints(animal,fleeceWeight), delta);
    }

    @Test
    public void TestOfSubMethods () {

        fleeceWeight = 1.567f;
        dateOfBirth = LocalDate.of(2012, 5, 13);
        sheerDate = LocalDate.of(2013, 5, 25);
        beforeSheerDate = LocalDate.of(2012, 5, 13);
        breed = BreedClass.HUACAYA_FLEECE;
        fleeceGrowthInDays = 377;
        cleanFleeceWeight = 1.5f;
        cleanFleeceWeightPoints = 8.0f;

        assertEquals(fleeceGrowthInDays,ShowFleeceService.fleeceGrowthInDays(sheerDate,beforeSheerDate));
        assertEquals(cleanFleeceWeight, ShowFleeceService.fleeceWeightCorrection(fleeceGrowthInDays, fleeceWeight), delta);
        assertEquals(cleanFleeceWeightPoints,ShowFleeceService.calculateFleeceWeightPoints(breed, sheerDate, dateOfBirth, fleeceWeight), delta);
    }
}
