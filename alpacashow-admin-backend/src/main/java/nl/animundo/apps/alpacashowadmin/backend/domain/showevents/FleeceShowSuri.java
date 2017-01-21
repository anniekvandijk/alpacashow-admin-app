package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeSexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class FleeceShowSuri extends FleeceShow {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private float finessAndHandle; // 20
    private float uniformityOfMicron; //10
    private float uniformityOfLenght; // 10
    private float uniformityOfColor; // 5
    private float styleAndCharacter; // 10
    private float desity; // 5
    private float lusture; // 15
    private float lackOfGuardHair; // 5
    private float lackOfImpurities; // 5
    private float cleanFleeceWeight; // 15
    private float total; // 100

    public FleeceShowSuri(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                          final LocalDate dateOfBirth, final BreedClass breed, final AgeSexClass ageClass, final SexClass sex, final ColorClass color,
                          final int showClass, final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                          final int fleeceGrowthInDays, final float fleeceWeightCorrection, final float finessAndHandle, final float uniformityOfMicron,
                          final float uniformityOfLenght, final float uniformityOfColor, final float styleAndCharacter, final float desity,
                          final float lusture, final float lackOfGuardHair, final float lackOfImpurities, final float cleanFleeceWeight, final float total) {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, ageClass, sex, color,
                showClass, sheerDate, beforeSheerdate, fleeceWeight, fleeceGrowthInDays, fleeceWeightCorrection);
        this.finessAndHandle = finessAndHandle;
        this.uniformityOfMicron = uniformityOfMicron;
        this.uniformityOfLenght = uniformityOfLenght;
        this.uniformityOfColor = uniformityOfColor;
        this.styleAndCharacter = styleAndCharacter;
        this.desity = desity;
        this.lusture = lusture;
        this.lackOfGuardHair = lackOfGuardHair;
        this.lackOfImpurities = lackOfImpurities;
        this.cleanFleeceWeight = cleanFleeceWeight;
        this.total = total;
    }

    public float getFinessAndHandle() {
        return finessAndHandle;
    }

    public float getUniformityOfMicron() {
        return uniformityOfMicron;
    }

    public float getUniformityOfLenght() {
        return uniformityOfLenght;
    }

    public float getUniformityOfColor() {
        return uniformityOfColor;
    }

    public float getStyleAndCharacter() {
        return styleAndCharacter;
    }

    public float getDesity() {
        return desity;
    }

    public float getLusture() {
        return lusture;
    }

    public float getLackOfGuardHair() {
        return lackOfGuardHair;
    }

    public float getLackOfImpurities() {
        return lackOfImpurities;
    }

    public float getCleanFleeceWeight() {
        return cleanFleeceWeight;
    }

    public float getTotal() {
        total = finessAndHandle +
                uniformityOfMicron +
                uniformityOfLenght +
                uniformityOfColor +
                styleAndCharacter +
                desity +
                lusture +
                lackOfGuardHair +
                lackOfImpurities +
                cleanFleeceWeight;
        return total;
    }
}
