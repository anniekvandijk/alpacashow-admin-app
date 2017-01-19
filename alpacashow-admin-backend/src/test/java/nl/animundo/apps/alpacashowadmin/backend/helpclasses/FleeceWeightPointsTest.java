package nl.animundo.apps.alpacashowadmin.backend.helpclasses;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.helpclasses.FleeceWeightPoints;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class FleeceWeightPointsTest {

    private BreedClass breed;
    private AgeClass ageClass;
    private float cleanFleeceWeight;
    private float weightPoints;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void FleeceWeightPoint() {

        breed               = BreedClass.HUACAYA_FLEECE;
        ageClass            = AgeClass.JUNIOR;
        cleanFleeceWeight   = 1.5f;
        weightPoints        = 9.0f;

        FleeceWeightPoints fleeceWeightPoints = new FleeceWeightPoints(breed, ageClass,cleanFleeceWeight,weightPoints);

        assertEquals(breed, fleeceWeightPoints.getBreed());
        assertEquals(ageClass, fleeceWeightPoints.getAgeClass());
        assertEquals(cleanFleeceWeight, fleeceWeightPoints.getCleanFleeceWeight(), 0.05);
        assertEquals(weightPoints, fleeceWeightPoints.getWeightPoints(), 0.05);
    }
}
