package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class FleeceShowHuacayaTest {

    private String showEventKey;
    private String participantKey;
    private String animalKey;
    private boolean present;
    private int startNumber;
    private LocalDate dateOfBirth;
    private BreedClass breed;
    private SexClass sex;
    private ColorClass color;
    private LocalDate sheerDate;
    private LocalDate beforeSheerdate;
    private float fleeceWeight;
    private float finessAndHandlePoints; // 20
    private float uniformityOfMicronPoints; //10
    private float uniformityOfLenghtPoints; // 10
    private float uniformityOfColorPoints; // 5
    private float characterPoints; // 10
    private float stapleTypeDesityPoints; // 5
    private float brightnessPoints; // 10
    private float lackOfGuardHairPoints; // 10
    private float lackOfImpuritiesPoints; // 5
    private float delta = 0.05f;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newFleeceShowHuacayaMaxPoints() throws IOException {

        showEventKey = "2030-06-15_FLEECESHOW";
        participantKey = "Test participant 1";
        animalKey = "Alpaca1";
        present = true;
        startNumber = 1;
        dateOfBirth = LocalDate.of(2015, 4, 12);
        breed = BreedClass.HUACAYA_FLEECE;
        sex = SexClass.FEMALE;
        color = ColorClass.BLACK;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerdate = null;
        fleeceWeight = 7.0f;
        finessAndHandlePoints = 20f;
        uniformityOfMicronPoints = 10f;
        uniformityOfLenghtPoints = 10f;
        uniformityOfColorPoints = 5f;
        characterPoints = 10f;
        stapleTypeDesityPoints = 5f;
        brightnessPoints = 10f;
        lackOfGuardHairPoints = 10f;
        lackOfImpuritiesPoints = 5f;

        FleeceShowHuacaya fleeceShowHuacaya = new FleeceShowHuacaya(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth,
                breed, sex, color, sheerDate, beforeSheerdate, fleeceWeight, finessAndHandlePoints,
                uniformityOfMicronPoints, uniformityOfLenghtPoints, uniformityOfColorPoints, characterPoints, stapleTypeDesityPoints, brightnessPoints, lackOfGuardHairPoints, lackOfImpuritiesPoints);

        assertEquals(showEventKey, fleeceShowHuacaya.getShowEventKey());
        assertEquals(participantKey, fleeceShowHuacaya.getParticipantKey());
        assertEquals(animalKey, fleeceShowHuacaya.getAnimalKey());
        assertEquals(startNumber, fleeceShowHuacaya.getStartNumber());
        assertEquals(dateOfBirth, fleeceShowHuacaya.getDateOfBirth());
        assertEquals(present, fleeceShowHuacaya.isPresent());
        assertEquals(breed, fleeceShowHuacaya.getBreed());
        assertEquals(AgeClass.INTERMEDIATE, fleeceShowHuacaya.getAgeClass());
        assertEquals(sex, fleeceShowHuacaya.getSex());
        assertEquals(color, fleeceShowHuacaya.getColor());
        assertEquals(324, fleeceShowHuacaya.getShowClass());
        assertEquals(sheerDate, fleeceShowHuacaya.getSheerDate());
        assertEquals(beforeSheerdate, fleeceShowHuacaya.getBeforeSheerdate());
        assertEquals(fleeceWeight, fleeceShowHuacaya.getFleeceWeight(), delta);
        assertEquals(385, fleeceShowHuacaya.getFleeceGrowthInDays());
        assertEquals(5f, fleeceShowHuacaya.getFleeceWeightCorrection(), delta);
        assertEquals(15.0f, fleeceShowHuacaya.getCleanFleeceWeightPoints(), delta);
        assertEquals(finessAndHandlePoints, fleeceShowHuacaya.getFinessAndHandlePoints(), delta);
        assertEquals(uniformityOfMicronPoints, fleeceShowHuacaya.getUniformityOfMicronPoints(), delta);
        assertEquals(uniformityOfLenghtPoints, fleeceShowHuacaya.getUniformityOfLenghtPoints(), delta);
        assertEquals(uniformityOfColorPoints, fleeceShowHuacaya.getUniformityOfColorPoints(), delta);
        assertEquals(characterPoints, fleeceShowHuacaya.getCharacterPoints(), delta);
        assertEquals(stapleTypeDesityPoints, fleeceShowHuacaya.getStapleTypeDesityPoints(), delta);
        assertEquals(brightnessPoints, fleeceShowHuacaya.getBrightnessPoints(), delta);
        assertEquals(lackOfGuardHairPoints, fleeceShowHuacaya.getLackOfGuardHairPoints(), delta);
        assertEquals(lackOfImpuritiesPoints, fleeceShowHuacaya.getLackOfImpuritiesPoints(), delta);
        assertEquals(100f, fleeceShowHuacaya.getTotalPoints(), delta);
    }
}
