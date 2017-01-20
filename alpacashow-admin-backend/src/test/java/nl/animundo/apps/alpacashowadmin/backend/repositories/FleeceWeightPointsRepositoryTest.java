package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventAnimal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FleeceWeightPointsRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(FleeceWeightPointsRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addFleeceWeightPoints() {

        BreedClass breed          = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "1.5";
        float weightPoints        = 9.0f;

        FleeceWeightPoints fleeceWeightPoints = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        fleeceWeightPointsRepository.add(fleeceWeightPoints);
        assertEquals(1, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        String key = "HUACAYA_FLEECE_JUNIOR_1.5";

        assertEquals(breed, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getBreed());
        assertEquals(ageClass, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getAgeClass());
        assertEquals(cleanFleeceWeight, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getCleanFleeceWeight());
        assertEquals(weightPoints, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getWeightPoints(), 0.05);
    }

    @Test
    public void addFleeceWeightPointsWithSameKey() {

        BreedClass breed          = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "1.5";
        float weightPoints1        = 9.0f;
        float weightPoints2        = 7.0f;

        FleeceWeightPoints fleeceWeightPoints1 = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints1);
        FleeceWeightPoints fleeceWeightPoints2 = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints2);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        fleeceWeightPointsRepository.add(fleeceWeightPoints1);
        fleeceWeightPointsRepository.add(fleeceWeightPoints2);

        assertEquals(1, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        String key = "HUACAYA_FLEECE_JUNIOR_1.5";

        assertEquals(breed, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getBreed());
        assertEquals(ageClass, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getAgeClass());
        assertEquals(cleanFleeceWeight, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getCleanFleeceWeight());
        assertEquals(weightPoints2, fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getWeightPoints(), 0.05);

    }

    @Test
    public void deleteFleeceWeightPoints() {

        BreedClass breed          = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "1.5";
        float weightPoints1        = 9.0f;
        float weightPoints2        = 7.0f;

        FleeceWeightPoints fleeceWeightPoints1 = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints1);
        FleeceWeightPoints fleeceWeightPoints2 = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints2);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        fleeceWeightPointsRepository.add(fleeceWeightPoints1);
        fleeceWeightPointsRepository.add(fleeceWeightPoints2);

        assertEquals(1, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        String key = "HUACAYA_FLEECE_JUNIOR_1.5";

        fleeceWeightPointsRepository.delete(key);

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

    }

    @Test
    public void deleteFleeceWeightPointsWithNotKnownKey() {

        exception.expect(NullPointerException.class);

        BreedClass breed          = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "1.5";
        float weightPoints        = 9.0f;

        FleeceWeightPoints fleeceWeightPoints = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        fleeceWeightPointsRepository.add(fleeceWeightPoints);
        assertEquals(1, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        String key = "HUACAYA_FLEECE_JUNIOR_1.54";

        fleeceWeightPointsRepository.delete(key);

        assertEquals(1, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());
        assertEquals(null, fleeceWeightPointsRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownFleeceWeightPoints() {

        exception.expect(NullPointerException.class);

        BreedClass breed          = BreedClass.HUACAYA_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "1.5";
        float weightPoints        = 9.0f;

        FleeceWeightPoints fleeceWeightPoints = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        fleeceWeightPointsRepository.add(fleeceWeightPoints);
        assertEquals(1, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        String key = "HUACAYA_FLEECE_JUNIOR_1.54";

        fleeceWeightPointsRepository.getFleeceWeightPointsByKeySet(key).getBreed();

    }

    @Test
    public void getAllFleeceWeightPointsByKeySet() {

        BreedClass breed1          = BreedClass.HUACAYA_FLEECE;
        BreedClass breed2          = BreedClass.SURI_FLEECE;
        AgeClass ageClass         = AgeClass.JUNIOR;
        String cleanFleeceWeight   = "1.5";
        float weightPoints        = 9.0f;

        FleeceWeightPoints fleeceWeightPoints1 = new FleeceWeightPoints(breed1, ageClass,cleanFleeceWeight,weightPoints);
        FleeceWeightPoints fleeceWeightPoints2 = new FleeceWeightPoints(breed2, ageClass,cleanFleeceWeight,weightPoints);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        assertEquals(0, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());

        fleeceWeightPointsRepository.add(fleeceWeightPoints1);
        fleeceWeightPointsRepository.add(fleeceWeightPoints2);

        assertEquals(2, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());
        assertTrue(fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet().contains("HUACAYA_FLEECE_JUNIOR_1.5"));
        assertTrue(fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet().contains("SURI_FLEECE_JUNIOR_1.5"));

    }

    @Test
    public void getAllFleeceWeightPointsSorted() {

        BreedClass breed1 = BreedClass.HUACAYA_FLEECE;
        BreedClass breed2 = BreedClass.SURI_FLEECE;
        AgeClass ageClass = AgeClass.JUNIOR;
        String cleanFleeceWeight = "1.5";
        float weightPoints = 9.0f;

        FleeceWeightPoints fleeceWeightPoints1 = new FleeceWeightPoints(breed1, ageClass, cleanFleeceWeight, weightPoints);
        FleeceWeightPoints fleeceWeightPoints2 = new FleeceWeightPoints(breed2, ageClass, cleanFleeceWeight, weightPoints);

        FleeceWeightPointsRepository fleeceWeightPointsRepository = new FleeceWeightPointsRepository();

        fleeceWeightPointsRepository.add(fleeceWeightPoints1);
        fleeceWeightPointsRepository.add(fleeceWeightPoints2);

        assertEquals(2, fleeceWeightPointsRepository.getAllFleeceWeightPointsSorted().size());
    }
}


