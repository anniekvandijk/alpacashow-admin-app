package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.IThelper;
import nl.animundo.apps.alpacashowadmin.backend.repositories.AnimalRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ParticipantRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRegistrationRepository;
import nl.animundo.apps.alpacashowadmin.backend.repositories.ShowEventRepository;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationRepositoryServiceTest {

    private IThelper helper = new IThelper();
    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventRegistrationRepository showEventRegistrationRepository;

    @Before
    public void AddShowEvents() throws IOException {
        helper.AddCompleteShowEvent();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getShowEventRepo() throws IOException {

        showEventRepository = service.loadShowEventRepository();

        assertEquals(4, showEventRepository.getAllShowEvents().size());
        assertEquals("Fleeceshow ShowEvent met deelnemers en dieren", showEventRepository.getShowEventByKeySet("2030-06-15_FLEECESHOW").getName());

    }

    @Test
    public void getParticipantRepo() throws IOException {

        participantRepository = service.loadParticipantRepository();

        assertEquals(4, participantRepository.getAllParticipants().size());
        assertEquals("Test participant 2", participantRepository.getParticipantByKeySet("Test participant 2").getName());
        assertEquals("Testfarm 2", participantRepository.getParticipantByKeySet("Test participant 2").getFarmName());

    }

    @Test
    public void getAnimalRepo() throws IOException {

        animalRepository = service.loadAnimalRepository();

        assertEquals(4, animalRepository.getAllAnimals().size());
        assertEquals("Alpaca3", animalRepository.getAnimalByKeySet("4444").getName());

    }

    @Test
    public void getShowEventRegistrationRepo() throws IOException {

        showEventRegistrationRepository = service.loadShowEventRegistrationRepository();

        assertEquals(4, showEventRegistrationRepository.getAllShowEventRegistrations().size());

    }
}
