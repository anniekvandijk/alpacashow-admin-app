package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.IThelper;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationRepositoryServiceTest {

    private ApplicationRepositoryService service = new ApplicationRepositoryService();
    private IThelper helper = new IThelper(service);
    private ShowEventRepository showEventRepository;
    private ParticipantRepository participantRepository;
    private AnimalRepository animalRepository;
    private ShowEventAnimalRepository showEventAnimalRepository;
    private FleeceWeightPointsRepository fleeceWeightPointsRepository;

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

        assertEquals(5, participantRepository.getAllParticipants().size());
        assertEquals("Test participant 2", participantRepository.getParticipantByKeySet("Test participant 2").getName());
        assertEquals("Testfarm 2", participantRepository.getParticipantByKeySet("Test participant 2").getFarmName());

    }

    @Test
    public void getAnimalRepo() throws IOException {

        animalRepository = service.loadAnimalRepository();

        assertEquals(5, animalRepository.getAllAnimals().size());
        assertEquals("Alpaca3", animalRepository.getAnimalByKeySet("4444").getName());

    }

    @Test
    public void getShowEventAnimalRepo() throws IOException {

        showEventAnimalRepository = service.loadShowEventAnimalRepository();

        assertEquals(6, showEventAnimalRepository.getAllShowEventAnimals().size());

    }

    @Test @Ignore
    public void getFleeceWeightPointsRepo() throws IOException {

        // FIXME : er wordt niet alles geladen? Hoe langzamer de methode, hoe minder er geladen wordt.

        fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();

       assertEquals(500, fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet().size());
    }
}
