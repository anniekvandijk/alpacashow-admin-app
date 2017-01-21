package nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.AnimalShowDetail;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AnimalShowDetailTest {

    private LocalDate sheerDate;
    private LocalDate beforeSheerDate;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void newFullAnimalShowDetail() {

        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = LocalDate.of(2015, 4, 27);

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);

        assertEquals(sheerDate, animalShowDetail.getSheerDate());
        assertEquals(beforeSheerDate, animalShowDetail.getBeforeSheerDate());
    }

    @Test
    public void newAnimalShowDetailOnlySheerDate() {

        sheerDate = LocalDate.of(2016, 5, 1);
        beforeSheerDate = null;

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);

        assertEquals(sheerDate, animalShowDetail.getSheerDate());
        assertEquals(beforeSheerDate, animalShowDetail.getBeforeSheerDate());
    }

    @Test
    public void newAnimalShowDetailNoSheerDates() {

        sheerDate = null;
        beforeSheerDate = null;

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);

        assertEquals(sheerDate, animalShowDetail.getSheerDate());
        assertEquals(beforeSheerDate, animalShowDetail.getBeforeSheerDate());
    }

    @Test
    public void newAnimalShowDetailOnlyBeforeSheerDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate has to be filled when you also have a before sheerdate");

        sheerDate = null;
        beforeSheerDate = LocalDate.of(2015, 4, 27);

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateToday() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate is today or later");

        sheerDate = LocalDate.now();
        beforeSheerDate = null;

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateAfterToday() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate is today or later");

        sheerDate = LocalDate.now().plusMonths(6);
        beforeSheerDate = null;

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateAndBeforeSheerDateSame() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sheerdate and before sheerdate can not be the same");

        sheerDate = LocalDate.now().minusMonths(6);
        beforeSheerDate = LocalDate.now().minusMonths(6);

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);
    }

    @Test
    public void SheerDateBeforeBeforeSheerDate() {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Before sheerdate is after sheerdate");

        sheerDate = LocalDate.now().minusMonths(12);
        beforeSheerDate = LocalDate.now().minusMonths(6);

        AnimalShowDetail animalShowDetail = new AnimalShowDetail(sheerDate, beforeSheerDate);
    }
}
