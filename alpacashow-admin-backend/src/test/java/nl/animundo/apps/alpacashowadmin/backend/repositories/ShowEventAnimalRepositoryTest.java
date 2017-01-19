package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventAnimal;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventAnimalRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventAnimalRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventAnimal() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimal showEventAnimal = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                                                        sheerDate, beforeSheerDate);
        ShowEventAnimalRepository showEventAnimalRepository = new ShowEventAnimalRepository();

        assertEquals(0, showEventAnimalRepository.getAllShowEventAnimals().size());

        showEventAnimalRepository.add(showEventAnimal);

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12345";

        assertEquals(1, showEventAnimalRepository.getAllShowEventAnimals().size());
        assertEquals(sheerDate, showEventAnimalRepository.getShowEventAnimalByKeySet(key).getSheerDate());
    }

    @Test
    public void AddShowEventAnimalWithSameKey() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimal showEventAnimal1 = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);
        ShowEventAnimal showEventAnimal2 = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalRepository showEventAnimalRepository = new ShowEventAnimalRepository();

        showEventAnimalRepository.add(showEventAnimal1);
        showEventAnimalRepository.add(showEventAnimal2);
    }

    @Test
    public void deleteShowEventAnimal() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimal showEventAnimal = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalRepository showEventAnimalRepository = new ShowEventAnimalRepository();

        showEventAnimalRepository.add(showEventAnimal);

        assertEquals(1, showEventAnimalRepository.getAllShowEventAnimals().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12345";

        showEventAnimalRepository.delete(key);

        assertEquals(0, showEventAnimalRepository.getAllShowEventAnimals().size());
    }

    @Test
    public void deleteShowEventAnimalWithNotKnownKey() {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);
        ShowEventAnimal showEventAnimal = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalRepository showEventAnimalRepository = new ShowEventAnimalRepository();

        showEventAnimalRepository.add(showEventAnimal);

        assertEquals(1, showEventAnimalRepository.getAllShowEventAnimals().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12346";

        showEventAnimalRepository.delete(key);

        assertEquals(1, showEventAnimalRepository.getAllShowEventAnimals().size());
        assertEquals(null, showEventAnimalRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownShowEventAnimal() {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimal showEventAnimal = new ShowEventAnimal(showEventKey, participantKey, animalKey,
                sheerDate, beforeSheerDate);

        ShowEventAnimalRepository showEventAnimalRepository = new ShowEventAnimalRepository();

        showEventAnimalRepository.add(showEventAnimal);

        assertEquals(1, showEventAnimalRepository.getAllShowEventAnimals().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12346";
        showEventAnimalRepository.getShowEventAnimalByKeySet(key).getAnimalKey();

    }

    @Test
    public void getAllShowEventAnimalsByKeySet() {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String showEventKey1 = "2030-05-01_HALTERSHOW";
        String showEventKey2 = "2030-05-01_FLEECESHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventAnimal showEventAnimal1 = new ShowEventAnimal(showEventKey1, participantKey, animalKey,
                sheerDate, beforeSheerDate);
        ShowEventAnimal showEventAnimal2 = new ShowEventAnimal(showEventKey2, participantKey, animalKey,
                sheerDate, beforeSheerDate);;
        ShowEventAnimalRepository showEventAnimalRepository = new ShowEventAnimalRepository();

        showEventAnimalRepository.add(showEventAnimal1);
        showEventAnimalRepository.add(showEventAnimal2);

        assertEquals(2, showEventAnimalRepository.getAllShowEventAnimalsByKeySet().size());
        assertTrue(showEventAnimalRepository.getAllShowEventAnimalsByKeySet().contains("2030-05-01_HALTERSHOW_Deelnemer 1_12345"));
        assertTrue(showEventAnimalRepository.getAllShowEventAnimalsByKeySet().contains("2030-05-01_FLEECESHOW_Deelnemer 1_12345"));

    }
}


