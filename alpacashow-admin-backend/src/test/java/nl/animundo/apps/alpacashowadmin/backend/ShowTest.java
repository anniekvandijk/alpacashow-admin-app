package nl.animundo.apps.alpacashowadmin.backend;

import nl.animundo.apps.alpacashowadmin.backend.domain.Show;
import org.junit.*;
import java.time.*;
import static org.junit.Assert.*;

/**
 * Created by Anniek van Dijk on 29-5-2016.
 */
public class ShowTest {

    String showName;
    LocalDate showDate;
    LocalDate showCloseDate;
    String showLocation;
    String showJudge;

    int nrOfObjectsInClass = 0;

    /*********************************
     * GENERAL TESTS
     ********************************/

    @Test
    public void  newShow() {

        // Er kan een nieuwe Show object worden aangemaakt

        // TODO: Create datehelper json date > jave date  and unittests for the datehelper
        // TODO: json bericht gebruiken voor testen of niet?

        showName = "Test show";
        showDate = LocalDate.of(2016,5,1);
        showCloseDate = LocalDate.of(2016,1,1);
        showLocation = "Surhuisterveen";
        showJudge = "Test Judge";

        Show show = new Show(showName, showDate, showCloseDate, showLocation, showJudge);

        assertEquals("Test show", show.getShowName());
        assertEquals(LocalDate.of(2016,5,1), show.getShowDate());
        assertEquals(LocalDate.of(2016,1,1), show.getShowCloseDate());
        assertEquals("Surhuisterveen", show.getShowLocation());
        assertEquals("Test Judge", show.getShowJudge());
    }

    @Test
    public void  noDuplicateShowObjects() {

        // Er kunnen nooit meer objecten zijn dan 1 (voor nu)

        Show show = new Show(showName, showDate, showCloseDate, showLocation, showJudge);
        Show showduplicate = new Show(showName, showDate, showCloseDate, showLocation, showJudge);

        // TODO: Vraag: Hoe handig is het om deze objecten te tellen in een unittest?

    }

    /*********************************
     * SHOWNAME TESTS
     ********************************/

    // TODO: Vraag: Moeten deze testen niet naar een test voor parsing Json?

    @Test
    public void showNameNotEmpty() {

        // een Shownaam mag niet leeg zijn. Dan een foutmelding

        showName = null;
        showDate = LocalDate.of(2016,5,1);
        showCloseDate = LocalDate.of(2016,1,1);
        showLocation = "Surhuisterveen";
        showJudge = "Test Judge";

        String error = "Er is geen shownaam opgegeven";



    }

    @Test
    public void showNameMaxCharacter() {

        // het maximum aantal karakers = 60
        int MaxCharacters = 60;
        int showNameCharacters = 0;

        showName = "Test show met aantal ";
        showDate = LocalDate.of(2016,5,1);
        showCloseDate = LocalDate.of(2016,1,1);
        showLocation = "Surhuisterveen";
        showJudge = "Test Judge";

        Show show = new Show(showName, showDate, showCloseDate, showLocation, showJudge);
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
