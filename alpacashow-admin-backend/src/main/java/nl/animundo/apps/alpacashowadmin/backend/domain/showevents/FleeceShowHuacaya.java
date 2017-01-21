package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimal;
import nl.animundo.apps.alpacashowadmin.backend.services.ShowFleeceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;

public class FleeceShowHuacaya extends FleeceShow {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimal.class);

    private float finessAndHandle; // 20
    private float uniformityOfMicron; //10
    private float uniformityOfLenght; // 10
    private float uniformityOfColor; // 5
    private float character; // 10
    private float stapleTypeDesity; // 5
    private float brightness; // 10
    private float lackOfGuardHair; // 10
    private float lackOfImpurities; // 5
    private float cleanFleeceWeight; // 15
    private float total; // 100

    public FleeceShowHuacaya(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                             final LocalDate dateOfBirth, final BreedClass breed, final SexClass sex, final ColorClass color,
                             final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                             final float finessAndHandle, final float uniformityOfMicron,
                             final float uniformityOfLenght, final float uniformityOfColor, final float character, final float stapleTypeDesity,
                             final float brightness, final float lackOfGuardHair, final float lackOfImpurities) throws IOException {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, sex, color,
                sheerDate, beforeSheerdate, fleeceWeight);
        this.finessAndHandle = finessAndHandle;
        this.uniformityOfMicron = uniformityOfMicron;
        this.uniformityOfLenght = uniformityOfLenght;
        this.uniformityOfColor = uniformityOfColor;
        this.character = character;
        this.stapleTypeDesity = stapleTypeDesity;
        this.brightness = brightness;
        this.lackOfGuardHair = lackOfGuardHair;
        this.lackOfImpurities = lackOfImpurities;
        cleanFleeceWeight = ShowFleeceService.getCleanFleeceWeightPoints(dateOfBirth, sheerDate, beforeSheerdate, breed, fleeceWeight);
        total = finessAndHandle +
                uniformityOfMicron +
                uniformityOfLenght +
                uniformityOfColor +
                character +
                stapleTypeDesity +
                brightness +
                lackOfGuardHair +
                lackOfImpurities +
                cleanFleeceWeight;
    }

    private FleeceShowHuacaya(final String showEventKey, final String participantKey, final String animalKey, final boolean present, final int startNumber,
                             final LocalDate dateOfBirth, final BreedClass breed, final SexClass sex, final ColorClass color,
                             final LocalDate sheerDate, final LocalDate beforeSheerdate, final float fleeceWeight,
                             final float finessAndHandle, final float uniformityOfMicron,
                             final float uniformityOfLenght, final float uniformityOfColor, final float character, final float stapleTypeDesity,
                             final float brightness, final float lackOfGuardHair, final float lackOfImpurities, float cleanFleeceWeight, float total) throws IOException {
        super(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth, breed, sex, color,
                sheerDate, beforeSheerdate, fleeceWeight);
        this.finessAndHandle = finessAndHandle;
        this.uniformityOfMicron = uniformityOfMicron;
        this.uniformityOfLenght = uniformityOfLenght;
        this.uniformityOfColor = uniformityOfColor;
        this.character = character;
        this.stapleTypeDesity = stapleTypeDesity;
        this.brightness = brightness;
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

    public float getCharacter() {
        return character;
    }

    public float getStapleTypeDesity() {
        return stapleTypeDesity;
    }

    public float getBrightness() {
        return brightness;
    }

    public float getLackOfGuardHair() {
        return lackOfGuardHair;
    }

    public float getLackOfImpurities() {
        return lackOfImpurities;
    }

    public float getCleanFleeceWeight() { return cleanFleeceWeight; }

    public float getTotal() { return total; }
}
