package nl.animundo.apps.alpacashowadmin.backend.services.application;

import nl.animundo.apps.alpacashowadmin.backend.context.RepositoryContext;
import nl.animundo.apps.alpacashowadmin.backend.domain.Animal;
import nl.animundo.apps.alpacashowadmin.backend.repositories.Repository;
import org.junit.*;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ApplicationRepositoryServiceTest {

    private RepositoryContext context;
    private ApplicationRepositoryService service;

    @Before
    public void before() throws IOException {
        this.context = new RepositoryContext();
        service = new ApplicationRepositoryService(context);
        context.showEventRepository = service.loadShowEventRepository();
        context.participantRepository = service.loadParticipantRepository();
        Repository<Animal> animalRepo = service.loadAnimalRepository();
        context.showEventAnimalDetailRepository = service.loadShowEventAnimalDetailRepository();
        context.fleeceWeightPointsRepository = service.loadFleeceWeightPointsRepository();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getShowEventRepo() throws IOException {

        assertEquals(4, context.showEventRepository.getAllShowEvents().size());
        assertEquals("Haltershow ShowEvent met deelnemers en dieren", context.showEventRepository.getShowEventById("e794e4cc-35fc-4370-8e22-b9ef15580ff8").getName());
    }

    @Test
    public void getParticipantRepo() throws IOException {

        assertEquals(5, context.participantRepository.getAllParticipants().size());
        assertEquals("Test participant 2", context.participantRepository.getParticipantById("6226e9be-ca68-4dac-99df-100a88e6bb05").getName());
     }

    @Test
    public void getAnimalRepo() throws IOException {

        assertEquals(5, context.animalRepository.getAllAnimals().size());
        assertEquals("Alpaca1", context.animalRepository.getAnimalById("a1d81f18-e47e-4f0a-b7f5-28b9eb42fa8e").getName());
    }

    @Test
    public void getShowEventAnimalDetailRepo() throws IOException {

        assertEquals(6, context.showEventAnimalDetailRepository.getAllShowEventAnimalDetails().size());
    }

    @Test
    public void getFleeceWeightPointsRepo() throws IOException {

       assertEquals(450, context.fleeceWeightPointsRepository.getAllFleeceWeightPointsByKeySet().size());
       assertEquals(450, context.fleeceWeightPointsRepository.getAllFleeceWeightPoints().size());
    }
}
