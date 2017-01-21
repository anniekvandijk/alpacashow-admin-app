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
    private float finessAndHandle; // 20
    private float uniformityOfMicron; //10
    private float uniformityOfLenght; // 10
    private float uniformityOfColor; // 5
    private float character; // 10
    private float stapleTypeDesity; // 5
    private float brightness; // 10
    private float lackOfGuardHair; // 10
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
        breed = BreedClass.HUACAYA_FLEECE;
        sex = SexClass.FEMALE;
        color = ColorClass.BLACK;
        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerdate = null;
        fleeceWeight = 7.0f;
        finessAndHandle = 20f;
        uniformityOfMicron = 10f;
        uniformityOfLenght = 10f;
        uniformityOfColor = 5f;
        character = 10f;
        stapleTypeDesity = 5f;
        brightness = 10f;
        lackOfGuardHair = 10f;
        lackOfImpurities = 5f;

        FleeceShowHuacaya fleeceShowHuacaya = new FleeceShowHuacaya(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth,
                breed, sex, color, sheerDate, beforeSheerdate, fleeceWeight, finessAndHandle,
                uniformityOfMicron, uniformityOfLenght, uniformityOfColor, character, stapleTypeDesity, brightness, lackOfGuardHair, lackOfImpurities);

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
        assertEquals(15.0f, fleeceShowHuacaya.getCleanFleeceWeight(), delta);
        assertEquals(finessAndHandle, fleeceShowHuacaya.getFinessAndHandle(), delta);
        assertEquals(uniformityOfMicron, fleeceShowHuacaya.getUniformityOfMicron(), delta);
        assertEquals(uniformityOfLenght, fleeceShowHuacaya.getUniformityOfLenght(), delta);
        assertEquals(uniformityOfColor, fleeceShowHuacaya.getUniformityOfColor(), delta);
        assertEquals(character, fleeceShowHuacaya.getCharacter(), delta);
        assertEquals(stapleTypeDesity, fleeceShowHuacaya.getStapleTypeDesity(), delta);
        assertEquals(brightness, fleeceShowHuacaya.getBrightness(), delta);
        assertEquals(lackOfGuardHair, fleeceShowHuacaya.getLackOfGuardHair(), delta);
        assertEquals(lackOfImpurities, fleeceShowHuacaya.getLackOfImpurities(), delta);
        assertEquals(100f, fleeceShowHuacaya.getTotal(), delta);
    }
}
