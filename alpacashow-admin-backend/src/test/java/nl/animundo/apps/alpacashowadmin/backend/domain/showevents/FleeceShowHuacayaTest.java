package nl.animundo.apps.alpacashowadmin.backend.domain.showevents;

import nl.animundo.apps.alpacashowadmin.backend.domain.enums.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

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

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newFleeceShowHuacayaMaxPoints() {

        showEventKey = "2030-06-15_FLEECESHOW";
        participantKey = "Test participant 1";
        animalKey = "Alpaca1";
        startNumber = 1;
        dateOfBirth = LocalDate.of(2015, 4, 12);
        present = true;
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

            // AgeSexClass
            // cleanFleeceWeight
            // Total

        FleeceShowHuacaya fleeceShowHuacaya = new FleeceShowHuacaya(showEventKey, participantKey, animalKey, present, startNumber, dateOfBirth,
                breed, null, sex, color, 0, sheerDate, beforeSheerdate, fleeceWeight, 0, 0f, finessAndHandle,
                uniformityOfMicron, uniformityOfLenght, uniformityOfColor, character, stapleTypeDesity, brightness, lackOfGuardHair, lackOfImpurities, 0f, 0f);

        

    }
}
