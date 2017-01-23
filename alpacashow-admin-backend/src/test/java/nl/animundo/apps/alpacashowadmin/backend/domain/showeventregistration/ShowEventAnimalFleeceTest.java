package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ShowEventAnimalFleeceTest {

    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void SheerDateToday() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate is today or later");

        sheerDate = LocalDate.now();
        beforeSheerDate = null;

        ShowEventAnimalFleece showEventAnimalFleece = new ShowEventAnimalFleece(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateAfterToday() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate is today or later");

        sheerDate = LocalDate.now().plusMonths(6);
        beforeSheerDate = null;

        ShowEventAnimalFleece showEventAnimalFleece = new ShowEventAnimalFleece(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateAndBeforeSheerDateSame() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate and before sheerdate can not be the same");

        sheerDate = LocalDate.now().minusMonths(6);
        beforeSheerDate = LocalDate.now().minusMonths(6);

        ShowEventAnimalFleece showEventAnimalFleece = new ShowEventAnimalFleece(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateBeforeBeforeSheerDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Before sheerdate is after sheerdate");

        sheerDate = LocalDate.now().minusMonths(12);
        beforeSheerDate = LocalDate.now().minusMonths(6);

        ShowEventAnimalFleece showEventAnimalFleece = new ShowEventAnimalFleece(sheerDate, beforeSheerDate);
    }
}
