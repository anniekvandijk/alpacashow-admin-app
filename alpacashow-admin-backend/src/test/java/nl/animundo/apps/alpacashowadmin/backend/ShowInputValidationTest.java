package nl.animundo.apps.alpacashowadmin.backend;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ShowInputValidationTest {

    /*********************************
     * SHOWNAME TESTS
     ********************************/

    // TODO: Vraag: Moeten deze testen niet naar een test voor parsing Json?

    @Test
    public void showNameNotEmpty() {

        // een Shownaam mag niet leeg zijn. Dan een foutmelding

        String error = "Er is geen shownaam opgegeven";



    }

    @Test
    public void showNameMaxCharacter() {

        // het maximum aantal karakers = 60
        int MaxCharacters = 60;
        int showNameCharacters = 0;

        // process json call and get showName
        assertTrue (showNameCharacters <= MaxCharacters );

    }

    @Test
    public void showNameIsString() {

        // De naam moet van het type String zijn. Of is deze test overbodig?
    }

    @Test
    public void showNameTrim() {

        // spaties voor een achter moeten getrimd worden.
        // Als er geen waarde overblijft na trimmen, dan een foutmelding

    }
}
