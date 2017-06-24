package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.IThelper;
import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.repositories.*;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Anniek van Dijk on 7-8-2016.
 */
public class ApplicationRepositoryServiceTest {

    private RepositoryContext context;
    private ApplicationRepositoryService service = new ApplicationRepositoryService(context);
    private IThelper helper = new IThelper(context, service);

    @Before
    public void AddShowEvents() throws IOException {
        helper.AddCompleteShowEvent();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getShowEventRepo() throws IOException {

        context.showEventRepository = service.loadShowEventRepository();

        assertEquals(4, context.showEventRepository.getAllShowEvents().size());
        assertEquals("Haltershow ShowEvent met deelnemers en dieren", context.showEventRepository.getShowEventById("2a88e547-d63b-4ec0-8344-7be454701b28").getName());

    }

    @Test
    public void getParticipantRepo() throws IOException {

        context.participantRepository = service.loadParticipantRepository();

        assertEquals(5, context.participantRepository.getAllParticipants().size());
        assertEquals("Test participant 2", context.participantRepository.getParticipantById("947e95f8-3506-42b4-818c-cfff3435aa17").getName());
        assertEquals("Testfarm 2", context.participantRepository.getParticipantById("947e95f8-3506-42b4-818c-cfff3435aa17").getFarmName());

    }

    @Test
    public void getAnimalRepo() throws IOException {

        context.animalRepository = service.loadAnimalRepository();

        assertEquals(5, context.animalRepository.getAllAnimals().size());
        assertEquals("Alpaca1", context.animalRepository.getAnimalById("869c1d60-d0f0-4f6a-b4d0-4326a7165b12").getName());

    }

    @Test
    public void getShowEventAnimalDetailRepo() throws IOException {

        context.showEventAnimalDetailRepository = service.loadShowEventAnimalDetailRepository();

        assertEquals(6, context.showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());

    }

    @Test
    public void getFleeceWeightPointsRepo() throws IOException {

        context.fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();

       assertEquals(450, context.fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet().size());
       assertEquals(450, context.fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());
    }
}
