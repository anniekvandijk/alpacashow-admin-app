package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class InputValidationServiceTest {

// TODO add test for null and not trimmed input

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void noInstanceTest() {

//        reflection?
//        exception.expect(InstantiationException.class);
//        exception.expectMessage("Instances of this type are forbidden!");
    }

    @Test
    public void fieldNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Field name can not be empty");

        String field = "";
        InputValidationService.requiredFields(field, "name");
}
