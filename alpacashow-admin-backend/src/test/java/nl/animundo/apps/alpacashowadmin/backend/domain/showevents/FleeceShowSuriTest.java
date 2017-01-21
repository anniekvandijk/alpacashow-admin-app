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
    private float finessAndHandle; // 20
    private float uniformityOfMicron; //10
    private float uniformityOfLenght; // 10
    private float uniformityOfColor; // 5
    private float styleAndCharacter; // 10
    private float desity; // 5
    private float lusture; // 15
    private float lackOfGuardHair; // 5
    private float lackOfImpurities; // 5
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
        finessAndHandle = 20f;
        uniformityOfMicron = 10f;
        uniformityOfLenght = 10f;
        uniformityOfColor = 5f;
        styleAndCharacter = 10f;
        desity = 5f;
        lusture = 15f;
        lackOfGuardHair = 5f;
        lackOfImpurities = 5f;

        FleeceShowSuri fleeceShowSuri = new FleeceShowSuri(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth,
                breed, sex, color, sheerDate, beforeSheerdate, fleeceWeight, finessAndHandle,
                uniformityOfMicron, uniformityOfLenght, uniformityOfColor, styleAndCharacter, desity, lusture, lackOfGuardHair, lackOfImpurities);

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
        assertEquals(15.0f, fleeceShowSuri.getCleanFleeceWeight(), delta);
        assertEquals(finessAndHandle, fleeceShowSuri.getFinessAndHandle(), delta);
        assertEquals(uniformityOfMicron, fleeceShowSuri.getUniformityOfMicron(), delta);
        assertEquals(uniformityOfLenght, fleeceShowSuri.getUniformityOfLenght(), delta);
        assertEquals(uniformityOfColor, fleeceShowSuri.getUniformityOfColor(), delta);
        assertEquals(styleAndCharacter, fleeceShowSuri.getStyleAndCharacter(), delta);
        assertEquals(desity, fleeceShowSuri.getDesity(), delta);
        assertEquals(lusture, fleeceShowSuri.getLusture(), delta);
        assertEquals(lackOfGuardHair, fleeceShowSuri.getLackOfGuardHair(), delta);
        assertEquals(lackOfImpurities, fleeceShowSuri.getLackOfImpurities(), delta);
        assertEquals(100f, fleeceShowSuri.getTotal(), delta);
    }
}
