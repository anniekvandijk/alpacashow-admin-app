package nl.animundo.apps.alpacashowadmin.backend.helpclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FleeceWeightPoints {
    private static Logger logger = LoggerFactory.getLogger(FleeceWeightPoints.class);

    private BreedClass breed;
    private AgeClass ageClass;
    private float cleanFleeceWeight;
    private float weightPoints;

    @JsonCreator
    public FleeceWeightPoints(@JsonProperty("breed") final BreedClass breed, @JsonProperty("ageClass") final AgeClass ageClass,
                              @JsonProperty("cleanFleeceWeight") final float cleanFleeceWeight, @JsonProperty("weightPoints") final float weightPoints)
    {
        this.breed = breed;
        this.ageClass = ageClass;
        this.cleanFleeceWeight = cleanFleeceWeight;
        this.weightPoints = weightPoints;
    }

    public BreedClass getBreed() {
        return breed;
    }

    public AgeClass getAgeClass() {
        return ageClass;
    }

    public float getCleanFleeceWeight() {
        return cleanFleeceWeight;
    }

    public float getWeightPoints() {
        return weightPoints;
    }
}
