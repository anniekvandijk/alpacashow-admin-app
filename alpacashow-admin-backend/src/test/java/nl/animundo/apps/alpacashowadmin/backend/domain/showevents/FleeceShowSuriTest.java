package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.BreedClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ColorClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.SexClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class FleeceShowSuriTest {

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
    private float styleAndCharacterPoints; // 10
    private float desityPoints; // 5
    private float lusturePoints; // 15
    private float lackOfGuardHairPoints; // 5
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
        breed = BreedClass.SURI_FLEECE;
        sex = SexClass.FEMALE;
        color = ColorClass.BLACK;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerdate = null;
        fleeceWeight = 7.0f;
        finessAndHandlePoints = 20f;
        uniformityOfMicronPoints = 10f;
        uniformityOfLenghtPoints = 10f;
        uniformityOfColorPoints = 5f;
        styleAndCharacterPoints = 10f;
        desityPoints = 5f;
        lusturePoints = 15f;
        lackOfGuardHairPoints = 5f;
        lackOfImpuritiesPoints = 5f;

        FleeceShowSuri fleeceShowSuri = new FleeceShowSuri(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth,
                breed, sex, color, sheerDate, beforeSheerdate, fleeceWeight, finessAndHandlePoints,
                uniformityOfMicronPoints, uniformityOfLenghtPoints, uniformityOfColorPoints, styleAndCharacterPoints, desityPoints, lusturePoints, lackOfGuardHairPoints, lackOfImpuritiesPoints);

        assertEquals(showEventKey, fleeceShowSuri.getShowEventKey());
        assertEquals(participantKey, fleeceShowSuri.getParticipantKey());
        assertEquals(animalKey, fleeceShowSuri.getAnimalKey());
        assertEquals(startNumber, fleeceShowSuri.getStartNumber());
        assertEquals(dateOfBirth, fleeceShowSuri.getDateOfBirth());
        assertEquals(present, fleeceShowSuri.isPresent());
        assertEquals(breed, fleeceShowSuri.getBreed());
        assertEquals(AgeClass.INTERMEDIATE, fleeceShowSuri.getAgeClass());
        assertEquals(sex, fleeceShowSuri.getSex());
        assertEquals(color, fleeceShowSuri.getColor());
        assertEquals(424, fleeceShowSuri.getShowClass());
        assertEquals(sheerDate, fleeceShowSuri.getSheerDate());
        assertEquals(beforeSheerdate, fleeceShowSuri.getBeforeSheerdate());
        assertEquals(fleeceWeight, fleeceShowSuri.getFleeceWeight(), delta);
        assertEquals(385, fleeceShowSuri.getFleeceGrowthInDays());
        assertEquals(5f, fleeceShowSuri.getFleeceWeightCorrection(), delta);
        assertEquals(15.0f, fleeceShowSuri.getCleanFleeceWeightPoints(), delta);
        assertEquals(finessAndHandlePoints, fleeceShowSuri.getFinessAndHandlePoints(), delta);
        assertEquals(uniformityOfMicronPoints, fleeceShowSuri.getUniformityOfMicronPoints(), delta);
        assertEquals(uniformityOfLenghtPoints, fleeceShowSuri.getUniformityOfLenghtPoints(), delta);
        assertEquals(uniformityOfColorPoints, fleeceShowSuri.getUniformityOfColorPoints(), delta);
        assertEquals(styleAndCharacterPoints, fleeceShowSuri.getStyleAndCharacterPoints(), delta);
        assertEquals(desityPoints, fleeceShowSuri.getDesityPoints(), delta);
        assertEquals(lusturePoints, fleeceShowSuri.getLusturePoints(), delta);
        assertEquals(lackOfGuardHairPoints, fleeceShowSuri.getLackOfGuardHairPoints(), delta);
        assertEquals(lackOfImpuritiesPoints, fleeceShowSuri.getLackOfImpuritiesPoints(), delta);
        assertEquals(100f, fleeceShowSuri.getTotalPoints(), delta);
    }
}
