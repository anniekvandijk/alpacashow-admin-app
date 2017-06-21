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
    private ShowEventAnimalDetailRepository showEventAnimalDetailRepository;
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
        assertEquals("Haltershow ShowEvent met deelnemers en dieren", showEventRepository.getShowEventById("2a88e547-d63b-4ec0-8344-7be454701b28").getName());

    }

    @Test
    public void getParticipantRepo() throws IOException {

        participantRepository = service.loadParticipantRepository();

        assertEquals(5, participantRepository.getAllParticipants().size());
        assertEquals("Test participant 2", participantRepository.getParticipantById("947e95f8-3506-42b4-818c-cfff3435aa17").getName());
        assertEquals("Testfarm 2", participantRepository.getParticipantById("947e95f8-3506-42b4-818c-cfff3435aa17").getFarmName());

    }

    @Test
    public void getAnimalRepo() throws IOException {

        animalRepository = service.loadAnimalRepository();

        assertEquals(5, animalRepository.getAllAnimals().size());
        assertEquals("Alpaca1", animalRepository.getAnimalById("869c1d60-d0f0-4f6a-b4d0-4326a7165b12").getName());

    }

    @Test
    public void getShowEventAnimalDetailRepo() throws IOException {

        showEventAnimalDetailRepository = service.loadShowEventAnimalDetailRepository();

        assertEquals(6, showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());

    }

    @Test
    public void getFleeceWeightPointsRepo() throws IOException {

        fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();

       assertEquals(450, fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet().size());
       assertEquals(450, fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());
    }
}
