package nl.animundo.apps.alpacashowadmin.backend.repositories;

import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEvent;
import nl.animundo.apps.alpacashowadmin.backend.domain.ShowEventRegistration;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.AgeClass;
import nl.animundo.apps.alpacashowadmin.backend.domain.enums.ShowType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShowEventRegistrationRepositoryTest {
    private static Logger logger = LoggerFactory.getLogger(ShowEventRegistrationRepositoryTest.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addShowEventRegistration() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 100;
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                                                        ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

        assertEquals(0, showEventRegistrationRepository.getAllShowEventRegistrations().size());

        showEventRegistrationRepository.add(showEventRegistration);

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12345";

        assertEquals(1, showEventRegistrationRepository.getAllShowEventRegistrations().size());
        assertEquals(100, showEventRegistrationRepository.getShowEventRegistrationByKeySet(key).getShowClassCode());
    }

    @Test
    public void AddShowEventRegistrationWithSameKey() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 100;
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventRegistration showEventRegistration1 = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistration showEventRegistration2 = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);

        ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

        showEventRegistrationRepository.add(showEventRegistration1);
        showEventRegistrationRepository.add(showEventRegistration2);
    }

    @Test
    public void deleteShowEventRegistration() {

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 100;
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

        showEventRegistrationRepository.add(showEventRegistration);

        assertEquals(1, showEventRegistrationRepository.getAllShowEventRegistrations().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12345";

        showEventRegistrationRepository.delete(key);

        assertEquals(0, showEventRegistrationRepository.getAllShowEventRegistrations().size());
    }

    @Test
    public void deleteShowEventRegistrationWithNotKnownKey() {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 100;
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

        showEventRegistrationRepository.add(showEventRegistration);

        assertEquals(1, showEventRegistrationRepository.getAllShowEventRegistrations().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12346";

        showEventRegistrationRepository.delete(key);

        assertEquals(1, showEventRegistrationRepository.getAllShowEventRegistrations().size());
        assertEquals(null, showEventRegistrationRepository.delete(key).toString());
    }

    @Test
    public void getNotKnownShowEventRegistration() {

        exception.expect(NullPointerException.class);

        String showEventKey = "2030-05-01_HALTERSHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 100;
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventRegistration showEventRegistration = new ShowEventRegistration(showEventKey, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

        showEventRegistrationRepository.add(showEventRegistration);

        assertEquals(1, showEventRegistrationRepository.getAllShowEventRegistrations().size());

        String key = "2030-05-01_HALTERSHOW_Deelnemer 1_12346";
        showEventRegistrationRepository.getShowEventRegistrationByKeySet(key).getAnimalKey();

    }

    @Test
    public void getAllShowEventRegistrationsByKeySet() {

        ShowEventRepository showEventRepository = new ShowEventRepository();

        String showEventKey1 = "2030-05-01_HALTERSHOW";
        String showEventKey2 = "2030-05-01_FLEECESHOW";
        String participantKey = "Deelnemer 1";
        String animalKey = "12345";
        AgeClass ageClass = AgeClass.JUNIOR;
        int showClassCode = 100;
        LocalDate sheerDate = LocalDate.of(2016, 5, 15);
        LocalDate beforeSheerDate = LocalDate.of(2015, 4, 15);

        ShowEventRegistration showEventRegistration1 = new ShowEventRegistration(showEventKey1, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistration showEventRegistration2 = new ShowEventRegistration(showEventKey2, participantKey, animalKey,
                ageClass, showClassCode, sheerDate, beforeSheerDate);
        ShowEventRegistrationRepository showEventRegistrationRepository = new ShowEventRegistrationRepository();

        showEventRegistrationRepository.add(showEventRegistration1);
        showEventRegistrationRepository.add(showEventRegistration2);

        assertEquals(2, showEventRegistrationRepository.getAllShowEventRegistrationsByKeySet().size());
        assertTrue(showEventRegistrationRepository.getAllShowEventRegistrationsByKeySet().contains("2030-05-01_HALTERSHOW_Deelnemer 1_12345"));
        assertTrue(showEventRegistrationRepository.getAllShowEventRegistrationsByKeySet().contains("2030-05-01_FLEECESHOW_Deelnemer 1_12345"));

    }
}


