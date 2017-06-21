package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowFleeceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;

public class FleeceShowSuri extends FleeceShow {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalDetail.class);
    private ShowFleeceService showFleeceService = new ShowFleeceService();

    private float finessAndHandlePoints; // 20
    private float uniformityOfMicronPoints; //10
    private float uniformityOfLenghtPoints; // 10
    private float uniformityOfColorPoints; // 5
    private float styleAndCharacterPoints; // 10
    private float desityPoints; // 5
    private float lusturePoints; // 15
    private float lackOfGuardHairPoints; // 5
    private float lackOfImpuritiesPoints; // 5
    private float cleanFleeceWeightPoints; // 15
    private float totalPoints; // 100

    public FleeceShowSuri(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                          final LocalDate dateOfBirth, final BreedClass breed, final SexClass sex, final ColorClass color,
                          final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                          final float finessAndHandlePoints, final float uniformityOfMicronPoints,
                          final float uniformityOfLenghtPoints, final float uniformityOfColorPoints, final float styleAndCharacterPoints, final float desityPoints,
                          final float lusturePoints, final float lackOfGuardHairPoints, final float lackOfImpuritiesPoints) throws IOException {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, sex, color,
                sheerDate, beforeSheerdate, fleeceWeight);
        this.finessAndHandlePoints = finessAndHandlePoints;
        this.uniformityOfMicronPoints = uniformityOfMicronPoints;
        this.uniformityOfLenghtPoints = uniformityOfLenghtPoints;
        this.uniformityOfColorPoints = uniformityOfColorPoints;
        this.styleAndCharacterPoints = styleAndCharacterPoints;
        this.desityPoints = desityPoints;
        this.lusturePoints = lusturePoints;
        this.lackOfGuardHairPoints = lackOfGuardHairPoints;
        this.lackOfImpuritiesPoints = lackOfImpuritiesPoints;
        cleanFleeceWeightPoints = showFleeceService.getCleanFleeceWeightPoints(dateOfBirth, sheerDate, beforeSheerdate, breed, fleeceWeight);
        totalPoints = finessAndHandlePoints +
                uniformityOfMicronPoints +
                uniformityOfLenghtPoints +
                uniformityOfColorPoints +
                styleAndCharacterPoints +
                desityPoints +
                lusturePoints +
                lackOfGuardHairPoints +
                lackOfImpuritiesPoints +
                cleanFleeceWeightPoints;
    }

    private FleeceShowSuri(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                          final LocalDate dateOfBirth, final BreedClass breed, final SexClass sex, final ColorClass color,
                          final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                          final float finessAndHandlePoints, final float uniformityOfMicronPoints,
                          final float uniformityOfLenghtPoints, final float uniformityOfColorPoints, final float styleAndCharacterPoints, final float desityPoints,
                          final float lusturePoints, final float lackOfGuardHairPoints, final float lackOfImpuritiesPoints, final float cleanFleeceWeightPoints, final float totalPoints) throws IOException {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, sex, color,
                sheerDate, beforeSheerdate, fleeceWeight);
        this.finessAndHandlePoints = finessAndHandlePoints;
        this.uniformityOfMicronPoints = uniformityOfMicronPoints;
        this.uniformityOfLenghtPoints = uniformityOfLenghtPoints;
        this.uniformityOfColorPoints = uniformityOfColorPoints;
        this.styleAndCharacterPoints = styleAndCharacterPoints;
        this.desityPoints = desityPoints;
        this.lusturePoints = lusturePoints;
        this.lackOfGuardHairPoints = lackOfGuardHairPoints;
        this.lackOfImpuritiesPoints = lackOfImpuritiesPoints;
        this.cleanFleeceWeightPoints = cleanFleeceWeightPoints;
        this.totalPoints = totalPoints;
    }

    public float getFinessAndHandlePoints() {
        return finessAndHandlePoints;
    }

    public float getUniformityOfMicronPoints() {
        return uniformityOfMicronPoints;
    }

    public float getUniformityOfLenghtPoints() {
        return uniformityOfLenghtPoints;
    }

    public float getUniformityOfColorPoints() {
        return uniformityOfColorPoints;
    }

    public float getStyleAndCharacterPoints() {
        return styleAndCharacterPoints;
    }

    public float getDesityPoints() {
        return desityPoints;
    }

    public float getLusturePoints() {
        return lusturePoints;
    }

    public float getLackOfGuardHairPoints() {
        return lackOfGuardHairPoints;
    }

    public float getLackOfImpuritiesPoints() {
        return lackOfImpuritiesPoints;
    }

    public float getCleanFleeceWeightPoints() { return cleanFleeceWeightPoints; }

    public float getTotalPoints() { return totalPoints; }
}
