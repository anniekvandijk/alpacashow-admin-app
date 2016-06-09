package nl.animundo.apps.alpacashowadmin.backend.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

public class InputValidationServiceTest {

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
        exception.expectMessage("Veld veldnaam mag niet leeg zijn");

        String field = "";
        InputValidationService.requiredFields(field, "veldnaam");
    }

    @Test
    public void fieldWithSpacesNotEmpty() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Veld veldnaam mag niet leeg zijn");

        String field = "      ";
        InputValidationService.requiredFields(field, "veldnaam");
    }
}
