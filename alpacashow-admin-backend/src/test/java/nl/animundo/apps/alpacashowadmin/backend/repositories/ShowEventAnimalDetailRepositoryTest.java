package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.showeventregistration.ShowEventAnimalDetail;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventAnimalDetailRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalDetailRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventAnimalDetail() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(sheerDate, beforeSheerDate);
        ShowEventAnimalDetailRepository showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();

        assertEquals(0, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());

        showEventAnimalDetailRepository.add(showEventAnimalDetail);

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12345";

        assertEquals(1, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());
        assertEquals(sheerDate, showEventAnimalDetailRepository.getShowEventAnimalDetailByKeySet(key).getSheerDate());
    }

    @Test
    public void AddShowEventAnimalDetailWithSameKey() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimalDetail showEventAnimalDetail1 = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);
        ShowEventAnimalDetail showEventAnimalDetail2 = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalDetailRepository showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();

        showEventAnimalDetailRepository.add(showEventAnimalDetail1);
        showEventAnimalDetailRepository.add(showEventAnimalDetail2);
    }

    @Test
    public void deleteShowEventAnimalDetail() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalDetailRepository showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();

        showEventAnimalDetailRepository.add(showEventAnimalDetail);

        assertEquals(1, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12345";

        showEventAnimalDetailRepository.delete(key);

        assertEquals(0, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());
    }

    @Test
    public void deleteShowEventAnimalDetailWithNotKnownKey() {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);
        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalDetailRepository showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();

        showEventAnimalDetailRepository.add(showEventAnimalDetail);

        assertEquals(1, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12346";

        showEventAnimalDetailRepository.delete(key);

        assertEquals(1, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());
        assertEquals(null, showEventAnimalDetailRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownShowEventAnimalDetail() {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimalDetail showEventAnimalDetail = new ShowEventAnimalDetail(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalDetailRepository showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();

        showEventAnimalDetailRepository.add(showEventAnimalDetail);

        assertEquals(1, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12346";
        showEventAnimalDetailRepository.getShowEventAnimalDetailByKeySet(key).getAnimalKey();

    }

    @Test
    public void getAllShowEventAnimalDetailsByKeySet() {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String showEventKey1 = "2030-05-01_HALTERSHOW";
        String showEventKey2 = "2030-05-01_FLEECESHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimalDetail showEventAnimalDetail1 = new ShowEventAnimalDetail(showEventKey1, participantKey, animalKey,
                sheerDate, beforeSheerDate);
        ShowEventAnimalDetail showEventAnimalDetail2 = new ShowEventAnimalDetail(showEventKey2, participantKey, animalKey,
                sheerDate, beforeSheerDate);;
        ShowEventAnimalDetailRepository showEventAnimalDetailRepository = new ShowEventAnimalDetailRepository();

        showEventAnimalDetailRepository.add(showEventAnimalDetail1);
        showEventAnimalDetailRepository.add(showEventAnimalDetail2);

        assertEquals(2, showEventAnimalDetailRepository.getAllShowEventAnimalDetailsByKeySet().size());
        assertTrue(showEventAnimalDetailRepository.getAllShowEventAnimalDetailsByKeySet().contains("2030-05-01_HALTERSHOW_Deelnemer 1_12345"));
        assertTrue(showEventAnimalDetailRepository.getAllShowEventAnimalDetailsByKeySet().contains("2030-05-01_FLEECESHOW_Deelnemer 1_12345"));

    }
}


