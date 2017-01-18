package nl.animundo.apps.alpacashowadmin.backend.domain;

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
}
